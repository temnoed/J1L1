// Я решил не делать класс Animal абстрактным и прописал все действия зверей в нём.
// Ошибки - ругается на слово @Override при переопределении метода swim в классе Cat. Почему не понятно.
// Аргументом в конструкторе определяем предел данного существа по бегу
// Почему не работает перегрузка конструктора в классе Animal? а в Dog работает.
// Как возможно определять из класса Dog поля класса Animal имеющие тип private?

package ru.geekbrains.firstproject;

public class Lesson6 {

	public static void main(String[] args) {

		Dog dog1 = new Dog(400f);
		Dog dog2 = new Dog(600f);
		Cat cat1 = new Cat();

		System.out.println("Dog1 run 400m: " + dog1.run(400));
		System.out.println("Dog1 run 401m: " + dog1.run(401));
		System.out.println("Dog1 swim 11m: " + dog1.swim(11));
		System.out.println("Dog2 run 600m: " + dog2.run(600));
		System.out.println("Dog2 run 601m: " + dog2.run(601));
		System.out.println("Dog2 swim 6m: " + dog2.swim(6));


		System.out.println("Cat run 200m: " + cat1.run(200));
		System.out.println("Cat run 201m: " + cat1.run(201));
		System.out.println("Cat swim: " + cat1.swim(1));
	}

}


