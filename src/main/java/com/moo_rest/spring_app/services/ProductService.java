
package com.moo_rest.spring_app.services;

import com.moo_rest.spring_app.models.Product;
import com.moo_rest.spring_app.repositories.ProductRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;
    
    public ArrayList<Product> obtenerProductos(){
        return (ArrayList<Product>) productRepository.findAll();
    }
    
    public Product guardarrProducto(Product producto){
        return productRepository.save(producto);
    }
}
