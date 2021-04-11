package jpashoppingapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import training.model.CustomerInfoDTO;

public class CustomerInfoDAO {

	public static void setCustomerInfo() {
		CustomerInfoDTO customer = new CustomerInfoDTO();
		customer.setCustNumber("C103");
		customer.setCustName("SAM");
		customer.setCustContact("7898690");
		customer.setCustEmail("sam@gmail.com");
		customer.setCustAddress("BANGALORE");

		Configuration con = new Configuration().configure().addAnnotatedClass(CustomerInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
	}

	public static void getCustomerByCustomerNumber() {

		CustomerInfoDTO customer = null;
		Configuration con = new Configuration().configure().addAnnotatedClass(CustomerInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();
		customer = (CustomerInfoDTO) session.get(CustomerInfoDTO.class, "C101");
		sf.close();
		System.out.println(customer);
	}

	@SuppressWarnings("unchecked")
	public static void getAllCustomers() {
		Configuration con = new Configuration().configure().addAnnotatedClass(CustomerInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Query query = session.createQuery("from CustomerInfoDTO");
		List<CustomerInfoDTO> customers = query.list();

		for (CustomerInfoDTO customer : customers) {
			System.out.println(customer);
		}
		session.close();
		sf.close();

	}
//
//	public static void main(String[] args) {
//		System.out.println("Customer Info DAO");
//
//		setCustomerInfo();
//		
//		getCustomerByCustomerNumber();
//		getAllCustomers();
//	}
}
