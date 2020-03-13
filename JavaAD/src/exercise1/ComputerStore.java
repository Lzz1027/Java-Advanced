package exercise1;

public class ComputerStore {
	
	public static void DescribeComputer(Computer X) {
		System.out.println("The name of this computer is " + X.getComputerName() + ".");
		System.out.println("It has " + X.getCpu().brandOfCPU() + " " + X.getCpu().getName() + " CPU which has " +X.getCpu().getCoreNum() + " cores.");
		System.out.println("It has " + X.getMemory().getVolume() + "GB " + X.getMemory().brandOfMemory() + " memory.");
		System.out.println("It has " + X.getHardDrive().getVolume() + "GB "+ X.getHardDrive().brandOfHardDrive() + " harddrive.");
		System.out.println("It has " + X.getMotherboard().brandOfMotherboard() + " motherboard.");
	}
	
	public static void ShowPriceOfComputer(Computer X) {
		System.out.println("The price of " + X.getComputerName() + " is " + X.getComputerValue() + ".");
	}
	
	public static void main(String[] args) {
	
		Computer A = new Computer("A");
		Computer B = new Computer("B");
		Computer C = new Computer("C");
		
		//装配A、B、C三台计算机
		A.setCPU("AMD", "Threadripper 3990X", 64, 29999);
		A.setHardDrive("WestDigitals", "Blue", 4000, 4699);
		A.setMemory("Samsung", "Samsung", 128, 11192);
		A.setMotherboard("Asus", "ROG STRIX", 16, 4799);
		
		B.setCPU("Intel", "i9-9900K", 8, 3999);
		B.setHardDrive("Seagate", "BarraCuda", 4000, 599);
		B.setMemory("Kingston", "Predator", 32, 2569);
		B.setMotherboard("Asus", "PRIME", 16, 1699);
		
		C.setCPU("AMD", "R9 3900X", 32, 3699);
		C.setHardDrive("Seagate", "BarraCuda", 4000, 599);
		C.setMemory("Kingston", "Predator", 32, 2569);
		C.setMotherboard("Gigabyte", "GAMING", 16, 1299);
		
		//描述计算机，展示价格
		DescribeComputer(A);
		ShowPriceOfComputer(A);
		DescribeComputer(B);
		ShowPriceOfComputer(B);
		DescribeComputer(C);
		ShowPriceOfComputer(C);
		
		//检测组件工作
		A.getCpu().work();
		A.getHardDrive().work();
		A.getMemory().work();
		A.getMotherboard().work();
		
	}
}
