package com.google.service;

import com.google.entity.Goods;

import java.util.List;

public interface IFavoriteService {
    int addToFavorite(Goods goods);
    List<Goods> showFavorite();
    int deleteFavorite(Goods goods);
    int clear();
}
