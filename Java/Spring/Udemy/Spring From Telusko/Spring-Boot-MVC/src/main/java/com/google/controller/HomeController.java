package com.google.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelMap model) {
        int sum = num1 + num2;

        model.addAttribute("sum", sum);

        return "result";
    }
}
