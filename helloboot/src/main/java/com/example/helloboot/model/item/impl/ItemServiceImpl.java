package com.example.helloboot.model.item.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloboot.model.item.Item;

@Service("itemService")
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public void batchInsertItems(List<Item> itemList) {
		itemMapper.batchInsertItems(itemList);
	}

}
