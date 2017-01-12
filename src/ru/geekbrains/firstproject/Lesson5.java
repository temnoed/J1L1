package ru.geekbrains.firstproject;

class Employee {
	private String fullName;
	private String position;
	private String email;
	private String phone;
	private int salary;
	private int age;

	public Employee() {
		fullName = "Jhone";
		position = "burglar";
		email = "happiness@ru";
		phone = "2128506";
		salary = 5;
		age = 18;
	}

	public Employee(
			String _fullName,
			String _position,
			String _email,
			String _phone,
			int _salary,
			int _age
	) {
		this.fullName = _fullName;
		this.position = _position;
		this.email = _email;
		this.phone = _phone;
		this.salary = _salary;
		this.age = _age;
	}

	public void info() {
		System.out.println(this.fullName + " " + this.position + " " + this.email + " " + this.phone + " " + this.salary + " " + this.age);
	}

	public int getAge() {
		return age;
	}
}

public class Lesson5 {

	public static void main(String[] args) {

		Employee[] empArray = new Employee[5];
		empArray[0] = new Employee("Vasya", "povar", "email1", "1239", 1, 200);
		empArray[1] = new Employee("Goga", "konuh", "email2", "1238", 1, 20);
		empArray[2] = new Employee("Genya", "plotnik", "email3", "1237", 1, 2);
		empArray[3] = new Employee("Olya", "spec", "email4", "1236", 1, 220);
		empArray[4] = new Employee("Dida", "ugonssik", "email5", "1235", 1, 51);

		for (Employee i : empArray) {
			if (i.getAge() > 40) i.info();
		}
	}
}
