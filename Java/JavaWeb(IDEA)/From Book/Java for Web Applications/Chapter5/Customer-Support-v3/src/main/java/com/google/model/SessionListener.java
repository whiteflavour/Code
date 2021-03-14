package com.google.model;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Session listener.
 *
 * @author Liao, wrox
 * @date 2021-3-14
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener {
    private final DateFormat formatter = new SimpleDateFormat("EEE, yyyy-MM-dd HH:mm:ss");

    public SessionListener() {}

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println(this.getDate() + ": Session " + session.getId() + " is created. ");
        SessionRegistry.addSession(session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println(this.getDate() + ": Session " + session.getId() + " is destroyed. ");
        SessionRegistry.removeSession(session);
    }

    @Override
    public void sessionIdChanged(HttpSessionEvent httpSessionEvent, String s) {
        HttpSession session = httpSessionEvent.getSession();
        System.out.println(this.getDate() + ": Session ID " + s + " changed to " + session.getId());
        SessionRegistry.updateSessionId(session, s);
    }

    private String getDate() {
        return formatter.format(Calendar.getInstance().getTime());
    }
}
