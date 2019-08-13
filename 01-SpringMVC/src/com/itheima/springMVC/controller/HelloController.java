package com.itheima.springMVC.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springMVC.pojo.Items;

@Controller
public class HelloController {
	
	@RequestMapping("hello")
	public ModelAndView hello() {
		System.out.println("前端访问来了");
		//创建对象ModelAndView
		ModelAndView mav=new ModelAndView();
		//设置模型数据
		mav.addObject("msg","hello springMVC...");
		//设置视图名
		mav.setViewName("/WEB-INF/jsp/hello.jsp");
		
		return mav;
	}
	@RequestMapping("itemList")
	public ModelAndView itemList() {
		ModelAndView mav = new ModelAndView();
		List<Items> itemList = new ArrayList<Items>();
		itemList.add(new Items(1, "冰箱", 1999.0, new Date(), "质量不错"));
		itemList.add(new Items(2, "冰箱2", 1999.0, new Date(), "质量不错2"));
		itemList.add(new Items(3, "冰箱3", 1999.0, new Date(), "质量不错3"));
		itemList.add(new Items(4, "冰箱4", 1999.0, new Date(), "质量不错4"));
		itemList.add(new Items(5, "冰箱5", 1999.0, new Date(), "质量不错5"));
		//设置商品数据
		mav.addObject("itemList", itemList);
		//设置视图名字
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		
		return mav;
	}
	
	

}
