package com.itheima.springMVC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springMVC.pojo.Item;
import com.itheima.springMVC.pojo.QueryVo;
import com.itheima.springMVC.service.ItemService;

@Controller
//@RequestMapping("item")
public class ItemsController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value= {"itemsList","itemsList2","itemsList3"})
	public ModelAndView itemsList(HttpServletRequest request) {
		List<Item> list=itemService.getList();
		//创建对象ModelAndView
		ModelAndView mav=new ModelAndView();
		//设置商品数据
		mav.addObject("itemList", list);
		//设置视图名字
		mav.setViewName("itemList");
		
		return mav;
	}
	
	/*@RequestMapping("itemEdit")
	public ModelAndView itemEdit(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));
		
		Items items=itemService.getItemsById(id);
		
		//创建对象ModelAndView
		ModelAndView mav=new ModelAndView();
		//设置商品数据
		mav.addObject("item",items);
		//设置视图名字
		mav.setViewName("itemEdit");
				
		return mav;
	}*/

	
	
	@RequestMapping(value = {"itemEdit"})
	public ModelAndView itemEdit(@RequestParam("id")Integer id){
		
		Item items=itemService.getItemsById(id);
		
		//创建对象ModelAndView
		ModelAndView mav=new ModelAndView();
		//设置商品数据
		mav.addObject("item",items);
		//设置视图名字
		mav.setViewName("itemEdit");
				
		return mav;
	}
	
	/*@RequestMapping(value="updateItem",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateItem(Item items,Model model) {
		
		//创建对象ModelAndView
		ModelAndView mav=new ModelAndView();
		try {
			itemService.updateItems(items);
			mav.addObject("msg","修改成功");
		} catch (Exception e) {
			//设置商品数据
			mav.addObject("msg","修改失败");
			e.printStackTrace();
		}

		//设置视图名字
		mav.setViewName("itemEdit");
						
		return mav;
	}*/
	
	@RequestMapping(value="updateItem",method = {RequestMethod.GET,RequestMethod.POST})
	public String updateItem(Item items,Model model) {
		try {
			itemService.updateItems(items);
			model.addAttribute("item", items);
			model.addAttribute("msg","修改成功");
		} catch (Exception e) {
			//设置商品数据
			model.addAttribute("msg","修改失败");
			e.printStackTrace();
		}
		
		return "redirect:itemsList.action";
		//return "forward:itemEdit.action";
	}
	
	@RequestMapping("queryItem")
	public String queryItem(QueryVo vo, Integer[] ids,Model model) {
		System.out.println(vo.getItem().getName());
		//输出传入的数组
		if (ids != null && ids.length > 0) {
			for (Integer id : ids) {
				System.out.println("传入的商品列表分别为：" + id);
			}
		}
		if(vo!=null) {
			for (Item item:vo.getItems()) {
				System.out.println(item);
			}
		}

		return "itemList";
	}

	
	@RequestMapping("queryVoid")
	public void queryVoid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		//request响应用户请求(将数据存入session缓存里面)
		request.setAttribute("msg", "这是request跳转过来的消息");
		//request.getRequestDispatcher("/WEB-INF/jsp/msg.jsp").forward(request, response);
		
		//请求转发(可以传递request的参数)
		//request.getRequestDispatcher("itemsList.action").forward(request, response); 
		
		//重定向(不可以传递request的参数)
		response.sendRedirect("itemsList.action");
		
	}
	
	

}
