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
		//��������ModelAndView
		ModelAndView mav=new ModelAndView();
		//������Ʒ����
		mav.addObject("itemList", list);
		//������ͼ����
		mav.setViewName("itemList");
		
		return mav;
	}
	
	/*@RequestMapping("itemEdit")
	public ModelAndView itemEdit(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));
		
		Items items=itemService.getItemsById(id);
		
		//��������ModelAndView
		ModelAndView mav=new ModelAndView();
		//������Ʒ����
		mav.addObject("item",items);
		//������ͼ����
		mav.setViewName("itemEdit");
				
		return mav;
	}*/

	
	
	@RequestMapping(value = {"itemEdit"})
	public ModelAndView itemEdit(@RequestParam("id")Integer id){
		
		Item items=itemService.getItemsById(id);
		
		//��������ModelAndView
		ModelAndView mav=new ModelAndView();
		//������Ʒ����
		mav.addObject("item",items);
		//������ͼ����
		mav.setViewName("itemEdit");
				
		return mav;
	}
	
	/*@RequestMapping(value="updateItem",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateItem(Item items,Model model) {
		
		//��������ModelAndView
		ModelAndView mav=new ModelAndView();
		try {
			itemService.updateItems(items);
			mav.addObject("msg","�޸ĳɹ�");
		} catch (Exception e) {
			//������Ʒ����
			mav.addObject("msg","�޸�ʧ��");
			e.printStackTrace();
		}

		//������ͼ����
		mav.setViewName("itemEdit");
						
		return mav;
	}*/
	
	@RequestMapping(value="updateItem",method = {RequestMethod.GET,RequestMethod.POST})
	public String updateItem(Item items,Model model) {
		try {
			itemService.updateItems(items);
			model.addAttribute("item", items);
			model.addAttribute("msg","�޸ĳɹ�");
		} catch (Exception e) {
			//������Ʒ����
			model.addAttribute("msg","�޸�ʧ��");
			e.printStackTrace();
		}
		
		return "redirect:itemsList.action";
		//return "forward:itemEdit.action";
	}
	
	@RequestMapping("queryItem")
	public String queryItem(QueryVo vo, Integer[] ids,Model model) {
		System.out.println(vo.getItem().getName());
		//������������
		if (ids != null && ids.length > 0) {
			for (Integer id : ids) {
				System.out.println("�������Ʒ�б�ֱ�Ϊ��" + id);
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
		
		
		//request��Ӧ�û�����(�����ݴ���session��������)
		request.setAttribute("msg", "����request��ת��������Ϣ");
		//request.getRequestDispatcher("/WEB-INF/jsp/msg.jsp").forward(request, response);
		
		//����ת��(���Դ���request�Ĳ���)
		//request.getRequestDispatcher("itemsList.action").forward(request, response); 
		
		//�ض���(�����Դ���request�Ĳ���)
		response.sendRedirect("itemsList.action");
		
	}
	
	

}
