package com.codegym.furama.service.UserNormal;

import com.codegym.furama.model.user.accountUserNormal.accountUserNormal;
import com.codegym.furama.repository.userNormal.UserNormalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserNormalServiceImpl implements UserNormalService {
    @Autowired
    UserNormalRepository userNormalRepository;

    @Override
    public accountUserNormal comfirmlogin(String acc, String pass) {
        return userNormalRepository.findByAccountAndPassword(acc, pass);
    }

    @Override
    public Page<accountUserNormal> findAllUserNormal(Pageable pageable) {
        return userNormalRepository.findAll(pageable);
    }

    @Override
    public Iterable<accountUserNormal> findAllUserNormal() {
        return userNormalRepository.findAll();
    }

    @Override
    public accountUserNormal findUserNormalById(int id) {
        return userNormalRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(accountUserNormal accountUserNormal) {
        userNormalRepository.save(accountUserNormal);
    }

    @Override
    public void deleteUser(accountUserNormal accountUserNormal) {
        userNormalRepository.delete(accountUserNormal);
    }
}
