package com.itheima.springMVC.pojo;

import java.util.List;

public class QueryVo {

	private Item item;
	
	//演示List参数传递
	private List<Item> items;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
