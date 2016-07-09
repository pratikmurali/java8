package com.pratik.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyImmutableCollection {
	
	private List<Integer> list = new ArrayList<>(); 
	
	public MyImmutableCollection() {
		this.list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
	}

	public List<Integer> getList() {
	
		//Returns a defensive copy of the list.
		return java.util.Collections.unmodifiableList(list);
	}
	
	public static void main(String[] args) {
		

	}

}
