package lab4;

public class Main {
	
	//����ʵ�־���˷�
	public static double[][] MatrixMutiply1(double[][] A, double[][] B) {
		
		int An = A.length;
		int Am = A[0].length;
		int Bn = B.length;
		int Bm = B[0].length;
		
		//�����ж��ܷ����
		if (Am != Bn) {
			System.out.println("�޷����!");
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
		System.out.println("���м��㿪ʼʱ�䣺 " + startTime + "����");
		System.out.println("���м������ʱ�䣺 " + endTime + "����");
		System.out.println("���м�������ʱ�䣺 " + (endTime - startTime) + "����");
		return C;	
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		MatrixGenerator m = new MatrixGenerator();
		
		double[][] MatrixA = m.MatrixGenerat(2000,2000);
		double[][] MatrixB = m.MatrixGenerat(2000,2000);
		
		//���м��㣺
		//m.printMatrix(MatrixA);
		//m.printMatrix(MatrixB);
		//m.printMatrix(MatrixMutiply1(MatrixA,MatrixB));
		MatrixMutiply1(MatrixA,MatrixB);		
		
		//���м��㣺
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
		System.out.println("���м��㿪ʼʱ�䣺 " + startTime + "����");
		System.out.println("���м������ʱ�䣺 " + endTime + "����");
		System.out.println("���м�������ʱ�䣺 " + (endTime - startTime) + "����");
	}
}

//����ʵ�־���˷�
class Runner0 implements Runnable{
	private double[][] A, B, C;
	private int An;
	private int Am;
	private int Bn;
	private int Bm;
	

    //start�ǿ�ʼλ�ã��߳�0��0�п�ʼ���߳�1��1�п�ʼ�������м���
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
		
		//�����ж��ܷ����
		if (Am != Bn) {
			System.out.println("�޷����!");

		} else {
			//��ͬstart�У����м���
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
