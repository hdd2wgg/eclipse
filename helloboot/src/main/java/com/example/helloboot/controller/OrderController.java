package com.example.helloboot.controller;

import java.util.List;

import javax.management.Query;

import org.springframework.web.bind.annotation.RestController;

import com.example.helloboot.model.order.JsonOrders;
import com.example.helloboot.model.order.Orders;
import com.example.helloboot.tool.ShopeeTool;

@RestController
public class OrderController {

	
	public static void updateOrders() {
		//
		JsonOrders jsonOrders;
		List<Orders> basicOrdersList;
		boolean more = true;
		while(more) {
			jsonOrders =null ;
			more = jsonOrders.isMore();
			basicOrdersList = jsonOrders.getOrders();
			List<String> allList = ShopeeTool.getAllList(basicOrdersList);
			List<String> partList = null;
			List<String> exceptList = ShopeeTool.getExceptList(allList, partList); // 需要插入的List
			
			List<Orders> needUpdateOrderList = ShopeeTool.getUpdateOrdersList(basicOrdersList, partList);
			
			List<Orders> needInsertOrderList = null;
			
		}
		
		// 条件查询返回给前端显示
	}
}
