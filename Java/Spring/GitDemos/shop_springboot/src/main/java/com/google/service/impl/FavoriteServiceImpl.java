package com.google.service.impl;

import com.google.entity.Goods;
import com.google.mapper.FavoriteMapper;
import com.google.service.IFavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FavoriteServiceImpl implements IFavoriteService {
    @Resource
    private FavoriteMapper favoriteMapper;

    @Override
    public int addToFavorite(Goods goods) {
        return favoriteMapper.insert(goods);
    }

    @Override
    public List<Goods> showFavorite() {
        return favoriteMapper.selectAll();
    }

    @Override
    public int deleteFavorite(Goods goods) {
        return favoriteMapper.delete(goods);
    }

    @Override
    public int clear() {
        return favoriteMapper.deleteAll();
    }
}
