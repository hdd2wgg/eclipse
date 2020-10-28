package com.example.helloboot.controller;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloboot.model.order.JsonOrders;
import com.example.helloboot.model.order.Orders;
import com.example.helloboot.model.order.impl.OrderServiceImpl;
import com.example.helloboot.model.order.impl.OrderService;
import com.example.helloboot.tool.ShopeeTool;

@RestController
public class OrderController {
	
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;

	
	public static void updateOrders() {
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
//			List<String> partList = orderService.
			
			// 提取出 需要添加到数据库中的新订单
//			List<String> exceptList = ShopeeTool.getExceptList(allList, partList); // 需要插入的List
//			
//			// 提取出只需要更新的订单的列表
//			List<Orders> needUpdateOrderList = ShopeeTool.getUpdateOrdersList(basicOrdersList, partList);
//			// 将数据更新到数据库
//			
//			// 提取出需要插入的订单
//			List<Orders> needInsertOrderList = null;
			
		}
		
		// 条件查询返回给前端显示
	}
}
