package com.moo_rest.spring_app.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moo_rest.spring_app.models.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
