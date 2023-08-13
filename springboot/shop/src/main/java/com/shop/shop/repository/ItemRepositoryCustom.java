package com.shop.shop.repository;

import com.shop.shop.dto.ItemSearchDto;
import com.shop.shop.dto.MainItemDto;
import com.shop.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) ;
    // 상품조회 조건을 담고 있는 itemSearchDto 객체와 페이징 정보를 담고 있는 pageable객체를 파라미터로 받는 getAdminItemPage
    // 메소드를 정의한다.

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}
