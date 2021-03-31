package shoppingapplication.model;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.ArrayList; // import the ArrayList class

public class InvoiceAction {

	public ArrayList<InvoiceDTO> getInvoice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("invoice generation");

		HttpSession session = request.getSession();
		ArrayList<InvoiceDTO> invoiceAL = new ArrayList<InvoiceDTO>(); // Create an ArrayList object

		try {
			Connection connection = DBUtility.getConnection();
			Enumeration keys = session.getAttributeNames();
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				System.out.println("Keys" + key);
				if (key != "username" && key != "password" && key != "rb" && key != "grandTotal	") {
					String value = (String) session.getAttribute(key);
					if (value.equalsIgnoreCase("rice") || value.equalsIgnoreCase("channa")
							|| value.equalsIgnoreCase("dhall")) {
						PreparedStatement ps = connection
								.prepareStatement("select * from groceryshop where itemname=?");
						ps.setString(1, value);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							InvoiceDTO invoice = new InvoiceDTO();
							invoice.setItemId(rs.getInt(1));
							invoice.setItemName(rs.getString(2));
							invoice.setItemBrand(rs.getString("itembrand"));
							invoice.setPrice(rs.getInt(4));
							invoice.setQuantity(rs.getInt(5));
							invoice.setItemImage(rs.getString("picture"));
							invoiceAL.add(invoice);
						}
					} else if (value.equalsIgnoreCase("bangle") || value.equalsIgnoreCase("chain")
							|| value.equalsIgnoreCase("ring")) {
						PreparedStatement ps = connection
								.prepareStatement("select * from jewelleryshop where itemname=?");
						ps.setString(1, value);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							InvoiceDTO invoice = new InvoiceDTO();
							invoice.setItemId(rs.getInt(1));
							invoice.setItemName(rs.getString(2));
							invoice.setItemBrand(rs.getString("itembrand"));
							invoice.setPrice(rs.getInt(4));
							invoice.setQuantity(rs.getInt(5));
							invoice.setItemImage(rs.getString("picture"));
							invoiceAL.add(invoice);
						}
					} else if (value.equalsIgnoreCase("mango") || value.equalsIgnoreCase("apple")
							|| value.equalsIgnoreCase("jackfruit")) {
						PreparedStatement ps = connection.prepareStatement("select * from fruitshop where itemname=?");
						ps.setString(1, value);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							InvoiceDTO invoice = new InvoiceDTO();
							invoice.setItemId(rs.getInt(1));
							invoice.setItemName(rs.getString(2));
							invoice.setItemBrand(rs.getString("itembrand"));
							invoice.setPrice(rs.getInt(4));
							invoice.setQuantity(rs.getInt(5));
							invoice.setItemImage(rs.getString("picture"));
							invoiceAL.add(invoice);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finallyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
			Enumeration keys = session.getAttributeNames();
			while (keys.hasMoreElements()) {
				System.out.println("keys   :  " + keys.nextElement());
			}
			System.out.println("Invoice done");
		}

		return invoiceAL;
	}

}
