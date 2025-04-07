package com.moo_rest.spring_app.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moo_rest.spring_app.models.UserEntity;
import com.moo_rest.spring_app.repositories.UserRepository;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    public Optional<UserEntity> obtenerUsuarioPorId(long id){
        Optional<UserEntity> user = userRepository.findById(id);
        return Optional.ofNullable(user.orElse(null));
    }
    
    public void crearUsuario(UserEntity user){
        userRepository.save(user);
    }
}
