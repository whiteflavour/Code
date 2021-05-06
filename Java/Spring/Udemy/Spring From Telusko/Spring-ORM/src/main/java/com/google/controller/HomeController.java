package com.google.controller;

import com.google.dao.AlienDao;
import com.google.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private AlienDao alienDao;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("getAliens")
    public String getAliens(Model model) {
        model.addAttribute("result", alienDao.getAliens());

        return "showAliens";
    }

    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("result") Alien alien) {
        alienDao.addAlien(alien);

        return "showAliens";
    }

    @PostMapping("getAlien")
    public String getAlien(@RequestParam int id, Model model) {
        model.addAttribute("result", alienDao.getAlien(id));

        return "showAliens";
    }
}
