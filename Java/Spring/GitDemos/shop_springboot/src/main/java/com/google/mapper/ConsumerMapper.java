package com.google.mapper;

import com.google.entity.Consumer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsumerMapper {
    Consumer find(Consumer consumer);
    int delete(Consumer consumer);
}
