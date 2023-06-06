package com.ztpai.projekt.meeme.controller;

import com.ztpai.projekt.meeme.data.Meme;
import com.ztpai.projekt.meeme.data.dto.MemeDto;
import com.ztpai.projekt.meeme.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${upload.folder}")
    private String uploadFolder;

    @PostMapping("/meme")
    public int addMeme(@ModelAttribute("MemeDto") MemeDto memeDto){
        Meme meme = new Meme();

        String fileName = StringUtils.cleanPath(memeDto.getFile().getOriginalFilename());

        meme.setCommunity(memeDto.getCommunity());
        meme.setUser(memeDto.getUser());
        meme.setText(memeDto.getText());
        meme.setFileName(fileName);
        meme.setPostDate(new Date());

        repository.save(meme);

        try{
            Path filePath = Path.of(uploadFolder, fileName);
            Files.copy(memeDto.getFile().getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            return -1;
        }

        return 1;
    }

    @GetMapping("/meme")
    public List<Meme> getAllMemes(){
        return repository.findAll();
    }
}
