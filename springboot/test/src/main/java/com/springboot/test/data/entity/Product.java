package com.springboot.test.data.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private Integer stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(Long number, String name, Integer price, Integer stock, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product() {
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public Long getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getStock() {
        return this.stock;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String toString() {
        return "Product(number=" + this.getNumber() + ", price=" + this.getPrice() + ", stock=" + this.getStock() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ")";
    }

    public static class ProductBuilder {
        private Long number;
        private String name;
        private Integer price;
        private Integer stock;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        ProductBuilder() {
        }

        public ProductBuilder number(Long number) {
            this.number = number;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder price(Integer price) {
            this.price = price;
            return this;
        }

        public ProductBuilder stock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public ProductBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProductBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Product build() {
            return new Product(this.number, this.name, this.price, this.stock, this.createdAt, this.updatedAt);
        }

        public String toString() {
            return "Product.ProductBuilder(number=" + this.number + ", name=" + this.name + ", price=" + this.price + ", stock=" + this.stock + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
        }
    }
}
