package homework3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class homework3 {

	//��Ŀ
	//Please count the number of each string in the input args 
	//and output them with the format ��<string>=<the number of string>��
	
	public static void countWords(String scan) {
		//���ַ���ת��Ϊ����
				String[] strToArray = scan.split("[' '|,|.]");
				//�½�һ��HashMap����
				Map<String, Integer> strMap = new HashMap<String, Integer>();
				
				//��forѭ������String����ļ�ֵ�浽Map��
				for(int i = 0; i < strToArray.length; i++){
					if(" " != strToArray[i]) {
						if(strMap.get(strToArray[i]) != null) {
							strMap.put(strToArray[i], strMap.get(strToArray[i]) + 1);
						}else {
							strMap.put(strToArray[i], 1);
						}
					}else {
						strMap.put(strToArray[i], 1);
					}
				}
				
				Set<Entry<String,Integer>> it = strMap.entrySet();
				
				Iterator<Entry<String,Integer>> iter = it.iterator();
				
				while(iter.hasNext()){
					Entry<String, Integer> end = (Entry<String, Integer>) iter.next();
					System.out.println(end.getKey() + " = " + end.getValue());
				}
	}
	public static void main(String[] args){
		//��ȡ������������ַ�����
		String scan = new Scanner(System.in).nextLine();
		
		countWords(scan);
}


}
