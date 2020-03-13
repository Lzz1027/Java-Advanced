package exercise1;

public class Intel implements CPU{
	private String Name;
	private int coreNum;
	private double price;
	
	public Intel() {
		setName("");
		setCoreNum(0);
		setPrice(0);
	}
	
	public Intel(String name, int coreNumber, double value) {
		setName(name);
		setCoreNum(coreNumber);
		setPrice(value);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getCoreNum() {
		return coreNum;
	}

	public void setCoreNum(int coreNum) {
		this.coreNum = coreNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String brandOfCPU() {
		// TODO Auto-generated method stub
		return "Intel";
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("CPU Work.");
	}	

}
