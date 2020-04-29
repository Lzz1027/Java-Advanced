package homework3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class homework3 {

	//题目
	//Please count the number of each string in the input args 
	//and output them with the format “<string>=<the number of string>”
	
	public static void countWords(String scan) {
		//将字符串转换为数组
				String[] strToArray = scan.split("[' '|,|.]");
				//新建一个HashMap对象；
				Map<String, Integer> strMap = new HashMap<String, Integer>();
				
				//用for循环，将String数组的键值存到Map中
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
		//获取键盘上输入的字符串；
		String scan = new Scanner(System.in).nextLine();
		
		countWords(scan);
}


}
