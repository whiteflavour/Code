package com.google.controller;

import com.google.model.Alien;
import com.google.repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    AlienRepo alienRepo;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("getAliens")
    public String getAliens(Model model) {
        model.addAttribute("result", alienRepo.findAll());

        return "showAliens";
    }

    @PostMapping("getAlien")
    public String getAlien(@RequestParam int aid, Model model) {
        model.addAttribute("result", alienRepo.getOne(aid));

        return "showAlien";
    }

    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("result") Alien alien) {
        alienRepo.save(alien);

        return "showAlien";
    }

    @PostMapping("delAlien")
    public String delAlien(@RequestParam int aid) {
        alienRepo.deleteById(aid);

        return "result";
    }

    @PostMapping("getByName")
    public String getByName(@RequestParam String aname, Model model) {
        model.addAttribute("result", alienRepo.find(aname));

        return "showAliens";
    }
}
