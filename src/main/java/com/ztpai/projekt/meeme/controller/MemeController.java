package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.Community;
import com.ztpai.projekt.meeme.data.Meme;
import com.ztpai.projekt.meeme.data.User;
import com.ztpai.projekt.meeme.data.dto.MemeDto;
import com.ztpai.projekt.meeme.repository.CommunityRepository;
import com.ztpai.projekt.meeme.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@RestController
public class MemeController {
    @Autowired
    MemeRepository repository;

    @Autowired
    CommunityRepository communityRepository;

    @Value("${upload.folder}")
    private String uploadFolder;

    @PostMapping("/meme")
    public int addMeme(@ModelAttribute("MemeDto") MemeDto memeDto){
        Meme meme = new Meme();

        String fileName = StringUtils.cleanPath(memeDto.getFile().getOriginalFilename());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken auth) {
            if (auth.getPrincipal() instanceof User user) {

                meme.setCommunity(communityRepository.findById(memeDto.getId_community()).get());
                meme.setUser(user);
                meme.setText(memeDto.getText());
                meme.setFileName(fileName);
                meme.setPostDate(new Date());

                repository.save(meme);

                try{
                    Path filePath = Path.of(uploadFolder, memeDto.getFile().getOriginalFilename());
                    Files.copy(memeDto.getFile().getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                }catch (IOException e){
                    e.printStackTrace();
                    return -2;
                }
            }
        }

        return 1;
    }

    @DeleteMapping("/meme/{id}")
    public void deleteMeme(@PathVariable("id") long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken auth) {
            if (auth.getPrincipal() instanceof User user) {
                if(user.getRole().getName().equalsIgnoreCase("Admin")){
                    repository.delete(repository.getById(id));
                }
            }
        }
    }

    @GetMapping("/meme")
    public List<Meme> getAllMemes(){
        return repository.findAll();
    }

    @GetMapping("/meme/last")
    public List<Meme> getMemesSortedByPostDate(){
        return repository.findAllByOrderByPostDateDesc();
    }
}
