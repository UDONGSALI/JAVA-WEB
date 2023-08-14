package com.shop.shop.entity;

import com.shop.shop.constant.ItemSellStatus;
import com.shop.shop.dto.ItemFormDto;
import com.shop.shop.exception.OutOfStockException;
import lombok.*;

import javax.persistence.*;
import java.awt.image.renderable.RenderableImage;

@Entity
@Getter
@Setter
@ToString
@Table(name = "item")
public class Item extends BaseEntity{

    @Id
    @Column(name = "itme_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//상품 코드
    @Column(nullable = false, length = 50)
    private String itemNm;//상품명
    @Column(name = "price", nullable = false)
    private int price;
    @Column(nullable = false)
    private int stockNumber;
    @Lob
    @Column(nullable = false)
    private String itemDetail;
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    public void updateItem(ItemFormDto itemFormDto) {
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

    public void removeStock(int stockNumber) {
        int restStock = this.stockNumber - stockNumber;  // 상품재고 수량에서 주문 후 남은 재고수량을 구한다.
        if (restStock < 0) {
            throw new OutOfStockException("상품의 재고가 부족합니다. (현재 재고 수량 :  "+ this.stockNumber + ")");
        } // 상품 재고가 주문 수량보다 적을 때 재고 부족 예외를 발생시킴
        this.stockNumber = restStock;
    }
}
