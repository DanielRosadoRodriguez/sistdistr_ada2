package com.moo_rest.spring_app.controllers;

import com.moo_rest.spring_app.models.UserEntity;
import com.moo_rest.spring_app.repositories.UserRepository;
import com.moo_rest.spring_app.services.UserService;
import com.moo_rest.spring_app.users.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;


@Endpoint
public class UserController {

    private static final String TARGET_NAMESPACE = "http://www.moo_rest.com/spring_app/users";

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "CreateUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        UserEntity user = new UserEntity();
        String name = request.getName();
        String email = request.getEmail();
        user.setEmail(email);
        user.setName(name);
        userService.crearUsuario(user);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
		response.setServiceStatus(serviceStatus);
        
        return response;
   
    }


    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "GetAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers(@RequestPayload GetAllUsersRequest request) {
        GetAllUsersResponse response = new GetAllUsersResponse();
    
        List<UserEntity> usuarios = userService.obtenerUsuarios(); // Método en tu servicio
    
        for (UserEntity entity : usuarios) {
            User user = new User();
            BeanUtils.copyProperties(entity, user);
            response.getUsers().add(user);
        }
    
        return response;
    }

    
}
