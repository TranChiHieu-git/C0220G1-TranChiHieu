package com.codegym.furama.service.User;

import com.codegym.furama.model.admin.UserModel.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAllUser(Pageable pageable);


    Iterable<User> findAllUser();

    User findUserById(String id);

    Page<User> findAllUSerByNameID(String key, Pageable pageable);

    void saveUser(User user);

    void deleteUSer(User user);
}
