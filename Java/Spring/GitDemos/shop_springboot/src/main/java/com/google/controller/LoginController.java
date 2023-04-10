package com.google.controller;

import com.google.entity.Consumer;
import com.google.entity.Goods;
import com.google.service.IConsumerService;
import com.google.service.IGoodsService;
import com.google.service.IOnlineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @Resource
    private IConsumerService iConsumerService;
    @Resource
    private IGoodsService iGoodsService;
    @Resource
    private IOnlineService iOnlineService;

    @PostMapping("/login")
    public String login(Consumer consumer, RedirectAttributes redirectAttributes, Model model) {
        Consumer cs = iConsumerService.login(consumer);
        if (cs == null) {
            model.addAttribute("err", "No such consumer or password error");
            return "login";
        }
        iOnlineService.addOnlineUsers(cs.getUsername());
        List<Goods> goodsList = iGoodsService.list();
        redirectAttributes.addFlashAttribute("consumer", cs);
        redirectAttributes.addFlashAttribute("goodsList", goodsList);
        return "redirect:/afterLogin";
    }
}
