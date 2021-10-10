package com.google.service;

import com.google.entity.Consumer;

public interface IConsumerService {
    Consumer login(Consumer consumer);
    int logout(Consumer consumer);
}
