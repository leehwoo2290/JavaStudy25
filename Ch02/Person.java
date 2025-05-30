package Ch02;

import java.util.Scanner;

public class Person {

	public void print() {
		
		System.out.println("Person");
	}
	
	public static void main(String[] args) {
		
		Person teacher = new Teacher();
		
		Person[] persons = new Person[10];
		
		//기존 
		
		
		//입력에 따라 
		persons[0] = new Person();
		persons[1] = new student();
		persons[2] = new Teacher();
		
		for(int i = 0; i < persons.length; i++) {
			
			persons[i].print();
		}
	}
}

class student extends Person {

	public void print() {
		
		//super.print();
		System.out.println("student");
	}
}

class Teacher extends Person {

	public void print() {
		
		//super.print();
		System.out.println("Teacher");
	}
}