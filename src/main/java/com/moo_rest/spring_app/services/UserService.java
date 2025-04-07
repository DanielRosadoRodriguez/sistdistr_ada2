package com.moo_rest.spring_app.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moo_rest.spring_app.models.UserEntity;
import com.moo_rest.spring_app.repositories.UserRepository;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    public ArrayList<UserEntity> obtenerUsuarios(){
        return (ArrayList<UserEntity> ) userRepository.findAll();
    }
    
    public void crearUsuario(UserEntity user){
        userRepository.save(user);
    }
}
