package lab4;

/*
 * @author Lzz
 * 随机生成任意大小的矩阵，矩阵单元用double存储
 */

import java.util.Random;

public class MatrixGenerator {

	//矩阵生成
	public double[][] MatrixGenerat(int N, int M) {
		//建立随机数
		Random r = new Random();
		
		//建立n行m列矩阵
		double[][] Matrix = new double[N][M];
		
		//将矩阵的每个数赋随机值，完成初始化
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < M; j++) {
				Matrix[i][j] = r.nextInt(10);
			}
		}	
		
		return Matrix;
	}
	
	//打印矩阵
	public void printMatrix(double[][] Matrix) {
		
		System.out.println("打印矩阵：");
		
		for (int i = 0; i < Matrix.length; i ++) {
			for (int j = 0; j < Matrix[i].length; j++) {
				System.out.print(Matrix[i][j] + " ");
			}
			System.out.println();
		}	
	}

}
