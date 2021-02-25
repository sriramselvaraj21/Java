package day_8;

public class Ques2 {
	public static void main(String[] args) {
		ComplexNumber x1 = new ComplexNumber(1, 2);
		ComplexNumber x2 = new ComplexNumber(1, 2);
		add(x1, x2);
		System.out.println("real=" + x1.real + "image=" + x1.img);
	}

	public static void add(ComplexNumber x1, ComplexNumber x2) {
		x1.real = x1.real + x2.real;
		x2.img = x2.img + x2.img;

	}
}

class ComplexNumber {
	double real, img;

	public ComplexNumber(double real, double img) {
		this.real = real;
		this.img = img;
	}
}