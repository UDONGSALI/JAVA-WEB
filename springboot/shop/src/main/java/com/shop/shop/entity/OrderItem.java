package com.shop.shop.entity;

import com.querydsl.codegen.ParameterizedTypeImpl;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;

    public static OrderItem createOrderItem(Item item, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);               // 주문할 상품과 주문 수량을 세팅한다.
        orderItem.setCount(count);
        orderItem.setOrderPrice(item.getPrice());// 현재시간 기준으로 상품가격을 주문 가격으로 세팅
        item.removeStock(count);
        return orderItem;
    }

    public int getTotalPrice(){     //주문 가격과 주문 수량을 곱해서 해당 상품을 주문한 총 가격을 계산하는 메소드
        return orderPrice * count;
    }


}
