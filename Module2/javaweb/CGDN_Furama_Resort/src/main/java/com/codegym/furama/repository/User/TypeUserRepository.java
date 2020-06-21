package com.codegym.furama.repository.User;

import com.codegym.furama.model.admin.UserModel.TypeUserModel.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeUserRepository extends JpaRepository<TypeUser,Integer> {

}
