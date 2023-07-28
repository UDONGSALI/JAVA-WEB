package com.springboot.advanced_jpa.data.dto;

import lombok.*;


@Data
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;
    private int price;
    private int stock;

}
