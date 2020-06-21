package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void create(Blog model) {
        blogRepository.create(model);
    }

    @Override
    public List<Blog> showTille() {
        return blogRepository.showTille();
    }

    @Override
    public Blog showBlog(Long id) {
        return blogRepository.showBlog(id);
    }

    @Override
    public void update(Blog model) {
        blogRepository.update(model);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}
