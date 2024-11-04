package com.ecomm.saurabh.ecommapp.service;

import com.ecomm.saurabh.ecommapp.domain.Product;
import com.ecomm.saurabh.ecommapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> fetchAllProducts(){
        try {
            return productRepository.findAll();
        }catch(Exception ex){
            throw new RuntimeException(" Db exception while fetching all records");
        }
    }

    public Product fetchProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new RuntimeException("DB exception while fetching product by id :"+ id);
        }
        return  product.get();
    }
}
