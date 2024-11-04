package com.ecomm.saurabh.ecommapp.service;

import com.ecomm.saurabh.ecommapp.domain.Order;
import com.ecomm.saurabh.ecommapp.domain.Product;
import com.ecomm.saurabh.ecommapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("product.service.url")
    private String productServiceUrl;

    public void createOrder(Order order){
        if(order != null && order.getProductIds() != null){

            for(Long id : order.getProductIds()){

                ResponseEntity<Product> productDetails = restTemplate.exchange(productServiceUrl + id,HttpMethod.GET,null, Product.class);

                if(productDetails != null && productDetails.getStatusCode().is2xxSuccessful()){
                    System.out.println("Successfully retrieved product details for product id :"+ id);
                }else{
                    throw new RuntimeException("Exception while retrieving product details for id " + id);
                }

            }

        }
        orderRepository.save(order);
    }
}
