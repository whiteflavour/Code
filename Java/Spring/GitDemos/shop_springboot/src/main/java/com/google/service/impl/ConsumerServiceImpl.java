package com.google.service.impl;

import com.google.entity.Consumer;
import com.google.service.IConsumerService;
import com.google.mapper.ConsumerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ConsumerServiceImpl implements IConsumerService {
    @Resource
    private ConsumerMapper consumerMapper;

    @Override
    public Consumer login(Consumer consumer) {
        return consumerMapper.find(consumer);
    }

    @Override
    public int logout(Consumer consumer) {
        return consumerMapper.delete(consumer);
    }
}
