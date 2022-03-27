package com.sangavee.model.dao;

import java.util.ArrayList;

import com.sangavee.model.bean.AddOn;

public interface AddOnDao {
	ArrayList<AddOn> getAllAddOn();
	double getAddOnPriceByName(String name);
	double getAddOnPriceById(int id);
	int getAddOnId(String name);
	AddOn getAddonById(int id);

}
