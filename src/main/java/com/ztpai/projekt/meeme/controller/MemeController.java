package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.Meme;
import com.ztpai.projekt.meeme.data.dto.MemeDto;
import com.ztpai.projekt.meeme.data.dto.RegisterDto;
import com.ztpai.projekt.meeme.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MemeController {
    @Autowired
    MemeRepository repository;

    @PostMapping("/meme")
    public int addMeme(@ModelAttribute("MemeDto") MemeDto memeDto){
        /*return repository.addMeme(new Meme(
                params.get("text"),
                params.get("fileName"),
                Integer.parseInt(params.get("userID")),
                Integer.parseInt(params.get("communityID"))
        ));*/

        return 1;
    }

/*    @DeleteMapping("/meme/{id}")
    public int removeMeme(@PathVariable("id") int id){
        return repository.removeMeme(id);
    }

    @PostMapping("/meme/like/{id}")
    public int likeMeme(@PathVariable("id") int id){
        return repository.rateMeme(id, 1);
    }

    @PostMapping("/meme/dislike/{id}")
    public int dislikeMeme(@PathVariable("id") int id){
        return repository.rateMeme(id, -1);
    }

    @PostMapping("/meme/favourite/{id}")
    public int switchFavouriteMeme(@PathVariable("id") int id){
        return repository.switchFavouriteMeme(id);
    }

    @GetMapping("/meme/favourite")
    public List<Meme> getFavourite(){
        return repository.getFavourite();
    }

    @GetMapping("/meme/last")
    public List<Meme> getLast(){
        return repository.getLast();
    }

    @GetMapping("/meme/top")
    public List<Meme> getTop(){
        return repository.getTop();
    }*/
}
