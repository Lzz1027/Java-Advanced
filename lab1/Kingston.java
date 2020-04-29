package lab1;

public class Kingston implements Memory{
	private String Name;
	private int volume;
	private double price;
	
	public Kingston() {
		setName("");
		setVolume(0);
		setPrice(0);
	}
	
	public Kingston(String name, int volume, double value) {
		setName(name);
		setVolume(volume);
		setPrice(value);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String brandOfMemory() {
		// TODO Auto-generated method stub
		return "Kingston";
	}	
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Memory Work.");
	}	

}
