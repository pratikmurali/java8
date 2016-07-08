package com.pratik.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Demo class to illustrate old school way of using mutable variables and external iteration
 * and how that has been enhanced in Java 8 using Lambdas and Streams. The example is from this
 * awesome lecture https://www.youtube.com/watch?v=Gsfmfeb2XW8
 *
 */
public class OldAndNew {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// old school :External Iterator
		for (int i : list) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

		// new school (using Consumer) : Internal Iterator.
		list.forEach(new Consumer<Integer>() {
			public void accept(Integer value) {
				System.out.println(value);
			}
		});

		// new school best way: Lambda Expression
		list.forEach(value -> System.out.println(value));

		// new school another way: Method Reference (::)
		list.forEach(System.out::println);

		// new school map-reduce: Using Stream filters
		list.stream().filter(i -> (i % 2 == 0)).forEach(System.out::println);
		;

		// new school map-reduce: Using Parallel Stream filters
		// Note: You cannot guarantee ordering when you use parallel streams.
		list.stream().filter(i -> (i % 2 == 0)).forEach(System.out::println);

        //find the double of the first even number that is greater than 3.
		//Notice the filter chain and the fact that this returns an optional.
		System.out.println(list.stream().filter(e -> e > 3).filter(e -> e % 2 == 0).map(e -> (e * 2)).findFirst());
		
	}

}
