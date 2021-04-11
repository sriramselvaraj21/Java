package jpashoppingapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import training.model.PurchaseInfoDTO;

public class PurchaseInfoDAO {

	public static void setPurchaseInfo() {
		PurchaseInfoDTO purchaseInfo = new PurchaseInfoDTO();
		purchaseInfo.setId(0);
		purchaseInfo.setInvoiceNumber("IN10002");
		purchaseInfo.setItemNumber("IT102");
		purchaseInfo.setItemUnits("3");

		Configuration con = new Configuration().configure().addAnnotatedClass(PurchaseInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(purchaseInfo);
		tx.commit();
	}

	public static void getPurchaseInfoByInvoiceNumberAndItemNumber() {

		// PurchaseInfoDTO purchaseInfo = null;
		Configuration con = new Configuration().configure().addAnnotatedClass(PurchaseInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();
		Query query = session.createQuery(
				"from PurchaseInfoDTO p where p.invoiceNumber = :invoiceNumber AND p.itemNumber = :itemNumber");
		query.setParameter("invoiceNumber", "IN10001");
		query.setParameter("itemNumber", "IT101");
		System.out.println(query.list());

		sf.close();
	}

	@SuppressWarnings("unchecked")
	public static void getAllPurchases() {
		Configuration con = new Configuration().configure().addAnnotatedClass(PurchaseInfoDTO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();

		Query query = session.createQuery("from PurchaseInfoDTO");
		List<PurchaseInfoDTO> purchaseInfo = query.list();

		for (PurchaseInfoDTO info : purchaseInfo) {
			System.out.println(info);
		}
		session.close();
		sf.close();

	}

//	public static void main(String[] args) {
//		System.out.println("Purchase Info DAO");
//
//		//setPurchaseInfo();
//
//		// getPurchaseInfoByInvoiceNumberAndItemNumber();
//		//getAllPurchases();
//	}
}
