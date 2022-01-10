package com.google.service;

import com.google.entity.Consumer;

public interface IOnlineService {
    int addOnlineUsers(String name);
    int deleteOnlineUsers(String name);
    int clear();
    Consumer findOnlineUser(String name);
}
