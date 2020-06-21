package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Blog model) {
        entityManager.merge(model);

    }

    @Override
    public List<Blog> showTille() {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog showBlog(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog c where  c.id=:id", Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Blog model) {
        entityManager.merge(model);
    }

    @Override
    public void remove(Long id) {
        Blog blog = showBlog(id);
        entityManager.remove(blog);
    }
}
