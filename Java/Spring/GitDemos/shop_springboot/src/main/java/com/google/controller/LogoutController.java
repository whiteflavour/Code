package com.google.controller;

import com.google.entity.Goods;
import com.google.service.IFavoriteService;
import com.google.service.IGoodsService;
import com.google.service.IOnlineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LogoutController {
    @Resource
    private IGoodsService iGoodsService;
    @Resource
    private IFavoriteService iFavoriteService;
    @Resource
    private IOnlineService iOnlineService;

    @GetMapping("/logout")
    public String logout(@RequestParam("name")String name, RedirectAttributes redirectAttributes) {
        iOnlineService.deleteOnlineUsers(name);
        List<Goods> goodsList = iGoodsService.list();
        iFavoriteService.clear();
        redirectAttributes.addFlashAttribute("goodList", goodsList);
        return "redirect:/";
    }
}
