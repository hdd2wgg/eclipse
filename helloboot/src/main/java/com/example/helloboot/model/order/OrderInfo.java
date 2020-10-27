package com.example.helloboot.model.order;

import java.util.List;

/**
 * @author Administrator
 *	定义订单写入数据库的接口
 */
public interface OrderInfo {
	
	// 批量更新订单
	void batchUpdateOrders();
	
	// 批量插入Items
	void batchInsertItems(List<Items> items);
	
	// 多种条件动态查询订单
	Orders queryOrdersByCondition();
	
	// 

}
