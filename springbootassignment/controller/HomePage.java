package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.ItemDetailsMasterDto;
import com.service.ShopService;

@Controller
@RequestMapping("/")
public class HomePage {
	@Autowired
	private ShopService ss;
	@RequestMapping("/")
	public String index() {
		return "index"; 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/loaddata",method = RequestMethod.GET)
	public void loaddata() {
		try {
            FileInputStream fi = new FileInputStream(new File("C:\\eclipse\\eclipse-workspace\\shoppingcart-final\\src\\main\\java\\com\\controller\\itemdata.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            List<ItemDetailsMasterDto> itemdata=(List<ItemDetailsMasterDto>)oi.readObject();
            
            ss.addItems(itemdata);
            //ss.addInvoiceMaster(1, 1);
            oi.close();
            fi.close();

        } catch (Exception e) {
            e.printStackTrace();
        } 
	}
	
	@RequestMapping(value="/adminLogin")
	public String getAdminLogin() {
		return "AdminLogin";
	}
}
