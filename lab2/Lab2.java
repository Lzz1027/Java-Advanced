package lab2;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.io.FileOutputStream;  
import java.io.PrintStream;


public class Lab2 {
	
	public static String readFromTxt(String filename) throws IOException {
		
		Reader reader = null;
		
		try {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[1024];
			reader = new FileReader(filename);
			int readed = reader.read(chars);
			
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			
			return buf.toString();
		} catch (FileNotFoundException e){
            System.out.println("文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	assert reader != null;
			reader.close();
		}
		return null;
	}
	
	
	
	public static HashMap countWords(String str) {
		//将字符串转换为数组
		String[] strToArray = str.split("\\s+|\\n+|\\t+|\\r+");
		//新建一个HashMap对象；
		HashMap<String, Integer> strMap = new HashMap<String, Integer>();
			
		//用for循环，将String数组的键值存到Map中
		for(String strToArray1:strToArray){
			Integer t = strMap.put(strToArray1,1);
            if(t!=null) {
            	strMap.put(strToArray1,++t);
            }
		}
		return strMap;		
	}
	
    
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());
 
        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
    
    public static class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {
    	 
        @Override
        public int compare(Entry<String, Integer> me1, Entry<String, Integer> me2) {
            //按照从大到小的顺序排列，如果想正序 调换me1 me2的位置
            return me2.getValue().compareTo(me1.getValue());
        }
    }
	
	public static void main(String[] args) throws IOException {
		String txtPath = "D:\\DeskTop\\gatsby.txt";
		String resultPath = "D:\\DeskTop\\result.txt";
		String gatsby = readFromTxt(txtPath);
		assert gatsby != null;
		HashMap<String,Integer> map = countWords(gatsby);
		HashMap<String,Integer> sorted = (HashMap<String, Integer>) sortMapByValue(map);

		BufferedWriter bw = new BufferedWriter(new FileWriter(resultPath));

		for (Map.Entry<String, Integer> entry : sorted.entrySet()){
			String str = entry.getKey() + " " + entry.getValue();
			bw.write(str);
			bw.newLine();
		}		
		bw.close();
		
		System.out.println("Finished!");		
	}
}