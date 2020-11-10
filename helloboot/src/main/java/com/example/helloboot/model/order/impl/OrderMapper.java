package com.example.helloboot.model.order.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.example.helloboot.model.order.Items;
import com.example.helloboot.model.order.Orders;
import com.example.helloboot.model.order.Shopee_Orders;

@Mapper
public interface OrderMapper {

	@Update("<script> INSERT INTO t_orders "
			+ " (estimated_shipping_fee,order_flag,payment_method,update_time,message_to_seller,"
			+ "shipping_carrier,currency,create_time,pay_time,note,credit_card_number,days_to_ship,"
			+ "is_split_up,ship_by_date,escrow_tax,tracking_no,order_status,note_update_time,"
			+ "fm_tn,dropshipper_phone,cancel_reason,recipient_address,cancel_by,escrow_amount,"
			+ "buyer_cancel_reason,goods_to_declare,total_amount,service_code,"
			+ "actual_shipping_cost,cod,country,ordersn,dropshipper,is_actual_shipping_fee_confirmed,buyer_username) "
			+ " VALUES "
			+ " <foreach collection='ordersList' item='orders' separator=','> "
			+ "(#{orders.estimated_shipping_fee},"
			+ "#{orders.order_flag},"
			+ "#{orders.payment_method},"
			+ "#{orders.update_time},"
			+ "#{orders.message_to_seller},"
			+ "#{orders.shipping_carrier},"
			+ "#{orders.currency},"
			+ "#{orders.create_time},"
			+ "#{orders.pay_time},"
			+ "#{orders.note},"
			+ "#{orders.credit_card_number},"
			+ "#{orders.days_to_ship},"
			+ "#{orders.is_split_up},"
			+ "#{orders.ship_by_date},"
			+ "#{orders.escrow_tax},"
			+ "#{orders.tracking_no},"
			+ "#{orders.order_status},"
			+ "#{orders.note_update_time},"
			+ "#{orders.fm_tn},"
			+ "#{orders.dropshipper_phone},"
			+ "#{orders.cancel_reason},"
			+ "#{orders.recipient_address},"
			+ "#{orders.cancel_by},"
			+ "#{orders.escrow_amount},"
			+ "#{orders.buyer_cancel_reason},"
			+ "#{orders.goods_to_declare},"
			+ "#{orders.total_amount},"
			+ "#{orders.service_code},"
			+ "#{orders.actual_shipping_cost},"
			+ "#{orders.cod},"
			+ "#{orders.country},"
			+ "#{orders.ordersn},"
			+ "#{orders.dropshipper},"
			+ "#{orders.is_actual_shipping_fee_confirmed},"
			+ "#{orders.buyer_username})"
			+ "</foreach>"
			+ "</script>")
	void batchInsertOrders(@Param("ordersList") List<Shopee_Orders> ordersList);
	
	/**
	 * 	批量修改Orders 中的订单数据
	 * @param ordersList
	 */
	@Update("<script> "
			+ " <foreach collection='ordersList' item='order' index='index' open='' close='' separator=';'>"
			+ " UPDATE t_orders "
			+ " SET order_status=#{order.order_status},update_time=#{order.update_time} "
			+ "WHERE ordersn=#{order.ordersn}"
			+ "</foreach>"
			+ "</script>")
	void batchUpdateOrders(@Param("ordersList") List<Shopee_Orders> ordersList); 
	/**
	 * @param ordersnList
	 * @return 返回查询到的结果哦
	 */
	@Select("<script> "
			+ "SELECT ordersn from t_orders WHERE ordersn IN ("
			+ "<foreach collection='list' item='ite' separator=','>"
			+ "#{ite}"
			+ "</foreach>"
			+ ") </script>")
	List<String> queryOrdersnList(List<String> ordersnList);
	
	
	// 批量插入Items
	@Update("<script> INSERT INTO t_order_items "
			+" (weight,item_name,is_wholesale,promotion_type,item_sku,variation_discounted_price,variation_id,variation_name,"
			+ "is_set_item,is_add_on_deal,item_id,promotion_id,add_on_deal_id,variation_quantity_purchased,variation_sku,"
			+ "variation_original_price,is_main_item,ordersn) "
			+ " VALUES "
			+" <foreach collection='items' item='ite' separator=','> "
			+"(#{ite.weight},"
			+"#{ite.item_name},"
			+"#{ite.is_wholesale},"
			+"#{ite.promotion_type},"
			+"#{ite.item_sku},"
			+"#{ite.variation_discounted_price},"
			+"#{ite.variation_id},"
			+"#{ite.variation_name},"
			+"#{ite.is_set_item},"
			+"#{ite.is_add_on_deal},"
			+"#{ite.item_id},"
			+"#{ite.promotion_id},"
			+"#{ite.add_on_deal_id},"
			+"#{ite.variation_quantity_purchased},"
			+"#{ite.variation_sku},"
			+"#{ite.variation_original_price},"
			+"#{ite.is_main_item},"
			+"#{ite.ordersn})"
			+" </foreach> "
			+ " </script>")
	void batchInsertItems(@Param("items") List<Items> items);
	
	/**
	 * 	根据订单号码查询订单的产品的列表
	 * @param ordersn
	 * @return
	 */
	@Select("SELECT o.ordersn,o.is_main_item,o.variation_original_price,i.tier_variation,i.images,o.variation_sku,o.variation_quantity_purchased,o.add_on_deal_id,o.promotion_id,o.item_id,o.is_add_on_deal,o.is_set_item,o.variation_name,o.variation_id,o.variation_discounted_price,o.item_sku,o.promotion_type,o.is_wholesale,o.item_name,o.weight FROM t_order_items as o,t_item as i WHERE i.item_id = o.item_id AND o.ordersn =#{ordersn};")
	List<Items> queryItemsByOrdersn(@Param("ordersn")String ordersn);
	
	/**
	 * 	条件查询订单条件
	 * @param condition
	 * @return
	 */
	@Select(" SELECT "
			+ " estimated_shipping_fee,order_flag,payment_method,update_time,message_to_seller,shipping_carrier,currency,create_time,pay_time,note,credit_card_number,days_to_ship,is_split_up,ship_by_date,escrow_tax,tracking_no,order_status,note_update_time,fm_tn,dropshipper_phone,cancel_reason,recipient_address,cancel_by,escrow_amount,buyer_cancel_reason,goods_to_declare,total_amount,service_code,actual_shipping_cost,cod,country,ordersn,dropshipper,is_actual_shipping_fee_confirmed,buyer_username "
			+ " FROM t_orders "
	
//			+ " WHERE order_status =#{ordersn} "
			+ " LIMIT #{page},#{size} ")
	@Results({
		@Result(column="ordersn",property="ordersn"),
		@Result(column="ordersn",property="items",many=@Many(
				select="com.example.helloboot.model.order.impl.OrderMapper.queryItemsByOrdersn",fetchType=FetchType.LAZY
				))
	})
	List<Orders> queryOrdersList(Map<String, Object> condition,int page,int size);
}
