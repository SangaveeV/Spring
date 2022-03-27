package com.sangavee.redis.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sangavee.redis.entity.Product;
import com.sangavee.redis.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		Product prod = productRepository.save(product);
		return prod;
	}

	@Override
	@Cacheable(value = "Product")
	public List<Product> getAllProducts() {
		List<Product> products= productRepository.findAll();
		return products;
	}

	@Override
	@Cacheable(value = "Product", key ="#id")
	public Optional<Product> getProductById(int id) {
		Optional<Product> prod = productRepository.findById(id);
		return prod;
	}

	@Override
	@CachePut(value="Product" , key="#id")
	public Optional<Product>  updateProductQuantity(int id, int quantity) {
		productRepository.updateQuantityById(id,quantity);
		return productRepository.findById(id);
	}

	@Override
	@CacheEvict(value="Product" , key="#id")
	public int deleteProduct(int id) {
		if(productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
			return id;
		}
	
		return 0;
	}

}
