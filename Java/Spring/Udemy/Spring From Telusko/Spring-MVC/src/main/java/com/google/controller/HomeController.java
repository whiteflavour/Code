package com.google.controller;

import com.google.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * 控制器。
 *
 * @author Liao, telusko
 * @date 2021-4-19
 */
@Controller
public class HomeController {
    @ModelAttribute
    public void modelData(Model model) {
        model.addAttribute("name", "Aliens");
   }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    /**
     * 从表单中读取数据添加至 Alien 中。
     *
     * @param alien 要添加属性的目标对象
     * @return 显示该对象的页面
     */
    @RequestMapping("add")
    public String add(@ModelAttribute Alien alien) {
        return "result";
    }

    /**
     * 显示所有的 Alien 对象
     *
     * @param model 对象的载体
     * @return 显示所有对象的页面
     */
    @GetMapping("getAliens")
    public String getAliens(Model model) {
        List<Alien> aliens = Arrays.asList(new Alien(1, "Rose"), new Alien(2, "Jack"));

        model.addAttribute("aliens", aliens);

        return "aliens";
    }
}
