package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.Community;
import com.ztpai.projekt.meeme.data.Meme;
import com.ztpai.projekt.meeme.repository.CommunityRepository;
import com.ztpai.projekt.meeme.repository.MemeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CommunityController {

    CommunityRepository repository = new CommunityRepository();
    MemeRepository memeRepository = new MemeRepository();

    @PostMapping("/addCommunity")
    public int createCommunity(@RequestBody Map<String, String> params){
        return repository.addCommunity(
                params.get("name"),
                params.get("nickname")
        );
    }

    @PostMapping("/toggleCommunity/{id}")
    public void toggleCommunityStatus(@PathVariable("id") int id){

    }

    @GetMapping("/c/{nickname}")
    public List<Meme> getCommunityMemes(@PathVariable("nickname") String nickname){
        return memeRepository.getMemesByCommunityID(getIDByNickname(nickname));
    }

    @GetMapping("/communities/{userID}")
    public List<Community> getCommunities(@PathVariable("userID") int userID){
        return repository.getCommunitiesByUserID(userID);
    }

    private int getIDByNickname(String nickname){
        return repository.getIDByNickname(nickname);
    }
}
