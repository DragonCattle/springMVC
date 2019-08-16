package com.itheima.springMVC.mapper;


import java.util.List;

import com.itheima.springMVC.pojo.QueryVo;
import com.itheima.springMVC.pojo.User;



public interface UserMapper {
	/**
	 * 根据用户Id查询用户信息
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	
	/**
	 * 根据用户名查询用户信息
	 * @param name
	 * @return
	 */
	List<User> getUserByUserName(String name);
	
	/**
	 * 添加用户
	 * @param user
	 */
	void insertUser(User user);



}
