package com.google.mapper;

import com.google.entity.Consumer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HostHolderMapper {
    Consumer find(int id);
}
