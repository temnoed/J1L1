package ru.geekbrains.firstproject;

public class Dog extends Animal {

	public Dog() {
		super.maxRun = 500f;
		super.maxJump = 0.5f;
		super.maxSwim = 10f;
	}

	public Dog(float _maxRun) {
		this();
		super.maxRun = _maxRun;

	}

}