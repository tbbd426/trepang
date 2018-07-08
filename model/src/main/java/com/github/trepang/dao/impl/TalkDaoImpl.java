package com.github.trepang.dao.impl;

import com.github.trepang.dao.AbstractDao;
import com.github.trepang.dao.TalkDao;
import com.github.trepang.generated.mapper.TalkMapper;
import com.github.trepang.generated.model.Talk;
import com.github.trepang.generated.model.TalkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author tianbing
 *
 */

@Repository
public class TalkDaoImpl extends AbstractDao implements TalkDao {

    @Autowired
    private TalkMapper talkMapper;

    @Override
    public Optional<Talk> get(Long id) {
        TalkExample example = new TalkExample();
        example.createCriteria().andIdEqualTo(id);
        List<Talk> talkList = talkMapper.selectByExample(example);
        return firstOrEmpty(talkList);
    }
}
