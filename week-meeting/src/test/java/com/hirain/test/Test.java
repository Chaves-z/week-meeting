package com.hirain.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	@org.junit.Test
	public void test() {

		List<String> arrayList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			arrayList.add(i + "");
		}
		String[] array = arrayList.toArray(new String[0]);
		for (String string : array) {
			System.out.println("string==" + string);
		}
		List<String> asList = Arrays.asList(array);
		for (String string : asList) {
			System.out.println("list==" + string);
		}
	}
}
