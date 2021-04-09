package day_08_04_21.one2manypack;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BackUpEmployee implements Serializable {
	private String name;
	private float salary;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}