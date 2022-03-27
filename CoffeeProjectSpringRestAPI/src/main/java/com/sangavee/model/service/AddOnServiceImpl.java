package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.model.bean.AddOn;
import com.sangavee.model.bean.AddOns;
import com.sangavee.model.dao.AddOnDao;
import com.sangavee.model.dao.AddOnDaoImpl;

@Service("AddOnService")
public class AddOnServiceImpl implements AddOnService {
	
	@Autowired
	AddOnDao addOnDao;
	
	public void setAddOnDao(AddOnDao addOnDao) {
		this.addOnDao = addOnDao;
	}

	@Override
	public AddOns getAllAddOn(){
		AddOns addOns=new AddOns();
		addOns.setAddOns(addOnDao.getAllAddOn());
		return addOns;
	}

	@Override
	public double getAddOnPriceByName(String name) {
		return addOnDao.getAddOnPriceByName(convertToUpperCase(name));		
	}

	public String convertToUpperCase(String name) {
		return name.toUpperCase();
	}

	@Override
	public double getAddOnPriceById(int id){
		return addOnDao.getAddOnPriceById(id);
	}

	@Override
	public int getAddOnId(String name){
		return addOnDao.getAddOnId(convertToUpperCase(name));
	}

	@Override
	public AddOn getAddOnById(int id)  {
		return addOnDao.getAddonById(id);
	}

}
