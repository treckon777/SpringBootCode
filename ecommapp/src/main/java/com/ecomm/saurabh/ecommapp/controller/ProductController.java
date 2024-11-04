package com.ecomm.saurabh.ecommapp.controller;

import com.ecomm.saurabh.ecommapp.domain.Product;
import com.ecomm.saurabh.ecommapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Api call to fetch all records.
     * @return
     */
    @GetMapping("/product")
    public List<Product> fetchAllProducts(){
        return productService.fetchAllProducts();
    }

    /**
     * API call to fetch a product for a given id;
     * @param id
     * @return
     */
    @GetMapping("/product/{id}")
    public Product fetchProductById(@PathVariable Long id){
        return productService.fetchProductById(id);
    }
}
