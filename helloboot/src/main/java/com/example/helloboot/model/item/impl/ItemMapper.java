package com.example.helloboot.model.item.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.example.helloboot.model.item.Item;

@Mapper
public interface ItemMapper {

	//批量插入Item数据
	@Update("<script> REPLACE INTO t_item "
			+ " (logistics,original_price,package_width,cmt_count,weight,shopid,currency,"
			+ "create_time,likes,images,is_2tier_item,days_to_ship,package_length,reserved_stock,stock,`status`,update_time,description,"
			+ "views,price,sales,discount_id,item_id,wholesales,`condition`,package_height,`name`,rating_star,item_sku,"
			+ "variations,tier_variation,size_chart,is_pre_order,has_variation,attributes,category_id) "
			+ " VALUES "
			+ " <foreach collection='itemList' item='ite' separator=','> "
			+ "("
			+ "#{ite.logistics},"
			+ "#{ite.original_price},"
			+ "#{ite.package_width},"
			+ "#{ite.cmt_count},"
			+ "#{ite.weight},"
			+ "#{ite.shopid},"
			+ "#{ite.currency},"
			+ "#{ite.create_time},"
			+ "#{ite.likes},"
			+ "#{ite.images},"
			+ "#{ite.is_2tier_item},"
			+ "#{ite.days_to_ship},"
			+ "#{ite.package_length},"
			+ "#{ite.reserved_stock},"
			+ "#{ite.stock},"
			+ "#{ite.status},"
			+ "#{ite.update_time},"
			+ "#{ite.description},"
			+ "#{ite.views},"
			+ "#{ite.price},"
			+ "#{ite.sales},"
			+ "#{ite.discount_id},"
			+ "#{ite.item_id},"
			+ "#{ite.wholesales},"
			+ "#{ite.condition},"
			+ "#{ite.package_height},"
			+ "#{ite.name},"
			+ "#{ite.rating_star},"
			+ "#{ite.item_sku},"
			+ "#{ite.variations},"
			+ "#{ite.tier_variation},"
			+ "#{ite.size_chart},"
			+ "#{ite.is_pre_order},"
			+ "#{ite.has_variation},"
			+ "#{ite.attributes},"
			+ "#{ite.category_id}"
			+ " ) "
			+ " </foreach> "
			+ "</script>")
	void batchInsertItems(@Param("itemList") List<Item> itemList);
}
