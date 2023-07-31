package com.springboot.test.data.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.springboot.test.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryTestByH22 {

    @Autowired
    private ProductRepository productRepository;

//    @Test
//    @Rollback(false)
//    void saveTest() {
//        // given
//        Product product = new Product();
//        product.setName("펜");
//        product.setPrice(1000);
//        product.setStock(1000);
//        // when
//        Product savedProduct = productRepository.save(product);
//
//        // then
//        assertEquals(product.getName(), savedProduct.getName());
//        assertEquals(product.getPrice(), savedProduct.getPrice());
//        assertEquals(product.getStock(), savedProduct.getStock());
//    }
    @Test
    @Rollback(false)

    void selectTest() {
        // given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        Product savedProduct = productRepository.saveAndFlush(product);

        // when
        Product foundProduct = productRepository.findById(savedProduct.getNumber()).get();

        // then
        assertEquals(product.getName(), foundProduct.getName());
        assertEquals(product.getPrice(), foundProduct.getPrice());
        assertEquals(product.getStock(), foundProduct.getStock());
    }



}
