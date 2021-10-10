package com.google.service.impl;

import com.google.entity.Goods;
import com.google.service.IGoodsService;
import com.google.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> list() {
        return goodsMapper.list();
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int deleteById(int id) {
        return goodsMapper.deleteById(id);
    }

    @Override
    public int updateById(Goods goods) {
        return goodsMapper.updateById(goods);
    }

    @Override
    public Goods find(int id) {
        return goodsMapper.find(id);
    }
}
