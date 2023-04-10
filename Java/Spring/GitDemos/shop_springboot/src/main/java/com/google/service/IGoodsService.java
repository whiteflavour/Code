package com.google.service;

import com.google.entity.Goods;

import java.util.List;

public interface IGoodsService {
    List<Goods> list();
    int insert(Goods goods);
    int deleteById(int id);
    int updateById(Goods goods);
    Goods find(int id);
}
