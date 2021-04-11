package jpashoppingapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import training.model.ItemInfoDTO;

public class ItemInfoDAO {

	public static void setItemInfo() {
		ItemInfoDTO item = new ItemInfoDTO();
		item.setItemId("IT103");
		item.setItemName("FACEWASH");
		item.setPrice("250");
		item.setQuantity("100GMS");
		item.setBrand("MAMA EARTH");

		Configuration con = new Configuration().configure().addAnnotatedClass(ItemInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
	}

	public static void getItemByItemNumber() {

		ItemInfoDTO item = null;
		Configuration con = new Configuration().configure().addAnnotatedClass(ItemInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();
		item = (ItemInfoDTO) session.get(ItemInfoDTO.class, "IT103");
		sf.close();
		System.out.println(item);
	}

	@SuppressWarnings("unchecked")
	public static void getAllItems() {
		Configuration con = new Configuration().configure().addAnnotatedClass(ItemInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Query query = session.createQuery("from ItemInfoDTO");
		List<ItemInfoDTO> items = query.list();

		for (ItemInfoDTO item : items) {
			System.out.println(item);
		}
		session.close();
		sf.close();

	}

//	public static void main(String[] args) {
//		System.out.println("Item Info DAO");
//
//		setItemInfo();
//		
//		getItemByItemNumber();
//		getAllItems();
//	}
}
