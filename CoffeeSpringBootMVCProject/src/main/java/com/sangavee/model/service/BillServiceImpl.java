package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.model.bean.Bill;
import com.sangavee.model.bean.OrderTransaction;
import com.sangavee.model.dao.BillDao;
import com.sangavee.model.dao.BillDaoImpl;

@Service("BillService")
public class BillServiceImpl implements BillService {

	@Autowired
	BillDao billDao;
	
	public void setAddOnService(AddOnService addOnService) {
		this.addOnService = addOnService;
	}

	@Autowired
	DiscountService discountService=new DiscountServiceImpl();
	@Autowired
	OrderTransactionService transService=new OrderTransactionServiceImpl();
	@Autowired
	AddOnService addOnService=new AddOnServiceImpl();
	@Autowired
	CoffeeService coffeeService=new CoffeeServiceImpl();
	@Override
	public void addBill(int orderId, String voucher)  {
		double amount=0;
		double discount=0;
		
		ArrayList<OrderTransaction> transList= transService.getOrderTranByOrderID(orderId);
		
		for(OrderTransaction trans:transList) {
			double addOnPrice=0;
			double coffeePrice=0;
			if(trans.getAddon_Id()!=0)
				addOnPrice=addOnService.getAddOnPriceById(trans.getAddon_Id());
			if(trans.getCoffee_Id()!=0)
				coffeePrice=coffeeService.getPriceById(trans.getCoffee_Id());
			amount+=(addOnPrice+coffeePrice);	
		}
		
		int billId=billDao.getMaxBillId()+1;
		if(voucher!=null)
			discount=discountService.getDiscountByVoucher(voucher);
		double discountAmt=amount*(discount/100);
		double netValue=amount-discountAmt;
		double gst=netValue*0.18;
		double serviceTax=netValue*0.08;
		double total=netValue+gst+serviceTax;
		
		billDao.addBill(billId, orderId, amount, discountAmt, netValue, gst, serviceTax, total);
		
	}

	@Override
	public Bill getInvoiceByOrderId(int orderId){
		
		return billDao.getInvoiceByOrderId(orderId);
	}

	@Override
	public ArrayList<OrderTransaction> getOrderList(int orderId) {
		ArrayList<OrderTransaction> transList= transService.getOrderTranByOrderID(orderId);
		return transList;
	}


}

