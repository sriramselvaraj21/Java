package jpashoppingapp.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import training.model.InvoiceMasterDTO;

public class InvoiceMasterDAO {

	public static void setInvoice() {
		InvoiceMasterDTO invoice = new InvoiceMasterDTO();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		invoice.setInvoiceNumber("IN10002");
		invoice.setInvoiceDate(dtf.format(now));
		invoice.setCustNumber("C102");

		Configuration con = new Configuration().configure().addAnnotatedClass(InvoiceMasterDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(invoice);
		tx.commit();
	}

	public static void getInvoiceByInvoiceNumber() {
		InvoiceMasterDTO invoice = null;
		Configuration con = new Configuration().configure().addAnnotatedClass(InvoiceMasterDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		invoice = (InvoiceMasterDTO) session.get(InvoiceMasterDTO.class, "IN10003");
		tx.commit();
		sf.close();
		System.out.println(invoice);
	}

	@SuppressWarnings("unchecked")
	public static void getAllInvoices() {
		Configuration con = new Configuration().configure().addAnnotatedClass(InvoiceMasterDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Query query = session.createQuery("from InvoiceMasterDTO");
		List<InvoiceMasterDTO> invoices = query.list();

		for (InvoiceMasterDTO invoice : invoices) {
			System.out.println(invoice);
		}
		session.close();
		sf.close();

	}

//	public static void main(String[] args) {
//		System.out.println("Invoice Master DAO");
//		
//		setInvoice();
//
//		getInvoiceByInvoiceNumber();
//		getAllInvoices();
//	}

}
