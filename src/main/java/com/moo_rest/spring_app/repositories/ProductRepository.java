package com.moo_rest.spring_app.repositories;

import com.moo_rest.spring_app.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    
}
