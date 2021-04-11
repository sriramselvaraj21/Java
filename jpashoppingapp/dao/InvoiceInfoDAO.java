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

import training.model.InvoiceInfoDTO;

public class InvoiceInfoDAO {
	public static void setInvoiceInfo() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		InvoiceInfoDTO invoice = new InvoiceInfoDTO();

		invoice.setInvoiceNumber("IN10002");
		invoice.setInvoicedate(dtf.format(now));
		invoice.setCustName("RAMU");
		invoice.setTotalAmont("5000");

		Configuration con = new Configuration().configure().addAnnotatedClass(InvoiceInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(invoice);
		tx.commit();
	}

	public static void getInvoiceByInvoiceNumber() {

		InvoiceInfoDTO invoice = null;
		Configuration con = new Configuration().configure().addAnnotatedClass(InvoiceInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();
		invoice = (InvoiceInfoDTO) session.get(InvoiceInfoDTO.class, "IN10002");
		sf.close();
		System.out.println(invoice);
	}

	@SuppressWarnings("unchecked")
	public static void getAllInvoices() {
		Configuration con = new Configuration().configure().addAnnotatedClass(InvoiceInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Query query = session.createQuery("from InvoiceInfoDTO");
		List<InvoiceInfoDTO> invoices = query.list();

		for (InvoiceInfoDTO invoice : invoices) {
			System.out.println(invoice);
		}
		session.close();
		sf.close();

	}

//	public static void main(String[] args) {
//		setInvoiceInfo();
//		
//		getInvoiceByInvoiceNumber();
//		
//		getAllInvoices();
//	}
}
