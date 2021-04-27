package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.ItemTransactionDetailsDto;
import com.service.ShopService;
import com.formbeans.TableBean;
import com.model.InvoiceKey;
import com.model.ItemDetailsMasterDto;
@Controller
@Transactional
@RequestMapping("loadshop")
public class ShopController {
	@Autowired
	private ShopService ss;
	@RequestMapping(value="shop1",method= RequestMethod.GET)
	public ModelAndView getShop1(ModelAndView mandv,HttpSession session) {
		mandv.setViewName("Shop1");
		if(session.getAttribute("invoice")==null) {
			ArrayList<ItemTransactionDetailsDto> temp1=new ArrayList<ItemTransactionDetailsDto>();
			session.setAttribute("invoice", temp1);
			//session.setAttribute("invno",Integer.toString(ss.getInvoiceNumber()));
		}
		mandv.addObject("shopdata",ss.getDetails(1));
		return mandv;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="shop2",method= RequestMethod.POST)
	public ModelAndView getShop2(ModelAndView mandv,HttpSession session,HttpServletRequest request) throws Exception {
		mandv.setViewName("Two");
		int shopNumber=1;
		ArrayList<ItemDetailsMasterDto>data=ss.getDetails(shopNumber);
		for(int i=0;i<data.size();i++) {
			ItemTransactionDetailsDto itemdata=new ItemTransactionDetailsDto();
			InvoiceKey ik=new InvoiceKey();
			//ik.setInvno(Integer.parseInt((String)session.getAttribute("invno")));
			ik.setItemno(data.get(i).getItemno());
			itemdata.setInvkey(ik);
			itemdata.setQty(Integer.parseInt(request.getParameter(Integer.toString(data.get(i).getItemno()))));
			ArrayList<ItemTransactionDetailsDto> te=(ArrayList<ItemTransactionDetailsDto>)session.getAttribute("invoice");
			if(itemdata.getQty()==0) {
				continue;
			}
			te.add(itemdata);
			session.setAttribute("invoice", te);
		}
		ArrayList<ItemTransactionDetailsDto> te=(ArrayList<ItemTransactionDetailsDto>)session.getAttribute("invoice");
		System.out.println(te);
		mandv.addObject("shopdata",ss.getDetails(2));
		return mandv;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="shop3",method= RequestMethod.POST)
	public ModelAndView getShop3(ModelAndView mandv,HttpSession session,HttpServletRequest request) throws Exception{
		mandv.setViewName("Three");
		int shopNumber=2;
		ArrayList<ItemDetailsMasterDto>data=ss.getDetails(shopNumber);
		for(int i=0;i<data.size();i++) {
			ItemTransactionDetailsDto itemdata=new ItemTransactionDetailsDto();
			InvoiceKey ik=new InvoiceKey();
			//ik.setInvno(Integer.parseInt((String)session.getAttribute("invno")));
			ik.setItemno(data.get(i).getItemno());
			itemdata.setInvkey(ik);
			itemdata.setQty(Integer.parseInt(request.getParameter(Integer.toString(data.get(i).getItemno()))));
			ArrayList<ItemTransactionDetailsDto> te=(ArrayList<ItemTransactionDetailsDto>)session.getAttribute("invoice");
			if(itemdata.getQty()==0) {
				continue;
			}
			te.add(itemdata);
			session.setAttribute("invoice", te);
		}
		ArrayList<ItemTransactionDetailsDto> te=(ArrayList<ItemTransactionDetailsDto>)session.getAttribute("invoice");
		System.out.println(te);
		mandv.addObject("shopdata",ss.getDetails(3));
		return mandv;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="savedata",method= RequestMethod.POST)
	public ModelAndView savedata(ModelAndView mandv,HttpSession session,HttpServletRequest request) throws Exception{
		mandv.setViewName("Invoice");
		int shopNumber=3;
		ArrayList<ItemDetailsMasterDto>data=ss.getDetails(shopNumber);
		for(int i=0;i<data.size();i++) {
			ItemTransactionDetailsDto itemdata=new ItemTransactionDetailsDto();
			InvoiceKey ik=new InvoiceKey();
			//ik.setInvno(Integer.parseInt((String)session.getAttribute("invno")));
			ik.setItemno(data.get(i).getItemno());
			itemdata.setInvkey(ik);
			itemdata.setQty(Integer.parseInt(request.getParameter(Integer.toString(data.get(i).getItemno()))));
			ArrayList<ItemTransactionDetailsDto> te=(ArrayList<ItemTransactionDetailsDto>)session.getAttribute("invoice");
			if(itemdata.getQty()==0) {
				continue;
			}
			te.add(itemdata);
			session.setAttribute("invoice", te);
		}
		ArrayList<ItemTransactionDetailsDto> te=(ArrayList<ItemTransactionDetailsDto>)session.getAttribute("invoice");
		System.out.println(te);
		ArrayList<TableBean> tdata=new ArrayList<TableBean>();
		for(int i=0;i<te.size();i++) {
			TableBean tb=new TableBean();
			tb.setDesc(ss.getItemDetails(te.get(i).getInvkey().getItemno()).getItemdescription() );
			tb.setQty(te.get(i).getQty());
			tdata.add(tb);
		}
		System.out.println("----------------------"+tdata);
		mandv.addObject("tdata", tdata);
		return mandv;
	}
	
	@RequestMapping(value="createdata",method= RequestMethod.GET)
	public ModelAndView createdata(ModelAndView mandv,HttpSession session) {
		mandv.setViewName("Busy");
		//ss.addInvoiceMaster(1, 0);
		System.out.println(ss.getInvoiceNumber());
		//mandv.addObject("shopdata",ss.getDetails(3));
		return mandv;
	}
	
}
