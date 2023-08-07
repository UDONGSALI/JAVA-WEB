package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByNumber(Long number);

	List<Product> findAllByName(String name);

	Product queryByNumber(Long number);

	// exists...By
	boolean existsByNumber(Long number);

	// count..By
	long countByName(String name);

	// delete...By, remove...Byvoid
	void deleteByNumber(Long number);

	long removeByName(String name);

	// ...First<number>...,Top<Number>...
	List<Product> findFirst5ByName(String name);

	List<Product> findTop10ByName(String name);

	// findByNumber 메서드와 동일하게 동작
	Product findByNumberIs(Long number);

	Product findByNumberEquals(Long number);

	Product findByNumberIsNot(Long number);

	Product findByNumberNot(Long number);

	List<Product> findByUpdatedAtNull();

	List<Product> findByUpdatedAtIsNull();

	List<Product> findByUpdatedAtNotNull();

	List<Product> findByUpdatedAtIsNotNull();

	Product findByNumberAndName(Long number, String name);

	Product findByNumberOrName(Long number, String name);

	List<Product> findByPriceIsGreaterThan(Long price);

	List<Product> findByPriceGreaterThan(Long price);

	List<Product> findByPriceGreaterThanEqual(Long price);

	List<Product> findByPriceIsLessThan(Long price);

	List<Product> findByPriceLessThan(Long price);

	List<Product> findByPriceLessThanEqual(Long price);

	List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);

	List<Product> findByPriceBetween(Long lowPrice, Long highPrice);

	// Asc : 오름차순, Desc : 내림차순
	List<Product> findByNameOrderByNumberAsc(String name);

	List<Product> findByNameOrderByNumberDesc(String name);

	// And를 붙이지 않음
	List<Product> findByNameOrderByPriceAscStockDesc(String name);

	List<Product> findByName(String name, Sort sort);

	Page<Product> findByName(String name, Pageable pageable);

}