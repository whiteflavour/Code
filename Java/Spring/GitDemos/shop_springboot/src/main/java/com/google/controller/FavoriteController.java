package com.google.controller;

import com.google.config.LoginRequired;
import com.google.entity.Consumer;
import com.google.entity.Goods;
import com.google.service.IConsumerService;
import com.google.service.IFavoriteService;
import com.google.service.IOnlineService;
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
    @Resource
    private IConsumerService iConsumerService;
    @Resource
    private IOnlineService iOnlineService;
    private final Goods goods;

    /**
     * Constructor Injection(The official manual recommended
     * this rather than setter injection, and I have tried the
     * setter injection, it doesn't work.)
     *
     * @param goods object to be injected
     */
    public FavoriteController(Goods goods) {
        this.goods = goods;
    }

    @GetMapping("/favorite")
    public String favoritePage(@RequestParam("name")String name, @RequestParam("price")double price, Model model) {
        Consumer consumer = iOnlineService.findOnlineUser(name);
        if (consumer == null) {
            return "redirect:/login";
        }
        goods.setName(name);
        goods.setPrice(price);
        iFavoriteService.addToFavorite(goods);
        List<Goods> favorites = iFavoriteService.showFavorite();
        model.addAttribute("favorites", favorites);
        return "favorite";
    }

    @GetMapping("/deleteFavorite")
    public String deleteFavorite(@RequestParam("name")String name, @RequestParam("price")double price, Model model) {
        goods.setName(name);
        goods.setPrice(price);
        iFavoriteService.deleteFavorite(goods);
        List<Goods> favorites = iFavoriteService.showFavorite();
        model.addAttribute("favorites", favorites);
        return "favorite";
    }
}
