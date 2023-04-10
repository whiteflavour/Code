package com.google.mapper;

import com.google.entity.Consumer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OnlineMapper {
    int addOnline(String name);
    int deleteOnline(String name);
    int deleteAll();
    Consumer findOnline(String name);
}
