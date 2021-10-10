package com.google.controller;

import com.google.entity.Goods;
import com.google.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FavoriteController {
    @Resource
    private IFavoriteService iFavoriteService;
    @Autowired
    private Goods goods;

    @GetMapping("/favorite")
    public String favoritePage(@RequestParam("name")String name, @RequestParam("price")double price, Model model) {
        goods.setName(name);
        goods.setPrice(price);
        iFavoriteService.addToFavorite(goods);
        List<Goods> favorites = iFavoriteService.showFavorite();
        model.addAttribute("favorites", favorites);
        return "favorite";
    }

    @GetMapping("/deleteFavorite")
    public String deleteFavorite(Model model, Goods goods) {
        iFavoriteService.deleteFavorite(goods);
        List<Goods> favorites = iFavoriteService.showFavorite();
        model.addAttribute("favorites", favorites);
        return "favorite";
    }
}
