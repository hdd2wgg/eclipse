package com.example.helloboot.model.order.impl;

import java.util.List;

import com.example.helloboot.model.order.Items;
import com.example.helloboot.model.order.Orders;


/**
 *	定义订单写入数据库的接口
 */
public interface OrderService {
	
	// 批量更新订单
	void batchUpdateOrders(List<Orders> ordersList);
	
	// 批量插入Items
	void batchInsertItems(List<Items> items);
	
	// 多种条件动态查询订单
	Orders queryOrdersByCondition();
	
	/**
	 * @param ordersnList
	 * @return 获取 需要更新的orders 的 ordersn 订单编号集合
	 */
	List<String> queryOrdersnList(List<String> ordersnList);
}
