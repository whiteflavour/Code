package com.google.service.impl;

import com.google.entity.Consumer;
import com.google.mapper.HostHolderMapper;
import com.google.service.IHostHolderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HostHolderImpl implements IHostHolderService {
    @Resource
    HostHolderMapper hostHolderMapper;

    @Override
    public Consumer getConsumer(int id) {
        return hostHolderMapper.find(id);
    }
}
