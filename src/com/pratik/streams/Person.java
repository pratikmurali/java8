package com.pratik.streams;

public class Person {

	private final String name;
	private final Gender gender;
	private final int age;

	/**
	 * @param name
	 * @param gender
	 * @param age
	 */
	public Person(String name, Gender gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Person [name=%s, gender=%s, age=%s]", name, gender, age);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
