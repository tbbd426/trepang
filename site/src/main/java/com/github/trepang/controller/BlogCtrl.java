package com.github.trepang.controller;

import com.github.trepang.controller.req.BlogReq;
import com.github.trepang.controller.resp.BlogResp;
import com.github.trepang.controller.support.JsonResult;
import com.github.trepang.dao.BlogDao;
import com.github.trepang.generated.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author tianbing
 */
@RequestMapping("blogs")
@RestController
public class BlogCtrl extends BaseController {

    @Autowired
    private BlogDao blogDao;

    @GetMapping("/{id}")
    JsonResult<BlogResp> getById(@PathVariable("id")Long id)  {
        Optional<Blog> blogOptional = blogDao.get(id);
        if (blogOptional.isPresent()) {
            return ok(convert(blogOptional.get()));
        }
        return fail("cannot find blog through id");
    }

    @PostMapping
    JsonResult update(BlogReq req) {
        blogDao.inertOrUpdate(convert(req));
        return ok(null);
    }

    private Blog convert(BlogReq blogReq) {
        Blog blog = new Blog();
        blog.setId(blogReq.getId());
        blog.setTitle(blog.getTitle());
        blog.setContentHtml(blogReq.getContent());
        return blog;
    }

    private BlogResp convert(Blog blog) {
        return BlogResp.builder()
                .content(blog.getContentHtml())
                .id(blog.getId())
                .title(blog.getTitle())
                .updatedAt(blog.getUpdatedAt())
                .createdAt(blog.getCreatedAt())
                .build();
    }
}
