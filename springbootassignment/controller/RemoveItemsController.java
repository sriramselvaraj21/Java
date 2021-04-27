package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formbeans.TableBean;
import com.model.InvoiceKey;
import com.model.ItemTransactionDetailsDto;
import com.service.InvoiceService;
import com.service.ShopService;

@Controller
@Transactional
@RequestMapping("removeitems")
public class RemoveItemsController {
	@Autowired
	InvoiceService ig;
	@Autowired
	private ShopService ss;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="remove",method=RequestMethod.POST)
	public ModelAndView removeItem(HttpServletRequest request,ModelAndView mandv) {
		HttpSession session=request.getSession();
		try {
			
			ArrayList<ItemTransactionDetailsDto> data=(ArrayList<ItemTransactionDetailsDto>)session.getAttribute("invoice");
			for(int i=0;i<data.size();i++) {
				if(request.getParameter(Integer.toString(i+1))!=null) {
					data.remove(i);
				}
			}
			session.setAttribute("invoice", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mandv.setViewName("Invoice");
		ArrayList<ItemTransactionDetailsDto> transactionData=(ArrayList<ItemTransactionDetailsDto>)session.getAttribute("invoice");
		//System.out.println(transactionData);
		ArrayList<TableBean> tdata=new ArrayList<TableBean>();
		for(int i=0;i<transactionData.size();i++) {
			TableBean tb=new TableBean();
			tb.setDesc(ss.getItemDetails(transactionData.get(i).getInvkey().getItemno()).getItemdescription() );
			tb.setQty(transactionData.get(i).getQty());
			tdata.add(tb);
		}
		mandv.addObject("tdata", tdata);
		return mandv;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="download",method=RequestMethod.POST)
	public ModelAndView getDownload(ModelAndView mandv,HttpSession session) {
		
		int custno=(Integer)session.getAttribute("id");
		int invno=ss.addInvoiceMaster(custno);
		session.setAttribute("invno", invno);
		ArrayList<ItemTransactionDetailsDto> data=(ArrayList<ItemTransactionDetailsDto>)session.getAttribute("invoice");
		for(int i=0;i<data.size();i++) {
			ss.updateItemUnits(data.get(i).getInvkey().getItemno(),data.get(i).getQty());
			int temp=data.get(i).getInvkey().getItemno();
			InvoiceKey ik=new InvoiceKey();
			ik.setItemno(temp);
			ik.setInvno(invno);
			
			data.get(i).setInvkey(ik);
			ss.addIteminInvoice(data.get(i));
		}
		//System.out.println("Invoice ArrayList-------"+ig.getInvoice(invno));
		mandv.addObject("InvoiceData",ig.getInvoice(invno));
		ss.addListToInvoice(invno,ig.getInvoice(invno));
		mandv.setViewName("invoicePayment");
		
		
		return mandv;
	}
}
