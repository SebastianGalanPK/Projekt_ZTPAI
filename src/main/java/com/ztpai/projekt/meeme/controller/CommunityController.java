package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.Community;
import com.ztpai.projekt.meeme.data.dto.CommunityDto;
import com.ztpai.projekt.meeme.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommunityController {

    @Autowired
    CommunityRepository repository;

    @PostMapping("/community")
    public void createCommunity(@ModelAttribute("CommunityDto") CommunityDto communityDto){
        Community community = new Community(communityDto.getName(), communityDto.getNickname());
        repository.save(community);
    }

    @PostMapping("/community/{id}")
    public void toggleCommunityStatus(@PathVariable("id") int id){

    }

    @GetMapping("/community/search")
    public List<Community> getAllCommunities(){
        return repository.findAll();
    }
}
