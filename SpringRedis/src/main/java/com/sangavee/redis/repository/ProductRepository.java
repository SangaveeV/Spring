package com.sangavee.redis.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sangavee.redis.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Modifying
	@Transactional
	@Query("update Product p set p.quantity=:quantity where p.id=:id")
	int updateQuantityById(int id, int quantity);
}
