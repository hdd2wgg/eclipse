package com.example.helloboot.model.order.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.helloboot.model.order.Items;
import com.example.helloboot.model.order.Orders;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	

	@Override
	public void batchUpdateOrders(List<Orders> ordersList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchInsertItems(List<Items> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders queryOrdersByCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> queryOrdersnList(List<String> ordersnList) {
		// TODO Auto-generated method stub
		return null;
	}

}
