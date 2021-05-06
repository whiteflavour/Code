package com.google.controller;

import com.google.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过 DispatcherServlet 后进入该 Controller.
 *
 * @author Liao, telusko
 * @date 2021-4-18
 */
@Controller
public class HomeController {
    // 根目录映射，根目录访问该方法。
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("add")
    public String add(@ModelAttribute Alien alien) {
        return "result";
    }
}
