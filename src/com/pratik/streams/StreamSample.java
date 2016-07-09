package com.pratik.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Sample program to illustrate the usage of Streams, filters, map and reduce
 * and other things related to streams. The code is from this awesome talk on
 * Streams (https://www.youtube.com/watch?v=rVfRDLIw_Zw)
 */
public class StreamSample {

	public static List<Person> createPeople() {
		return Arrays.asList(new Person("Paul", Gender.Male, 27), new Person("Paula", Gender.Female, 33),
				new Person("Jane", Gender.Female, 32), new Person("Joyce", Gender.Female, 25),
				new Person("Sara", Gender.Female, 27), new Person("Sara", Gender.Female, 35),
				new Person("Rick", Gender.Male, 37), new Person("Frank", Gender.Male, 35));
	}

	public static void main(String[] args) {
		
		List<Person> people = createPeople();
		
		//1. Get in uppercase the names of all the females whose age > 25
		
		//One way to filter the stream, It filters and prints too.
		people.stream().filter(p -> (p.getGender() == Gender.Female)).filter(p -> p.getAge() > 25)
				.map(p -> p.getName().toUpperCase()).forEach(System.out::println);	
		
		//OR you can get it into an object and use ForEach to print out the list.
		List<String> womenOlderThan25 = people.stream().filter(p -> (p.getGender() == Gender.Female)).filter(p -> p.getAge() > 25)
		.map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		womenOlderThan25.forEach(System.out::println);
		
		//2. Print all the names of Males from the list of Persons.
		people.stream().filter(p -> p.getGender() == Gender.Male).map(p -> p.getName().toUpperCase()).forEach(System.out::println);		

		//3. Print a total of sums of all ages of all persons. 
		// sum() is a specialized reduve (aggregation operation)
		System.out.println(people.stream().map(Person::getAge).reduce(0,Integer::sum));
		//OR  (notice the mapToInt)
		System.out.println(people.stream().mapToInt(Person::getAge).sum());
		
		//4. Capture a list of people whose age > 30 in another list.
		//collect() is a specialized reduce.
		List<String> names = people.stream().filter(p -> p.getAge() > 30).map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		//5. Map idiom using collect()
		// p->p = identity relation.
		Map<String, Person> map = people.stream()
				.collect(Collectors.toMap(p -> p.getName() + " : " + p.getAge(), p -> p));
		map.forEach((k, v) -> {
			System.out.printf("%s : %s \n", k, v);
		});
		
       //6. Sorting using a Comparator
			
	}

}
