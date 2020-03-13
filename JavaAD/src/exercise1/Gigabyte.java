package exercise1;

public class Gigabyte implements Motherboard{
	private String Name;
	private int speed;
	private double price;
	
	public Gigabyte() {
		setName("");
		setSpeed(0);
		setPrice(0);
	}
	
	public Gigabyte(String name, int speed, double value) {
		setName(name);
		setSpeed(speed);
		setPrice(value);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String brandOfMotherboard() {
		// TODO Auto-generated method stub
		return "Gigabyte";
	}	
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Motherboard Work.");
	}	

}
