package com.github.trepang.dao;

import com.github.trepang.generated.model.Talk;

import java.util.Optional;

public interface TalkDao {

    Optional<Talk> get(Long id);
}
