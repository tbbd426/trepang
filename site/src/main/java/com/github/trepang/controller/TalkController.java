package com.github.trepang.controller;

import com.github.trepang.controller.resp.TalkResp;
import com.github.trepang.dao.TalkDao;
import com.github.trepang.generated.model.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author tianbing
 */
@RequestMapping("talks")
@RestController
public class TalkController {

    @Autowired
    private TalkDao talkDao;

    @GetMapping
    public ResponseEntity<TalkResp> getTask(@RequestParam("id") Long id) {
        Optional<Talk> talk = talkDao.get(id);
        if (talk.isPresent()) {
            TalkResp resp = convert(talk.get());
            return ResponseEntity.ok(resp);
        }
        return ResponseEntity.ok(null);
    }

    private TalkResp convert(Talk talk) {
        TalkResp resp = new TalkResp();
        resp.setId(talk.getId());
        resp.setTalk(talk.getTalk());
        resp.setUpdatedAt(talk.getUpdatedAt());
        resp.setCreatedAt(talk.getCreatedAt());
        resp.setLastEditedAt(talk.getLastUpdateAt());
        return resp;
    }

}
