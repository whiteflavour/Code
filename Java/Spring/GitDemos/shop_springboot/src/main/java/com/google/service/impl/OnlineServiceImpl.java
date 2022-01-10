package com.google.service.impl;

import com.google.entity.Consumer;
import com.google.mapper.OnlineMapper;
import com.google.service.IOnlineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OnlineServiceImpl implements IOnlineService {
    @Resource
    private OnlineMapper onlineMapper;

    @Override
    public int addOnlineUsers(String name) {
        return onlineMapper.addOnline(name);
    }

    @Override
    public int deleteOnlineUsers(String name) {
        return onlineMapper.deleteOnline(name);
    }

    @Override
    public int clear() {
        return onlineMapper.deleteAll();
    }

    @Override
    public Consumer findOnlineUser(String name) {
        return onlineMapper.findOnline(name);
    }
}
