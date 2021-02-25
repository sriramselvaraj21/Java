package day_8;

public class Ques7 {
	public static void main(String[] args) {
		SetState ss = new SetState();
		ss.changeState(21);
		System.out.println(ss.val);
	}
}

class SetState {
	int val;

	public SetState() {
		// TODO Auto-generated constructor stub
		this.val = val;
	}

	void changeState(int val) {
		this.val = val;
	}

}