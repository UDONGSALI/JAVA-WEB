package com.springboot.advanced_jpa.data.repository.support;

import com.springboot.advanced_jpa.data.entity.Product;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;


    @Test
    void findByNameTest(){
        List<Product> productList = productRepository.findByName("펜");

        for(Product product : productList){
            System.out.println("확인" + product.getNumber());
            System.out.println("확인" + product.getName());
            System.out.println("확인" + product.getPrice());
            System.out.println("확인" + product.getStock());
        }
    }

}
