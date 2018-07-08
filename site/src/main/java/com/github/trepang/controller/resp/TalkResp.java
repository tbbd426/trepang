package com.github.trepang.controller.resp;

import lombok.Data;

import java.util.Date;

@Data
public class TalkResp {

    private Long id;

    private String talk;

    private Date createdAt;

    private Date updatedAt;

    private Date lastEditedAt;
}
