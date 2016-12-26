package ru.geekbrains.firstproject;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson3 {

	// Решил задачу 2.
	// Использовал замену символа в строке #################### по его индексу. Для этого нашёл "самодельный" метод replaceCharAt.

	public static void main(String[] args) {

		// Задаём массив слов и показываем его
		String fruits = "apple orange lemon banana apricot avocado broccoli carrot cherry garlic grape melon leak kiwi mango mushroom nut olive pea peanut pear pepper pineapple pumpkin potato";
		String[] arrayFruits = fruits.split(" "); // превращаем строку в массив слов
		System.out.println(Arrays.toString(arrayFruits));

		// загадываем слово
		int randomKey = (int) (Math.random() * arrayFruits.length);
		String randomWord = arrayFruits[randomKey];
		System.out.println("\n Угадайте, какое слово из списка загадал компьютер? \n Ввведите слово: ");


		while (true) {
			// вводим слово и сравниваем с загаданным. Сообщаем.
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			if (randomWord.equals(str)) { // если угадали окей
				System.out.println("Вы угадали. Прекрасно!");
				break;
			} else {  // если не угадали, прокручиваем перебор по менее длинному слову
				String chequer = "####################";
				int shortLength;
				shortLength = (randomWord.length() <= str.length()) ? randomWord.length() : str.length();

				for (byte i = 0; i < shortLength; i++) {
					if (randomWord.charAt(i) == str.charAt(i)) {
						chequer = replaceCharAt(chequer, i, randomWord.charAt(i)); // заменяем решётку угаданным символом
					}
				}
				System.out.println(chequer);
			}
		}
	}

	public static String replaceCharAt(String s, int pos, char c) {  // заменяет один символ в строке на заданный по его индексу
		return s.substring(0, pos) + c + s.substring(pos + 1);
	}
}
