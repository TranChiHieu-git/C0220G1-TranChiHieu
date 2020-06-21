package com.codegym.repository;

import com.codegym.model.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Page<Post> findAllByCategory_Id(Long Id, Pageable pageable);
   Iterable<Post> findAllByCategory_Id(Long Id);

    Page<Post> findAllByTitleContaining(String title, Pageable pageable);

    Page<Post> findAllByCategory_IdOrderByDateCreate(Long id, Pageable pageable);

    Page<Post> findAllByCategory_IdOrderByDateCreateDesc(Long id, Pageable pageable);

    Page<Post> findAllByTitleContainingOrderByDateCreateDesc(String title, Pageable pageable);

    Page<Post> findAllByTitleContainingAndCategory_IdOrderByDateCreateDesc(String title, Long id, Pageable pageable);


}
