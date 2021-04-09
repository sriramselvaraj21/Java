package day_08_04_21.one2manypack;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ReadClient {
	public static void main(String[] args) {
		Session ss = HibernateUtility.getSession();

		Employee ee = (Employee) ss.get(Employee.class, Integer.valueOf(1));

		System.out.println(ee);

		HibernateUtility.closeSession(null);
	}
}