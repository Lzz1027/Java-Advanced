package homework4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Homework4 {
	private static void copyFileUsingFileStreams(File source, File dest) throws IOException {   
		InputStream input = null;   
		OutputStream output = null;   
		try { 
			input = new FileInputStream(source); 
			output = new FileOutputStream(dest);     
			byte[] buf = new byte[1024];     
			int bytesRead;     
			while ((bytesRead = input.read(buf)) > 0) { 
				output.write(buf, 0, bytesRead); 
		    } 
		} finally { 
			input.close(); 
		    output.close(); 
		} 
	} 
	
	public static void main(String[] args) throws IOException {
		System.out.print("Please enter sorce path: ");
		String scan1 = new Scanner(System.in).nextLine();
		String sorcePath = scan1;
		//"D:\\DeskTop\\123.txt"
		System.out.print("Please enter target path: ");
		String scan2 = new Scanner(System.in).nextLine();
		String targetPath = scan2;
		//"D:\\DeskTop\\456.txt"
		
		File F1 = new File(sorcePath);
		File F2 = new File(targetPath);
		copyFileUsingFileStreams(F1, F2);
		System.out.print("Copy Succeed!");
	}
}
