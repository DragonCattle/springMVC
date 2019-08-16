package com.itheima.springMVC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.springMVC.mapper.ItemsMapper;
import com.itheima.springMVC.pojo.Item;
import com.itheima.springMVC.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	public List<Item> getList(){
		
		return this.itemsMapper.getList();
	}

	public Item getItemsById(Integer id) {
		return this.itemsMapper.getItemsById(id);
	}

	public void updateItems(Item items) {
		
		this.itemsMapper.updateItems(items);
	}

	public List<Item> getByIdNameList(Item items) {
		
		return null;
	}

}
