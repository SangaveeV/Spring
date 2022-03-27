package com.sangavee.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.model.dao.DiscountDao;

@Service("DiscountService")
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	private DiscountDao discountDao;
	
	public void setDiscountDao(DiscountDao discountDao) {
		this.discountDao = discountDao;
	}

	@Override
	public double getDiscountByVoucher(String voucher) {
		double discount=discountDao.getDiscountByVoucher(voucher);
		return discount;
	}

}
