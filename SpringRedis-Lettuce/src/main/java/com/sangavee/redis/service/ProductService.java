package com.sangavee.redis.service;

import java.util.List;
import java.util.Optional;

import com.sangavee.redis.entity.Product;

public interface ProductService {

	Product addProduct(Product product);
	List<Product> getAllProducts();
	Optional<Product> getProductById(int id);
	Optional<Product>  updateProductQuantity(int id, int quantity);
	int deleteProduct(int id);
}
