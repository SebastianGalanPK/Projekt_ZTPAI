package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.Community;
import com.ztpai.projekt.meeme.data.Meme;
import com.ztpai.projekt.meeme.data.User;
import com.ztpai.projekt.meeme.data.dto.CommunityDto;
import com.ztpai.projekt.meeme.data.dto.SearchDto;
import com.ztpai.projekt.meeme.repository.CommunityRepository;
import com.ztpai.projekt.meeme.repository.MemeRepository;
import com.ztpai.projekt.meeme.repository.RoleRepository;
import com.ztpai.projekt.meeme.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommunityController {

    @Autowired
    CommunityRepository repository;

    @Autowired
    MemeRepository memeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/community")
    public void createCommunity(@ModelAttribute("CommunityDto") CommunityDto communityDto){
        Community community = new Community(communityDto.getName(), communityDto.getNickname());
        repository.save(community);
    }

    @GetMapping("/community")
    public List<Community> getAllCommunities(){
        return repository.findAll();
    }

    @PostMapping("/community/{nickname}")
    @Transactional
    public void toggleCommunityStatus(@PathVariable("nickname") String nickname){
        Community community = repository.findByNickname(nickname);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken auth) {
            if (auth.getPrincipal() instanceof User user) {
                user.getCommunities().add(community);

                user.setRole(roleRepository.findById(user.getRole().getId()));

                userRepository.save(user);
            }
        }
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
