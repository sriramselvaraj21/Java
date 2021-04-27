package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.ItemDetailsMasterDto;
import com.service.ItemService;

@Controller
@Transactional
@RequestMapping(value="item")
public class ItemDetailsController {	
	@Autowired
	private ItemService itemService;
	
	
	public synchronized final ItemService getItemService() {
		return itemService;
	}


	public synchronized final void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}


	@RequestMapping(value="applychanges",method=RequestMethod.POST)
	public ModelAndView doChanges(ModelAndView mandv,HttpServletRequest request) {
		try {
			HttpSession session=request.getSession();
			
			String itemname=(String)request.getParameter("itemname");
			String imgurl=(String)request.getParameter("imageurl");
			String itemunits=(String)request.getParameter("itemunits");
			String shopname=(String)request.getParameter("shopname");
			String itemprice=(String)request.getParameter("itemprice");
			
			ItemDetailsMasterDto item=ItemDetailsMasterDto.getClone();
			
			item.setImageurl(imgurl);
			item.setItemdescription(itemname);
			item.setItemprice(Integer.parseInt(itemprice));
			item.setShopid(Integer.parseInt(shopname));
			item.setItemunits(Integer.parseInt(itemunits));
			
			String button=(String)session.getAttribute("ButtonFlag");
			System.out.println("-------Changes Button  "+button);
			if(button.equals("add")) {
				itemService.addItem(item);
			}
			if(button.equals("modify")) {
				itemService.updateItem(item);
			}
			if(button.equals("delete")) {
				itemService.deleteItem(item);
			}
			mandv.setViewName("AdminDashboard");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mandv;
	}
	
	
	@RequestMapping(value="dashboard",method=RequestMethod.POST)
	public ModelAndView manageDashboard(ModelAndView mandv,HttpServletRequest request) {
		try {
			HttpSession session=request.getSession();
			String add=(String)request.getParameter("add");
			String delete=(String)request.getParameter("delete");
			String modify=(String)request.getParameter("modify");
			
			mandv.setViewName("AddItemForm");
			if(add!=null) {
				session.setAttribute("ButtonFlag","add");
			}
			if(modify!=null) {
				session.setAttribute("ButtonFlag","modify");
			}
			if(delete!=null) {
				session.setAttribute("ButtonFlag", "delete");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mandv;
	}
}
