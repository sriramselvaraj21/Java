package day_8;

import java.util.Date;

public class Ques3 {
	public static void main(String[] args) {
		Worker worker = new Worker();
		SalesPerson salesPerson = new SalesPerson();
		SalesManager salesManager = new SalesManager();
		TerritoryManager territoryManager = new TerritoryManager();
		System.out.println("worker" + worker.date);
		System.out.println("SalesPerson" + salesPerson.date);
		System.out.println("TerritoryManager" + territoryManager.date);
		System.out.println("salesManager" + salesManager.date);
	}
}

abstract class Employee {

}

class Worker extends Employee {
	Date date;

	public Worker() {
		// TODO Auto-generated constructor stub
		this.date = new Date();
	}
}

class SalesPerson extends Employee {
	Date date;

	public SalesPerson() {
		this.date = new Date();
	}
}

class SalesManager extends SalesPerson {
	Date date;
	public SalesManager() {
		this.date = new Date();
	}
}

class TerritoryManager extends SalesManager {
	Date date;

	public TerritoryManager() {
		this.date = new Date();
	}
}