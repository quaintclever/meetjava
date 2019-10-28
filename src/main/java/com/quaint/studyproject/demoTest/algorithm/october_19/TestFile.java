package com.quaint.studyproject.demoTest.algorithm.october_19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *  给文件中的手机号去重
 * @author qi cong
 *
 */
public class TestFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("src/main/java/com/quaint/studyproject/demoTest/algorithm/october_19/phone1.txt");
		File file2 = new File("src/main/java/com/quaint/studyproject/demoTest/algorithm/october_19/phone2.txt");
//		File file2 = new File(Thread.currentThread().getContextClassLoader().getResource("phone2.txt").getFile());
		
		Map<String,String> map = new HashMap();
		String readLine;
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		while(!Objects.isNull(readLine = bufferedReader.readLine())) {
			if(!map.containsKey(readLine)) {
				map.put(readLine,readLine);
			}
		}
		bufferedReader = new BufferedReader(new FileReader(file2));
		while(!Objects.isNull(readLine = bufferedReader.readLine())) {
			if(!map.containsKey(readLine)) {
				map.put(readLine,readLine);
			}
		}
		
		map.keySet().forEach(str ->{
			System.out.println(str);
		});
		
	}
	
}
