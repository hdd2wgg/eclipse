package com.example.helloboot.model.order.impl;

import java.util.List;
import java.util.Map;

import com.example.helloboot.model.order.Items;
import com.example.helloboot.model.order.Orders;
import com.example.helloboot.model.order.Shopee_Orders;


/**
 *	定义订单写入数据库的接口
 */
public interface OrderService {
	
	// 批量更新订单
	void batchUpdateOrders(List<Shopee_Orders> ordersList);
	
	/**
	 * @param ordersList
	 * 	批量将orders添加到数据库中
	 */
	void batchInsertOrders(List<Shopee_Orders> ordersList);
	
	// 批量插入Items
	void batchInsertItems(List<Items> items);
	
	// 根据ordersn 来查询items
	List<Items> queryItemsByOrdersn(String ordersn);
	
	// 多种条件动态查询订单
	Orders queryOrdersByCondition();
	
	/**
	 * @param ordersnList
	 * @return 获取 需要更新的orders 的 ordersn 订单编号集合
	 */
	List<String> queryOrdersnList(List<String> ordersnList);
	
	/**
	 * 	条件查询订单条件
	 * @param condition
	 * @return
	 */
	List<Orders> queryOrdersList(Map<String, Object> condition,int page,int size);
}
