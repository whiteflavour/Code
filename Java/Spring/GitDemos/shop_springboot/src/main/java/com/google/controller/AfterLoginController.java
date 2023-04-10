package com.google.controller;

import com.google.entity.Consumer;
import com.google.entity.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class AfterLoginController {
    @GetMapping("/afterLogin")
    public String afterLogin(@ModelAttribute("consumer")Consumer consumer, @ModelAttribute("goodsList")List<Goods> goodsList) {
        return "afterLogin";
    }
}
