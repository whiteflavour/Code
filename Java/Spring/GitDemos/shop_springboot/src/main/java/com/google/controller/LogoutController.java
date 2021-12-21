package com.google.controller;

import com.google.entity.Goods;
import com.google.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LogoutController {
    @Resource
    private IGoodsService iGoodsService;

    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        List<Goods> goodsList = iGoodsService.list();
        redirectAttributes.addFlashAttribute("goodList", goodsList);
        return "redirect:/";
    }
}
