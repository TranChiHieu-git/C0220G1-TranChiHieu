package com.codegym.furama.repository.userNormal;

import com.codegym.furama.model.user.accountUserNormal.accountUserNormal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNormalRepository extends JpaRepository<accountUserNormal, Integer> {
    accountUserNormal findByAccountAndPassword(String acc, String pass);
}
