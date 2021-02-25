package day7;

public class BuilderDemo {

	public static void main(String[] args) {
		Computer myComputer = new Computer.ComputerBuilder("hddenabled", "16gbram","bluetooth").build();
		System.out.println(myComputer);

		Computer myComputer3 = new Computer.ComputerBuilder("hdddddd", "232RAM","bluetooth").setBlueTooth("bluetooth enabled")
				.build();

		System.out.println(myComputer3);

	}
}

class Computer {
	private String hdd;
	private String ram;
	private String graphicsCard;
	private String blueTooth;

	@Override
	public String toString() {
		return "Computer [hdd=" + hdd + ", ram=" + ram + ", graphicsCard=" + graphicsCard + ", blueTooth=" + blueTooth
				+ "]";
	}

	public Computer(ComputerBuilder builder) {
		this.hdd = builder.getHdd();
		this.ram = builder.getRam();
		this.graphicsCard = builder.getGraphicsCard();
		this.blueTooth = builder.getBlueTooth();
	}

	public static class ComputerBuilder {
		private String hdd;
		private String ram;
		private String graphicsCard;
		private String blueTooth;

		public ComputerBuilder(String hdd, String ram, String blueTooth) {
			this.hdd = hdd;
			this.ram = ram;
			this.blueTooth = blueTooth;
		}

		public final String getHdd() {
			return hdd;
		}

		public final void setHdd(String hdd) {
			this.hdd = hdd;
		}

		public final String getRam() {
			return ram;
		}

		public final void setRam(String ram) {
			this.ram = ram;
		}

		public final String getGraphicsCard() {
			return graphicsCard;
		}

		public final ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}

		public final String getBlueTooth() {
			return blueTooth;
		}

		public final ComputerBuilder setBlueTooth(String blueTooth) {
			this.blueTooth = blueTooth;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}
}