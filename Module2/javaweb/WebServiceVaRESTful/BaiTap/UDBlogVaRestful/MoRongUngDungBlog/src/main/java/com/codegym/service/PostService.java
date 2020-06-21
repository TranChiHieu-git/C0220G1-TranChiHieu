package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Optional;

public interface PostService {
    Page<Post> findAll(Pageable pageable);
    Iterable<Post> findAllByID(Long id);

    Iterable<Post> findAll();

    Optional<Post> findById(Long id);

    void save(Post post);

    void remove(Post post);

    Page<Post> findAllByCategory_Id(Long Id, Pageable pageable);

    Page<Post> findAllByTitle(String title, Pageable pageable);

    Page<Post> findAllByCategory_IdOrderByDateCreate(Long id, Pageable pageable);

    Page<Post> findAllByCategory_IdOrderByDateCreateDesc(Long id, Pageable pageable);

    Page<Post> findAllByTitleContainingOrderByDateCreateDesc(String title,Pageable pageable);
    Page<Post> findAllByTitleAndCategory_Id(String title, Long id, Pageable pageable);
}
