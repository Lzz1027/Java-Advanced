package lab4;

/*
 * @author Lzz
 * ������������С�ľ��󣬾���Ԫ��double�洢
 */

import java.util.Random;

public class MatrixGenerator {

	//��������
	public double[][] MatrixGenerat(int N, int M) {
		//���������
		Random r = new Random();
		
		//����n��m�о���
		double[][] Matrix = new double[N][M];
		
		//�������ÿ���������ֵ����ɳ�ʼ��
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < M; j++) {
				Matrix[i][j] = r.nextInt(10);
			}
		}	
		
		return Matrix;
	}
	
	//��ӡ����
	public void printMatrix(double[][] Matrix) {
		
		System.out.println("��ӡ����");
		
		for (int i = 0; i < Matrix.length; i ++) {
			for (int j = 0; j < Matrix[i].length; j++) {
				System.out.print(Matrix[i][j] + " ");
			}
			System.out.println();
		}	
	}

}
