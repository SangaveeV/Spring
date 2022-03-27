package com.sangavee.redis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sangavee.redis.entity.Product;
import com.sangavee.redis.service.ProductNotFoundException;
import com.sangavee.redis.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product prod= productService.addProduct(product);
		return new ResponseEntity<>(prod,HttpStatus.OK);
	}
	
	@GetMapping("/productId")
	public ResponseEntity<Product> getProductById(@RequestParam int id){
	
		if(!productService.getProductById(id).isPresent())
		{
			throw new ProductNotFoundException("Product Not Found");
		}
		Product prod=productService.getProductById(id).get();
		return new ResponseEntity<>(prod,HttpStatus.OK);
	}
	
	@GetMapping("/allProducts")
	public ResponseEntity<List<Product>> getProducts(){
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@PatchMapping("/updateQuantity")
	public ResponseEntity<Product> updateProductQuantity(@RequestParam int id, @RequestParam int quantity){
		if(!productService.updateProductQuantity(id, quantity).isPresent()) {
			throw new ProductNotFoundException("Product Not Found");
		}
		Product product =  productService.updateProductQuantity(id, quantity).get();
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<String> deleteProduct(@RequestParam int id){
		int del = productService.deleteProduct(id);
		if(del!=0) {
			return new ResponseEntity<String>("Product is deleted",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Product is not found",HttpStatus.OK);
	}
}
