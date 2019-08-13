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
		System.out.println("ǰ�˷�������");
		//��������ModelAndView
		ModelAndView mav=new ModelAndView();
		//����ģ������
		mav.addObject("msg","hello springMVC...");
		//������ͼ��
		mav.setViewName("/WEB-INF/jsp/hello.jsp");
		
		return mav;
	}
	@RequestMapping("itemList")
	public ModelAndView itemList() {
		ModelAndView mav = new ModelAndView();
		List<Items> itemList = new ArrayList<Items>();
		itemList.add(new Items(1, "����", 1999.0, new Date(), "��������"));
		itemList.add(new Items(2, "����2", 1999.0, new Date(), "��������2"));
		itemList.add(new Items(3, "����3", 1999.0, new Date(), "��������3"));
		itemList.add(new Items(4, "����4", 1999.0, new Date(), "��������4"));
		itemList.add(new Items(5, "����5", 1999.0, new Date(), "��������5"));
		//������Ʒ����
		mav.addObject("itemList", itemList);
		//������ͼ����
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		
		return mav;
	}
	
	

}
