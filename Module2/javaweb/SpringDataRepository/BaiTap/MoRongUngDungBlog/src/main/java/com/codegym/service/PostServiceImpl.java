package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Post;
import com.codegym.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Post post) {
        postRepository.delete(post);
    }

    @Override
    public Page<Post> findAllByCategory_Id(Long Id, Pageable pageable) {
        return postRepository.findAllByCategory_Id(Id, pageable);
    }

    @Override
    public Page<Post> findAllByTitle(String title, Pageable pageable) {
        return postRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Page<Post> findAllByCategory_IdOrderByDateCreate(Long id, Pageable pageable) {
        return postRepository.findAllByCategory_IdOrderByDateCreate(id, pageable);
    }

    @Override
    public Page<Post> findAllByCategory_IdOrderByDateCreateDesc(Long id, Pageable pageable) {
        return postRepository.findAllByCategory_IdOrderByDateCreateDesc(id, pageable);
    }

    @Override
    public Page<Post> findAllByTitleContainingOrderByDateCreateDesc(String title, Pageable pageable) {
        return postRepository.findAllByTitleContainingOrderByDateCreateDesc(title, pageable);
    }

    @Override
    public Page<Post> findAllByTitleAndCategory_Id(String title, Long id, Pageable pageable) {
        return postRepository.findAllByTitleContainingAndCategory_IdOrderByDateCreateDesc(title, id, pageable);
    }


}
