package com.sangavee.model.service;

import java.sql.SQLException;

public interface DiscountService {

	double getDiscountByVoucher(String voucher);
}
