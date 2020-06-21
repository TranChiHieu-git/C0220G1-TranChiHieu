package com.codegym.furama.service.UserNormal;

import com.codegym.furama.model.user.accountUserNormal.accountUserNormal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface UserNormalService {
    public accountUserNormal comfirmlogin(String acc, String pass);

    public Page<accountUserNormal> findAllUserNormal(Pageable pageable);

    public Iterable<accountUserNormal> findAllUserNormal();

    public accountUserNormal findUserNormalById(int id);

    public void saveUser(accountUserNormal accountUserNormal);

    public void deleteUser(accountUserNormal accountUserNormal);
}
