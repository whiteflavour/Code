package com.google.controller;

import com.google.entity.Goods;
import com.google.service.IGoodsService;
import com.google.service.IOnlineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HomeController {
    @Resource
    private IGoodsService iGoodsService;
    @Resource
    private IOnlineService iOnlineService;

    @GetMapping("/")
    public String index(Model model) {
        iOnlineService.clear();
        List<Goods> goodsList = iGoodsService.list();
        model.addAttribute("goodsList", goodsList);
        return "index";
    }
}
