package day9;

public class Quest46 {
	public static void main(String[] args) {
		HDFCBank bank = new HDFCBank("asd", "XXX45", "salary", 1500);
		bank.makeDeposit(1000);
		bank.ShowDetails();
	}
}

class HDFCBank {
	String name;
	String accNo;
	String accType;
	float balance;

	public HDFCBank(String name, String accNo, String accType, float balance) {
		super();
		this.name = name;
		this.accNo = accNo;
		this.accType = accType;
		this.balance = balance;
	}

	public void makeDeposit(float amount) {
		balance += amount;
	}

	public void ShowDetails() {
		System.out.println("Name" + name);
		System.out.println("accNo" + accNo);
		System.out.println("accType" + accType);
		System.out.println("balance" + balance);

	}

}
