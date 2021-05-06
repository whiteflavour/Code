package com.google.controller;

import com.google.model.Alien;
import com.google.repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring REST test. Responses data, not JSP. ★
 *
 * @author Liao, telusko
 * @date 2021-4-27
 */
@RestController
public class AlienController {
    @Autowired
    private AlienRepo alienRepo;

    @GetMapping(path = "aliens", produces = {"application/json"})
    public List<Alien> getAliens() {
        List<Alien> alienList = alienRepo.findAll();

//        int i = 9 / 0;

        System.out.println("fetching aliens ... ");

        return alienList;
    }

    /**
     * 根据 id 单个查找
     *
     * @param aid aid of alien
     * @return added data of alien
     */
    @GetMapping("alien/{aid}")
    public Alien getAliens(@PathVariable("aid") int aid) {
        Alien alien = alienRepo.findById(aid).orElse(new Alien(0, ""));

        return alien;
    }

    /**
     * 增加一条 Alien 数据。
     *
     * @param alien a data that was added
     * @return the added data
     */
    @PostMapping(path = "alien", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Alien addAlien(@RequestBody Alien alien) {
        alienRepo.save(alien);

        return alien;
    }
}
