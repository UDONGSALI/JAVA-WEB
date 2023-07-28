package com.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.data.dto.ChangeProductNameDto;
import com.springboot.jpa.data.dto.ProductDto;
import com.springboot.jpa.data.dto.ProductResponseDto;
import com.springboot.jpa.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product", description = "테스트용 Product API")
@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@Operation(summary = "검색", description = "제품 가져오기")
	@GetMapping("/get")
	public ResponseEntity<ProductResponseDto> getProduct(Long number) {
		ProductResponseDto productResponseDto = productService.getProduct(number);
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}
	
	@Operation(summary = "등록", description = "제품 등록하기")
	@PostMapping("/post")
	public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
		ProductResponseDto productResponseDto = productService.saveProduct(productDto);
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}

	@Operation(summary = "변경", description = "제품 변경하기")
	@PutMapping()
	public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductNameDto changeProductNameDto)
			throws Exception {
		ProductResponseDto productResponseDto = productService.changeProductName(changeProductNameDto.getNumber(),
				changeProductNameDto.getName());
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}

	@Operation(summary = "삭제", description = "등록된 제품 삭제하기")
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteProduct(Long number) throws Exception {
		productService.deleteProduct(number);
		return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
	}
}
