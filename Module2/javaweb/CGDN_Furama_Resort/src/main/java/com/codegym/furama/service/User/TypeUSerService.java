package com.codegym.furama.service.User;

import com.codegym.furama.model.admin.UserModel.TypeUserModel.TypeUser;

public interface TypeUSerService {
    Iterable<TypeUser> findAllTypeUSer();

    TypeUser findTypeUser(int id);
}
