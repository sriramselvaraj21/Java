package com.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.ItemDetailsMasterDto;
import com.model.*;
import com.service.ItemService;
import com.service.ManagerService;
import com.service.RegisterService;

@Controller
@RequestMapping("manager")
public class ManagerController {
	
	@Autowired
	private RegisterService rs;
	@Autowired
	private ManagerService ms;
	@Autowired
	private ItemService itemService;
	@RequestMapping(value="addAdmin",method=RequestMethod.POST)
	public ModelAndView addAdmin(ModelAndView mandv,HttpServletRequest request) {
		try {
			String uname=(String)request.getParameter("uname");
			String upass=(String)request.getParameter("upass");
			String urole=(String)request.getParameter("adminrole");
			
			rs.addAdminUser(uname, upass, Integer.parseInt(urole));
			
			mandv.setViewName("ManagerDashboard");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mandv;
	}
	
	@RequestMapping(value="getAddAdmin",method=RequestMethod.GET)
	public ModelAndView getform(ModelAndView mandv) {
		mandv.setViewName("AddAdminForm");
		return mandv;
	}
	
	@RequestMapping(value="checkItem",method=RequestMethod.POST)
	public ModelAndView checkItems(ModelAndView mandv) {
		
		ArrayList<ItemDetailsMasterDto> data=new ArrayList<>(itemService.getAllItems());
		System.out.println(data);
		mandv.addObject("tableData", data);
		mandv.setViewName("ItemTable");
		return mandv;
	}
	
	@RequestMapping(value = "getInvoiceCustId")
	public String getInvoiceByCus() {
		return "customerIdSearch";
	}
	
	@RequestMapping(value = "getInvoiceID")
	public String getInvoiceByInvId() {
		return "invoiceIdSearch";
	}
	
	@RequestMapping(value = "getItemID")
	public String getItemById() {
		return "itemIdSearch";
	}
	
	@RequestMapping(value = "displayItem")
	public ModelAndView displayItem(ModelAndView mv,HttpServletRequest req) {
		int itemNo = Integer.parseInt((String)req.getParameter("itemNo"));
		ItemDetailsMasterDto item = ms.getStockByItemId(itemNo);
		ArrayList<ItemDetailsMasterDto> data=new ArrayList<>();
		data.add(item);
		mv.addObject("tableData", data);
		mv.setViewName("ItemTable");
		return mv;
	}
		
	@RequestMapping(value = "displayResult")
	public ModelAndView displayCus(ModelAndView mv,HttpServletRequest req) {
		int custoNo = Integer.parseInt((String)req.getParameter("cusNo"));
		List<InvoiceMasterDto> invoice = ms.getInvByCustomerId(custoNo);
		mv.addObject("invoiceData",new ArrayList<InvoiceMasterDto>(invoice));
		mv.setViewName("InvoiceQueryResult");
		return mv;
	}
	
	@RequestMapping(value="getDash")
	public String getDash() {
		return "ManagerDashboard";
	}
	
	@RequestMapping(value="getInvoiceDate")
	public String getInvoiceByDate() {
		return "DateForm";
	}
	
	@RequestMapping(value="invoicebydate",method=RequestMethod.POST)
	public ModelAndView invoiceDateRange(ModelAndView mandv,HttpServletRequest request) {
		String start=(String)request.getParameter("sdate");
		String end=(String)request.getParameter("edate");
		List<InvoiceMasterDto> lis =  ms.getInvByDate(Date.valueOf(LocalDate.parse(start)),Date.valueOf(LocalDate.parse(end)));
		mandv.addObject("invoiceData",new ArrayList<InvoiceMasterDto>(lis));
		mandv.setViewName("InvoiceQueryResult");
		return mandv;
	}
	
	@RequestMapping(value="invoice",method=RequestMethod.POST)
	public ModelAndView finalInvoice(ModelAndView mandv,HttpServletRequest request) {
		String start=(String)request.getParameter("invno");
		InvoiceMasterDto inv =  ms.getByInvoiceNo(Integer.parseInt(start));
		ArrayList<ArrayList<String>> twd = inv.getInvdata();
		mandv.addObject("InvoiceData", twd);
		mandv.setViewName("FinalInvoice");
		return mandv;
	}
}
