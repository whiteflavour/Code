package com.google.model;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Session POJO. Add, remove, update session id.
 *
 * @author Liao, wrox
 * @date 2021-3-14
 */
public class SessionRegistry {
    private static final Map<String, HttpSession> SESSIONS = new HashMap<>();

    public SessionRegistry() {}

    public static void addSession(HttpSession session) {
        SESSIONS.put(session.getId(), session);
    }

    public static void removeSession(HttpSession session) {
        SESSIONS.remove(session.getId());
    }

    public static void updateSessionId(HttpSession session, String oldSessionId) {
        synchronized (SESSIONS) {
            SESSIONS.remove(oldSessionId);
            addSession(session);
        }
    }

    public static int getNumberOfSessions() {
        return SESSIONS.size();
    }

    public static List<HttpSession> getSessions() {
        return new ArrayList<>(SESSIONS.values());
    }
}
