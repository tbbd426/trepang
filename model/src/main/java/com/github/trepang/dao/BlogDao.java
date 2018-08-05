package com.github.trepang.dao;

import com.github.trepang.generated.model.Blog;

import java.util.Optional;

/**
 * @author tianbing
 * DATE: 2018/8/6
 */

public interface BlogDao {

    /**
     * 通过id获取Blog内容
     * @param id
     * @return
     */
    Optional<Blog> get(Long id);

    /**
     * 插入或者更新Blog对象
     * @param blog
     */
    void inertOrUpdate(Blog blog);
}
