package com.example.helloboot.model.item.impl;

import java.util.List;

import com.example.helloboot.model.item.Item;

public interface ItemService {

	//批量插入Item数据
	void batchInsertItems(List<Item> itemList);
}
