package lab1;

public class Computer {
	private String computerName;
	private double computerValue;
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;
	private Motherboard motherboard;
	
	Computer(){
		setComputerName("Computer");
		setComputerValue(0);
	}
	
	Computer(String computerName){
		setComputerName(computerName);
		setComputerValue(0);
	}
	
	public void setCPU(String brand, String name, int coreNumber, double value) {
		if (brand == "AMD") {
			setCpu(new AMD(name, coreNumber, value));
		}else {
			setCpu(new Intel(name, coreNumber, value));
		}
		setComputerValue(getComputerValue() + value);
	}
	
	public void setMemory(String brand, String name, int volume, double value) {
		if (brand == "AMD") {
			memory = new Samsung(name, volume, value);
		}else {
			memory = new Kingston(name, volume, value);
		}
		setComputerValue(getComputerValue() + value);
	}
	
	public void setHardDrive(String brand, String name, int volume, double value) {
		if (brand == "AMD") {
			hardDrive = new Seagate(name, volume, value);
		}else {
			hardDrive = new WestDigitals(name, volume, value);
		}
		setComputerValue(getComputerValue() + value);
	}
	
	public void setMotherboard(String brand, String name, int speed, double value) {
		if (brand == "AMD") {
			motherboard = new Gigabyte(name, speed, value);
		}else {
			motherboard = new Asus(name, speed, value);
		}
		setComputerValue(getComputerValue() + value);
	}
	

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public double getComputerValue() {
		return computerValue;
	}

	public void setComputerValue(double computerValue) {
		this.computerValue = computerValue;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public HardDrive getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(HardDrive hardDrive) {
		this.hardDrive = hardDrive;
	}

	public Motherboard getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}
}
