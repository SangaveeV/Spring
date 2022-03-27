package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sangavee.model.bean.AddOn;
import com.sangavee.model.bean.AddOns;

public interface AddOnService {

	AddOns getAllAddOn();
	double getAddOnPriceByName(String name);
	double getAddOnPriceById(int id);
	int getAddOnId(String name);
	AddOn getAddOnById(int id);
}
