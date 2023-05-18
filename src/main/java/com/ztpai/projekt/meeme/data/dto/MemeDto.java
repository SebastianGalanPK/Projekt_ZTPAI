package com.ztpai.projekt.meeme.data.dto;

import com.ztpai.projekt.meeme.data.Community;
import com.ztpai.projekt.meeme.data.User;
import lombok.Data;

@Data
public class MemeDto {
    private String text;
    private User user;
    private Community community;
}
