package com.google.mapper;

import com.google.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    int insert(Goods goods);
    List<Goods> selectAll();
    int delete(Goods goods);
    int deleteAll();
}
