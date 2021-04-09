package day_08_04_21.manytomany;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ReadClient {
	public static void main(String[] args) {
		Session ss = HibernateUtility.getSession();

		Student s = (Student) ss.get(Student.class, Integer.valueOf(1));

		System.out.println(s.getName());
		System.out.println(s.getMarks());
		System.out.println(s.getSid());
		System.out.println(s.getTrainings());

		HibernateUtility.closeSession(null);
	}
}