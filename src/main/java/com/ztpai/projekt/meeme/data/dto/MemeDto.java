package com.ztpai.projekt.meeme.data.dto;

import com.ztpai.projekt.meeme.data.Community;
import com.ztpai.projekt.meeme.data.User;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemeDto {
    private String text;
    private User user;
    private Community community;
    private MultipartFile file;
}
