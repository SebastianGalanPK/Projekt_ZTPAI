package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.Meme;
import com.ztpai.projekt.meeme.repository.MemeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MemeController {
    MemeRepository repository = new MemeRepository();

    @PostMapping("/addMeme")
    public int addMeme(@RequestBody Map<String, String> params){
        return repository.addMeme(new Meme(
                params.get("text"),
                params.get("fileName"),
                Integer.parseInt(params.get("userID")),
                Integer.parseInt(params.get("communityID"))
        ));
    }

    @DeleteMapping("/meme/{id}")
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

    @GetMapping("/favourite")
    public List<Meme> getFavourite(){
        return repository.getFavourite();
    }

    @GetMapping("/last")
    public List<Meme> getLast(){
        return repository.getLast();
    }

    @GetMapping("/top")
    public List<Meme> getTop(){
        return repository.getTop();
    }
}
