package com.example.helloboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloboot.model.order.Items;
import com.example.helloboot.model.order.JsonOrders;
import com.example.helloboot.model.order.Orders;
import com.example.helloboot.model.order.impl.OrderService;
import com.example.helloboot.tool.ShopeeTool;

@RestController
public class OrderController {
	

	@Autowired
	@Qualifier("orderService")
	private OrderService orderservice;
	
	public void updateOrders( int shopId ) {
		//
		JsonOrders jsonOrders;
		List<Orders> basicOrdersList;
		List<Orders> ordersDetailList;
		boolean more = true;
		while(more) {
			// 获取jsonOrders
			jsonOrders =ShopeeTool.getJsonOrders(null) ;
			
			// 判断是否还有更多
			more = jsonOrders.isMore();
			
			// 获取订单列表
			basicOrdersList = jsonOrders.getOrders();
			
			// 提取出所有订单的订单号ordesn->List:String
			List<String> allList = ShopeeTool.getAllList(basicOrdersList);
			
			// 从数据库中查询需要更新的订单的 ordersn 集合
			List<String> partList = orderservice.queryOrdersnList(allList);
			
			// 提取出只需要更新的订单的列表
			List<Orders> needUpdateOrderList = ShopeeTool.getUpdateOrdersList(basicOrdersList, partList);
			
			// 调用 批量更新 Orders 方法
			orderservice.batchUpdateOrders(needUpdateOrderList);
			
			
			// 提取出 需要添加到数据库中的新订单
			List<String> exceptList = ShopeeTool.getExceptList(allList, partList); // 需要插入的List
			
			// 获取 获取到json 中的人
			ordersDetailList = ShopeeTool.getJsonOrdersDetails(shopId, exceptList).getOrders();
			
			for (Orders orders : ordersDetailList) {
				List<Items> itemsList = orders.getItems();
				for (Items items : itemsList) {
					items.setOrdersn(orders.getOrdersn());
					items.setImage_url(ShopeeTool.get_image_url(shopId, items.getItem_id(), items.getVariation_name()));
				}
			}
			
			// 将数据批量插入到数据库
			orderservice.batchInsertOrders(ordersDetailList);
			// 
			List<Items> itemsList = ShopeeTool.getInsertOrderItems(ordersDetailList);
			// items 插入批量插入到数据库中
			orderservice.batchInsertItems(itemsList);
			
		}
		
		// 条件查询返回给前端显示
	}
}
