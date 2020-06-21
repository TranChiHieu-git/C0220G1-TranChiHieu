package com.codegym.furama.repository.User;

import com.codegym.furama.model.admin.UserModel.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    Page<User> findAllByNameContainingOrIdContainingOrNumberOfCMNDOrEmailOrNumberPhoneOrTypeUser_NameTypeUserOrderById(String key1, String key2,
                                                                                                                       String key3, String key4,
                                                                                                                       String key5, String key6, Pageable pageable);

}
