package com.sangavee.model.dao;

import java.sql.SQLException;


public interface DiscountDao {

	double getDiscountByVoucher(String voucher);

}
