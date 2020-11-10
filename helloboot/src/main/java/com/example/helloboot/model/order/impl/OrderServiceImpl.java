package com.example.helloboot.model.order.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloboot.model.order.Items;
import com.example.helloboot.model.order.Orders;
import com.example.helloboot.model.order.Shopee_Orders;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public void batchUpdateOrders(List<Shopee_Orders> ordersList) {
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
		return orderMapper.queryOrdersnList(ordersnList);
	}

	@Override
	public void batchInsertOrders(List<Shopee_Orders> ordersList) {
		orderMapper.batchInsertOrders(ordersList);
	}

	@Override
	public List<Items> queryItemsByOrdersn(String ordersn) {
		return orderMapper.queryItemsByOrdersn(ordersn);
	}

	@Override
	public List<Orders> queryOrdersList(Map<String, Object> condition, int page, int size) {
		return orderMapper.queryOrdersList(condition, page, size);
	}

}
