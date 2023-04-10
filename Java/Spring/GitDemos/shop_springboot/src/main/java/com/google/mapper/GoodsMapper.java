package com.google.mapper;

import com.google.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> list();
    int insert(Goods goods);
    int deleteById(int id);
    int updateById(Goods goods);
    Goods find(int id);
}
