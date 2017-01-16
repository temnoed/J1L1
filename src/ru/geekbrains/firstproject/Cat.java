package ru.geekbrains.firstproject;

public class Cat extends Animal {

	public Cat() {
		super.maxRun = 200;
		super.maxJump = 2;
	}

	public boolean swim(float dist) { // кот не может плавать, возвращаем false
		return false;
	}

}