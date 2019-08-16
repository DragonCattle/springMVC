package com.itheima.springMVC.mapper;

import java.util.List;

import com.itheima.springMVC.pojo.Item;


public interface ItemsMapper {
	
	/**
	 * 查询全部商品
	 * @return
	 */
	List<Item> getList();
	
	
	/**
	 * 根据id查询商品
	 * @param id
	 * @return
	 */
	Item getItemsById(Integer id);
	
	/**
	 * 修改商品
	 * @param items
	 */
	void updateItems(Item items);
	
	
	/**
	 * 根据ID和name查询
	 * @param items
	 * @return
	 */
	List<Item> getByIdNameList(Item items);
	

}
