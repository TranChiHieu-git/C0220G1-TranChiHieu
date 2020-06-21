package com.codegym.furama.service.User;

import com.codegym.furama.model.admin.UserModel.User;
import com.codegym.furama.repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public Page<User> findAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Iterable<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Page<User> findAllUSerByNameID(String key, Pageable pageable) {
        return userRepository.findAllByNameContainingOrIdContainingOrNumberOfCMNDOrEmailOrNumberPhoneOrTypeUser_NameTypeUserOrderById(key, key, key, key, key, key, pageable);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUSer(User user) {
        userRepository.delete(user);
    }
}
