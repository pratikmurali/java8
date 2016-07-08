package com.pratik.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStream {
	
	private static List<String> words = new ArrayList<>();

	public static void main(String[] args) {
		
		words.add("conscience");
		words.add("condescending");
		words.add("construct");
		words.add("community");
		words.add("construct");
		words.add("congruent");
		
		//Filter a stream using a Lambda expression predicate and aggregate operation.
		long count = words.stream().filter(s -> s.startsWith("cons")).count();
		
		System.out.println("Number of words starting with the prefix -cons- " + count);		
		
		//Concatenate Strings
		String concatenate = words.stream().filter(s -> s.startsWith("cons")).collect(Collectors.joining(" "));

		System.out.println("Concatenated with a space: " + concatenate);		

	}

}
