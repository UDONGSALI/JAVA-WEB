package com.shop.shop.entity;

import com.shop.shop.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem) { // ..... 주문상품 정보들을 담아두는 메서드
        orderItems.add(orderItem); // orderitem 객체를 order갹체의 orderitems에 추가
        orderItem.setOrder(this);   // Order 엔티티와 OrderItem 엔티티가 양방향 참조관계이므로, OrderItem객체에도 order객체를 세팅한다.
    }

    public static Order createOrder(Member member, List<OrderItem> orderItemList) {//.... 주문 엔티티 생성 메서드
        Order order = new Order();
        order.setMember(member); // 상품을 주문한 회원의 정보를 세팅한다.

        for(OrderItem orderItem : orderItemList) {  // 상품 페이지에서는 1개의 상품을 주문하지만, 장바구니 페이지에선 한 번에 여러 개의 상품을
            // 주문할 수 있다. 따라서 여러 개의 주문 상품을 담을 수 있도록 리스트 형태로 파라미터 값을 받으며 주문 객체에 orderItem 객체를 추가한다.
            order.addOrderItem(orderItem);
        }

        order.setOrderStatus(OrderStatus.ORDER); // 주문상태를 Order로 세팅
        order.setOrderDate(LocalDateTime.now());  // 현재 시간을 주문시간으로 세팅
        return order;
    }
    public int getTotalPrice() { //.... 총 주문 금액을 구하는 메서드
        int totalPrice = 0;
        for(OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }


}
