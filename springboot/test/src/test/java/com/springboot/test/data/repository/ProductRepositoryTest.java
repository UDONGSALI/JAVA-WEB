package com.springboot.test.data.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.springboot.test.data.entity.Product;
import com.springboot.test.data.entity.QProduct;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ProductRepositoryTest {

    @PersistenceContext
    EntityManager entityManager;

//    @Test
//    void queryDslTest() {
//        JPAQuery<Product> query = new JPAQuery(entityManager);
//        QProduct qProduct = QProduct.product;
//
//        List<Product> productList = query
//                .from(qProduct)
//                .where(qProduct.name.eq("펜"))
//                .orderBy(qProduct.price.asc())
//                .fetch();
//
//        for (Product product : productList) {
//            System.out.println("----------------");
//            System.out.println();
//            System.out.println("Product Number : " + product.getNumber());
//            System.out.println("Product Name : " + product.getName());
//            System.out.println("Product Price : " + product.getPrice());
//            System.out.println("Product Stock : " + product.getStock());
//            System.out.println();
//            System.out.println("----------------");
//        }
//    }



    @Test
    void queryDslTest2() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<Product> productList = jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Product product : productList) {
            System.out.println("----------------");
            System.out.println();
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println();
            System.out.println("----------------");
        }
    }



}
