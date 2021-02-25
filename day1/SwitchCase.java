package day1;

public class SwitchCase {
	public static void main(String[] args) {
		int month = 2;
		switch (month) {
		case 1:
			System.out.println("31 days");
			break;
		case 2:
			int year = 2021;
			if ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0)) {
				System.out.println("29 days");
			} else {
				System.out.println("28 days");
			}
			break;
		case 3:
			System.out.println("31 days1");
			break;
		case 4:
			System.out.println("30 days");
			break;
		case 5:
			System.out.println("31 days");
			break;
		case 6:
			System.out.println("30 days");
			break;
		case 7:
			System.out.println("31 days");
			break;
		case 8:
			System.out.println("31 days");
			break;
		case 9:
			System.out.println("30 days");
			break;
		case 10:
			System.out.println("31 days");
			break;
		case 11:
			System.out.println("30 days");
			break;
		case 12:
			System.out.println("31 days");
			break;
		default:
			System.out.println("Enter a valid month");
		}
	}
}
