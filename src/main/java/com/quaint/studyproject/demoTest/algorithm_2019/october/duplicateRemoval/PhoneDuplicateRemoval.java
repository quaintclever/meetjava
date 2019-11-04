package com.quaint.studyproject.demoTest.algorithm_2019.october.duplicateRemoval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *  给文件中的手机号去重
 * @author qi cong
 *
 */
public class PhoneDuplicateRemoval {

	public static void main(String[] args) throws IOException {
		
		File file = new File("src/main/java/com/quaint/studyproject/demoTest/algorithm_2019/october/phone1.txt");
		File file2 = new File("src/main/java/com/quaint/studyproject/demoTest/algorithm_2019/october/phone2.txt");
//		File file2 = new File(Thread.currentThread().getContextClassLoader().getResource("phone2.txt").getFile());
		
		Set<String> set = new HashSet();
		String readLine;
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		while(!Objects.isNull(readLine = bufferedReader.readLine()))
			set.add(readLine);

		bufferedReader = new BufferedReader(new FileReader(file2));
		while(!Objects.isNull(readLine = bufferedReader.readLine()))
			set.add(readLine);

		set.forEach(System.out::println);
		
	}
	
}
