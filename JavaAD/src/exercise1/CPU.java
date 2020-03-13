package exercise1;

public interface CPU {

	String brandOfCPU();
	void work();
	
	String getName();
	void setName(String name);
	
	int getCoreNum();
	void setCoreNum(int coreNum);
	
	double getPrice();
	void setPrice(double price);
}
