package ru.geekbrains.firstproject;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

	public static char[][] map;
	public static final int SIZE = 10;
	public static final int DOTS_TO_WIN = 4;
	public static final char DOT_EMPTY ='•';
	public static final char DOT_X ='X';
	public static final char DOT_0 ='0';
	public static Random rand = new Random();
	public static Scanner sc = new Scanner(System.in);
	public static int xAI; // координаты для хода ИИ
	public static int yAI;

	public static void main(String[] args) {

		initMap();
		printMap();
		while (true) {
			humanTurn();
			printMap();
			if (checkWin(DOT_X)) {
				System.out.println("Победил человек");
				break;
			}
			if (isMapFull()) {
				System.out.println("Ничья");
				break;
			}
			aiTurn();
			printMap();
			if (checkWin(DOT_0)) {
				System.out.println("Победил Искуственный Интеллект");
				break;
			}
			if (isMapFull()) {
				System.out.println("Ничья");
				break;
			}
		}
		System.out.println("Игра закончена");
	}

	public  static boolean seek_Fpoint( char symb ) { // если нашёл куда надо ходить ИИ - true
		int sumDots = 0;

		// проверяются горизонтальные палки
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j <= (SIZE - DOTS_TO_WIN); j++) {
				sumDots = 0;
				for (int k = 0; k < DOTS_TO_WIN; k++) { // сканируем в два прохода на длину палки в поисках незанятой выигрышной точки
					if (map[i][j + k] == symb) sumDots++;
				}
				if (sumDots == DOTS_TO_WIN - 1) {
					for (int k = 0; k < DOTS_TO_WIN; k++) { // второй проход
						if ((map[i][j + k] == DOT_EMPTY) && isCellValid(j+k, i)) {
							xAI = j+k+1;
							yAI = i+1;
							if (xAI >= 0 & yAI >= 0) return true;
						}
					}
				}
			}
		}


		return false;
	}

	public static boolean checkWin(char symb) {
		boolean result;
		// проверяются горизонтальные
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j <= (SIZE - DOTS_TO_WIN); j++) {
				result = true;
				for (int k = 0; k < DOTS_TO_WIN; k++) {
					if (map[i][j + k] != symb) result = false;
				}
				if (result) return true;
			}
		}
		// проверяются вертикальные
		for (int i = 0; i <= (SIZE - DOTS_TO_WIN); i++) {
			for (int j = 0; j < SIZE; j++) {
				result = true;
				for (int k = 0; k < DOTS_TO_WIN; k++) {
					if (map[i + k][j] != symb) result = false;
				}
				if (result) return true;
			}
		}
		// проверяются диагональные
		for (int i = 0; i <= (SIZE - DOTS_TO_WIN); i++) {
			for (int j = 0; j <= (SIZE - DOTS_TO_WIN); j++) {
				result = true;
				for (int k = 0; k < DOTS_TO_WIN; k++) {
					if (map[i + k][j + k] != symb) result = false;
				}
				if (result) return true;
				result = true;
				for (int k = 0; k < DOTS_TO_WIN; k++) {
					if (map[i + DOTS_TO_WIN - k - 1 ][j + k] != symb) result = false;
				}
				if (result) return true;
			}
		}
		return false;
	}

	public static boolean isMapFull() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == DOT_EMPTY) return false;
			}
		}
		return true;
	}

	public static void humanTurn() {
		int x, y;
		do {
			System.out.println("Введите координаты в формате X Y");
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
		} while (!isCellValid(x, y));
		map[y][x] = DOT_X;
	}

	public static void aiTurn() {

		xAI = -1;
		yAI = -1;
		int x = -1, y = -1;

		if (seek_Fpoint(DOT_X)) { // если есть достойный ход для ИИ, ходим
			System.out.println("F-point is: " + xAI + ", " + yAI);
			System.out.println("Компьютер походил в точку " + xAI + ", " + yAI);
			map[yAI - 1][xAI - 1] = DOT_0;
		} else { // иначе, ищем точку случайным образом
			do {
				x = rand.nextInt(SIZE);
				y = rand.nextInt(SIZE);
			} while (!isCellValid(x, y));
			System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
			map[y][x] = DOT_0;
		}

	}

	public static boolean isCellValid(int x, int y) {
		if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
		if (map[y][x] == DOT_EMPTY) return true;
		return false;
	}

	public static void initMap() {
		map = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = DOT_EMPTY;
			}
		}
	}

	public static void printMap() {
		for (int i = 0; i <= SIZE; i++) {
			System.out.printf("%2d ", i);
		}
		System.out.println();
		for (int i = 0; i < SIZE; i++) {
			System.out.printf("%2d ", (i+1));
			for (int j = 0; j < SIZE; j++) {
				System.out.print(" " + map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
