package com.codegym.furama.service.User;

import com.codegym.furama.model.admin.UserModel.TypeUserModel.TypeUser;
import com.codegym.furama.repository.User.TypeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeUserServiceImpl implements TypeUSerService {
    @Autowired
    TypeUserRepository typeUserRepository;

    @Override
    public Iterable<TypeUser> findAllTypeUSer() {
        return typeUserRepository.findAll();
    }

    @Override
    public TypeUser findTypeUser(int id) {
        return typeUserRepository.findById(id).orElse(null);
    }
}
