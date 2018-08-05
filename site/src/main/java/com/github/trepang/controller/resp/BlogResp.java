package com.github.trepang.controller.resp;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author tianbing
 * DATE: 2018/8/6
 */
@Data
@Builder
public class BlogResp {

    private Long id;

    private String content;

    private Date createdAt;

    private Date updatedAt;
}
