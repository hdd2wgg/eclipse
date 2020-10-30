package com.example.helloboot.model.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloboot.model.order.Items;
import com.example.helloboot.model.order.Orders;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public void batchUpdateOrders(List<Orders> ordersList) {
		orderMapper.batchUpdateOrders(ordersList);
	}

	@Override
	public void batchInsertItems(List<Items> items) {
		orderMapper.batchInsertItems(items);
	}

	@Override
	public Orders queryOrdersByCondition() {
		return null;
	}

	@Override
	public List<String> queryOrdersnList(List<String> ordersnList) {
		// TODO Auto-generated method stub
		return orderMapper.queryOrdersnList(ordersnList);
	}

	@Override
	public void batchInsertOrders(List<Orders> ordersList) {
		orderMapper.batchInsertOrders(ordersList);
	}

}
