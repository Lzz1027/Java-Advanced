package lab4;

public class Main {
	
	//串行实现矩阵乘法
	public static double[][] MatrixMutiply1(double[][] A, double[][] B) {
		
		int An = A.length;
		int Am = A[0].length;
		int Bn = B.length;
		int Bm = B[0].length;
		
		//首先判断能否相乘
		if (Am != Bn) {
			System.out.println("无法相乘!");
			return null;
		}
		
		double[][] C = new double[An][Bm];
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < An; i++) {
			for (int j = 0; j < Bm; j++) {
				for (int k = 0; k < Am; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("串行计算开始时间： " + startTime + "毫秒");
		System.out.println("串行计算结束时间： " + endTime + "毫秒");
		System.out.println("串行计算运行时间： " + (endTime - startTime) + "毫秒");
		return C;	
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		MatrixGenerator m = new MatrixGenerator();
		
		double[][] MatrixA = m.MatrixGenerat(2000,2000);
		double[][] MatrixB = m.MatrixGenerat(2000,2000);
		
		//串行计算：
		//m.printMatrix(MatrixA);
		//m.printMatrix(MatrixB);
		//m.printMatrix(MatrixMutiply1(MatrixA,MatrixB));
		MatrixMutiply1(MatrixA,MatrixB);		
		
		//并行计算：
		Runner0 r0 = new Runner0(MatrixA, MatrixB, 0);
		Runner0 r1 = new Runner0(MatrixA, MatrixB, 1);
		Thread t0 = new Thread(r0);
		Thread t1 = new Thread(r1);
		long startTime = System.currentTimeMillis();
		t0.start();
        t1.start();
        t0.join();
        t1.join();
        long endTime = System.currentTimeMillis();
		System.out.println("并行计算开始时间： " + startTime + "毫秒");
		System.out.println("并行计算结束时间： " + endTime + "毫秒");
		System.out.println("并行计算运行时间： " + (endTime - startTime) + "毫秒");
	}
}

//并行实现矩阵乘法
class Runner0 implements Runnable{
	private double[][] A, B, C;
	private int An;
	private int Am;
	private int Bn;
	private int Bm;
	

    //start是开始位置，线程0从0行开始，线程1从1行开始，都隔行计算
    private int start;
    
    Runner0(double[][] a, double[][] b, int start){
        this.A = a;
        this.B = b;
        this.start = start;
        
    	An = A.length;
    	Am = A[0].length;
    	Bn = B.length;
    	Bm = B[0].length;
        C = new double[An][Bm];

    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//首先判断能否相乘
		if (Am != Bn) {
			System.out.println("无法相乘!");

		} else {
			//不同start行，隔行计算
            for (int i = start; i < An; i += 2) {
                for (int j = 0; j < Bm; j++) {
                    for (int k = 0; k < Am; k++) {
                        C[i][j] = A[i][k] * B[k][j];
                    }
                }
            }
        }
	}
	
}
