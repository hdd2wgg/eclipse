package com.example.helloboot.model.item;

import java.util.List;

/**
* Auto-generated: 2020-10-20 21:10:34
*
* @author bejson.com (i@bejson.com)
* @website http://www.bejson.com/java2pojo/
*/
public class JsonItem {

	private Item item;
    private String warning;
    
	private List<Item> items;
    private String request_id;
    private boolean more;
    private int total;
	public JsonItem() {}
	public List<Item> getItems() {
		return items;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public boolean isMore() {
		return more;
	}
	public void setMore(boolean more) {
		this.more = more;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
