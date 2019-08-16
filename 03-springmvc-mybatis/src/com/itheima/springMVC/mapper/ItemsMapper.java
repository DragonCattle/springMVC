package com.itheima.springMVC.mapper;

import java.util.List;

import com.itheima.springMVC.pojo.Item;


public interface ItemsMapper {
	
	/**
	 * ��ѯȫ����Ʒ
	 * @return
	 */
	List<Item> getList();
	
	
	/**
	 * ����id��ѯ��Ʒ
	 * @param id
	 * @return
	 */
	Item getItemsById(Integer id);
	
	/**
	 * �޸���Ʒ
	 * @param items
	 */
	void updateItems(Item items);
	
	
	/**
	 * ����ID��name��ѯ
	 * @param items
	 * @return
	 */
	List<Item> getByIdNameList(Item items);
	

}
