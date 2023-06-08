package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.Community;
import com.ztpai.projekt.meeme.data.Meme;
import com.ztpai.projekt.meeme.data.dto.CommunityDto;
import com.ztpai.projekt.meeme.data.dto.SearchDto;
import com.ztpai.projekt.meeme.repository.CommunityRepository;
import com.ztpai.projekt.meeme.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommunityController {

    @Autowired
    CommunityRepository repository;

    @Autowired
    MemeRepository memeRepository;

    @PostMapping("/community")
    public void createCommunity(@ModelAttribute("CommunityDto") CommunityDto communityDto){
        Community community = new Community(communityDto.getName(), communityDto.getNickname());
        repository.save(community);
    }

    @PostMapping("/communityd/{id}")
    public void toggleCommunityStatus(@PathVariable("id") int id){
        System.out.println("TESTTTTT");
    }

    @GetMapping("/community/{nickname}")
    public List<Meme> getCommunityMemes(@PathVariable("nickname") String nickname){
        return memeRepository.getMemeByCommunity(nickname);
    }

    @PostMapping("/community/search")
    public List<Community> getSearchCommunities(@RequestBody SearchDto searchDto){
        return repository.searchCommunity(searchDto.getSearch());
    }
}
