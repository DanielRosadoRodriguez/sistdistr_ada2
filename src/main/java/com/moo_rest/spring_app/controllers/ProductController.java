/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moo_rest.spring_app.controllers;

import com.moo_rest.spring_app.models.Product;
import com.moo_rest.spring_app.services.ProductService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping()
    public ArrayList<Product> obtenerProductos(){
        return productService.obtenerProductos();
    }
    
    @PostMapping()
    public Product guardarProducto(@RequestBody Product product){
        return this.productService.guardarrProducto(product);
    }
    
    
}
