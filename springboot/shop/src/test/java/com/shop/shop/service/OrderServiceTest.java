package com.shop.shop.service;

import com.shop.shop.constant.ItemSellStatus;
import com.shop.shop.constant.OrderStatus;
import com.shop.shop.dto.OrderDto;
import com.shop.shop.entity.Item;
import com.shop.shop.entity.Member;
import com.shop.shop.entity.Order;
import com.shop.shop.entity.OrderItem;
import com.shop.shop.repository.ItemRepository;
import com.shop.shop.repository.MemberRepository;
import com.shop.shop.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    MemberRepository memberRepository;

    public Item saveItem() { //테스트를 위한 주문할 상품 정보를 저장하는 메소드
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        return itemRepository.save(item);
    }

    public Member saveMember() { //테스트를 위한 회원정보를 저장하는 메소드
        Member member = new Member();
        member.setEmail("test@test.com");
        return memberRepository.save(member);
    }

    @Test
    @DisplayName("주문 테스트")
    public void order(){
        Item item = saveItem();
        Member member = saveMember();

        OrderDto orderDto = new OrderDto();
        orderDto.setCount(10); // 주문할 상품 수량과
        orderDto.setItemId(item.getId()); // 주문할 상품을 orderDto 객체에 세팅

        Long orderId = orderService.order(orderDto, member.getEmail()); // 주문로직 호출결과 생성된 주문번호를 order변수에 저장
        Order order = orderRepository.findById(orderId) //주문번호를 이용하여 저장된 주문정보를 조회한다;
                .orElseThrow(EntityExistsException::new);
        List<OrderItem> orderItems = order.getOrderItems();

        int totalPrice = orderDto.getCount() * item.getPrice(); // 주문한 상품 총가격

        assertEquals(totalPrice, order.getTotalPrice()); // 주문한 상품 총가격과 DB에 저장된 상품의 가격을 비교하여 같으면 테스트가 성공적으로 종료
    }

    @Test
    @DisplayName("주문 취소 테스트")
    public void cancelOrder(){
        Item item = saveItem();
        Member member = saveMember();  // 상품과 회원 데이터를 생성한다. 생성한 상품 재고는 100개다.

        OrderDto orderDto = new OrderDto();
        orderDto.setCount(10);
        orderDto.setItemId(item.getId());
        Long orderId = orderService.order(orderDto, member.getEmail());  // 주문 데이터를 생성, 주문개수는 총10개

        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);  // 생성한 주문 엔티티를 조회
        orderService.cancelOrder(orderId);  // 해당 주문을 취소

        assertEquals(OrderStatus.CANCEL, order.getOrderStatus());  // 주문 상태가 취소 상태라면 테스트 통과
        assertEquals(100, item.getStockNumber());  // 취소 후 상품 재고가 처음 잭 개수인 100와 동일하면 테스트 통과
    }

}
