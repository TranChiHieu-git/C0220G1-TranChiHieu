package com.codegym.repository;

import java.util.List;

public interface Repository<T> {
    void create(T model);

    List<T> showTille();

    T showBlog(Long id);

    void update(T model);

    void remove(Long id);
}
