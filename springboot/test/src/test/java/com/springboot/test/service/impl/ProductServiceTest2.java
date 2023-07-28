package com.springboot.test.service.impl;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.springboot.test.data.dto.ProductDto;
import com.springboot.test.data.dto.ProductResponseDto;
import com.springboot.test.data.entity.Product;
import com.springboot.test.data.repository.ProductRepository;
import com.springboot.test.service.ProductService;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@Import({ProductServiceImpl.class})
public class ProductServiceTest2 {

    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductServiceImpl productService;

//    @Test
//    void getProductTest(){
//        Product givenProduct = new Product();
//        givenProduct.setNumber(123L);
//        givenProduct.setName("펜");
//        givenProduct.setPrice(1000);
//        givenProduct.setStock(1234);
//
//        Mockito.when(productRepository.findById(123L))
//                .thenReturn(Optional.of(givenProduct));
//        ProductResponseDto productResponseDto = productService.getProduct(123L);
//        Assertions.assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
//        Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
//        Assertions.assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
//        Assertions.assertEquals(productResponseDto.getStock(), givenProduct.getStock());
//
//        verify(productRepository).findById(123L);
//    }
    @Test
    void saveProductTest(){
        Mockito.when(productRepository.save(any(Product.class)))
                .then(returnsFirstArg());
        ProductResponseDto productResponseDto = productService.saveProduct(
                new ProductDto("펜",1000,1234));
        Assertions.assertEquals(productResponseDto.getName(),"펜");
        Assertions.assertEquals(productResponseDto.getPrice(),1000);
        Assertions.assertEquals(productResponseDto.getStock(),1234);

        verify(productRepository).save(any());
    }

}