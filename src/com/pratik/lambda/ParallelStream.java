package com.pratik.lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {

	public static void main(String[] args) {

		//Parallel Streams (Uses a Fork-Join pool in the background)
		Map<String, List<Integer>> map = IntStream.range(0, 256).parallel().boxed()
				.collect(Collectors.groupingBy(i -> Thread.currentThread().getName()));

		//New Utility For Each Loop for maps.
		map.forEach((k, v) -> {
			System.out.printf("%s -> {size = %s} %s \n", k, v.size(), v);
		});

	}

}
