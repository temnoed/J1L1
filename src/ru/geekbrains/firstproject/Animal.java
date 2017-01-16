package ru.geekbrains.firstproject;

public  class Animal {
	protected float maxRun;
	protected float maxSwim;
	protected float maxJump;

	public Animal() {
	}

	public boolean run(float dist) {
		if (dist > 0 & dist <= maxRun)
			return true;
		else return false;
	}

	public boolean swim(float dist) {
		if (dist > 0 & dist <= maxSwim)
			return true;
		else return false;
	}

	public boolean jump(float dist) {
		if (dist > 0 & dist <= maxJump)
			return true;
		else return false;
	}
}
