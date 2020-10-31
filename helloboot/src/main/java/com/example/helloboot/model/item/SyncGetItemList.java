package com.example.helloboot.model.item;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.example.helloboot.tool.ShopeeTool;

public class SyncGetItemList implements Callable<List<Item>>{

	private List<Item> list = new ArrayList<Item>();
	private List<Long> itemIds;
    private int shopId;
    
	public SyncGetItemList( List<Long> itemIds, int shopId) {
		this.itemIds = itemIds;
		this.shopId = shopId;
	}

	public SyncGetItemList() {}

	@Override
	public List<Item> call() throws Exception {
		
		itemIds.stream().forEach(itemId ->{
			//业务处理
	    	Item item = ShopeeTool.getItemDetail(this.shopId, itemId);
	    	if(item.getIs_2tier_item()) {
	    		String res = ShopeeTool.getVariations(itemId, this.shopId);
	        	item.setTier_variation(res);
	    	}
	    	list.add(item);
		});
		return list;
	}
}
