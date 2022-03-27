package com.sangavee.redis.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.sangavee.redis.entity.Product;
import com.sangavee.redis.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	@Caching(
			put= { @CachePut(value= "productCache", key= "#id") },
			evict= { @CacheEvict(value= "allProductsCache", allEntries= true) }
		)
	public Product addProduct(Product product) {
		Product prod = productRepository.save(product);
		return prod;
	}

	@Override
	@Cacheable(value = "allProductsCache", unless= "#result.size() == 0")
	public List<Product> getAllProducts() {
		List<Product> products= productRepository.findAll();
		return products;
	}

	@Override
	@Cacheable(value = "productCache", key ="#id")
	public Optional<Product> getProductById(int id) {
			return productRepository.findById(id);
		
	}

	@Override
	//@CachePut(value="ProductCache" , key="#id")
	@Caching(
			put= { @CachePut(value= "productCache", key= "#id") },
			evict= { @CacheEvict(value= "allProductsCache", allEntries= true) }
		)
	public Optional<Product>  updateProductQuantity(int id, int quantity) {
		productRepository.updateQuantityById(id,quantity);
		return productRepository.findById(id);
	}

	@Override
	//@CacheEvict(value="Product" , key="#id")
	@Caching(
			evict= { 
				@CacheEvict(value= "productCache", key= "#id"),
				@CacheEvict(value= "allProductsCache", allEntries= true)
			}
		)
	public int deleteProduct(int id) {
		if(productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
			return id;
		}
	
		return 0;
	}

}
