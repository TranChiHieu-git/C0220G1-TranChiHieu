package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface BlogService {
    void create(Blog model);

    List<Blog> showTille();

    Blog showBlog(Long id);

    void update(Blog model);

    void remove(Long id);
}
