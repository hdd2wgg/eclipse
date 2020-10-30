package com.example.helloboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloboot.model.order.Items;
import com.example.helloboot.model.order.JsonOrders;
import com.example.helloboot.model.order.Orders;
import com.example.helloboot.model.order.impl.OrderService;
import com.example.helloboot.tool.ShopeeTool;

@RestController
@RequestMapping("/get")
public class OrderController {
	

	@Autowired
	@Qualifier("orderService")
	private OrderService orderservice;
	
	@RequestMapping("/updateOrders")
	public void updateOrders() {
		//
		int shopId = 129877668;
		
		JsonOrders jsonOrders;
		List<Orders> basicOrdersList;
		List<Orders> ordersDetailList;
		boolean more = true;
		while(more) {
			// 获取jsonOrders
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("create_time_from", 1603198568);
			con.put("create_time_to", 1603976169);
			con.put("shopid", shopId);
			con.put("pagination_entries_per_page", 100);
			con.put("pagination_offset", 0);
			jsonOrders =ShopeeTool.getJsonOrders(con) ;
			
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
			if(needUpdateOrderList != null) {
				// 调用 批量更新 Orders 方法
				orderservice.batchUpdateOrders(needUpdateOrderList);
			}
			
			// 提取出 需要添加到数据库中的新订单
			List<String> exceptList = ShopeeTool.getExceptList(allList, partList); // 需要插入的List
			System.out.println("提取新蛋:" + exceptList.size());
			// 获取 获取到json 中的人
			ordersDetailList = ShopeeTool.getJsonOrdersDetails(shopId, exceptList).getOrders();
			System.out.println("新订单：" + ordersDetailList.size());
			
			// 初始化订单中item 对应的订单号码
			ShopeeTool.initItemsOrdersn(ordersDetailList);
			
			// 提取出订单中的items放入一个List中
			List<Items> itemsList = ShopeeTool.getInsertOrderItems(ordersDetailList);
			
			// 初始化每个订单中items中的图片 地址
			ShopeeTool.initItemsImage_url(shopId, itemsList);
			
			// 将数据批量插入到数据库
			orderservice.batchInsertOrders(ordersDetailList);
			
			// items 插入批量插入到数据库中
			orderservice.batchInsertItems(itemsList);
			
		}
		
		// 条件查询返回给前端显示
	}
}
