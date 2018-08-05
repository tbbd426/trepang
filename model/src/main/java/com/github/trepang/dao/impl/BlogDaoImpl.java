package com.github.trepang.dao.impl;

import com.github.trepang.dao.AbstractDao;
import com.github.trepang.dao.BlogDao;
import com.github.trepang.generated.mapper.BlogMapper;
import com.github.trepang.generated.model.Blog;
import com.github.trepang.generated.model.BlogExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author tianbing
 * DATE: 2018/8/6
 */
@Repository
public class BlogDaoImpl extends AbstractDao implements BlogDao {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Optional<Blog> get(Long id) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andIdEqualTo(id);
        return firstOrEmpty(blogMapper.selectByExample(blogExample));
    }

    @Override
    public void inertOrUpdate(Blog blog) {
        blogMapper.upsertSelective(blog);
    }
}
