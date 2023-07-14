package second.level;

import java.util.Arrays;
import java.util.Scanner;

public class First {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		String array;
		System.out.println("Write a number array");
		array = sc.nextLine(); // ряд, набраний з клавіатури
		int[] array1 = getArray(array); // перетворення набраного рядка на масив цілих чисел
		System.out.println(Arrays.toString(array1));
		int nextElement = getNextEl(array1); // отримання наступного елементу послідовності
		if(nextElement == 0) {
			System.out.println("The next element is unknown");
		}
		else {
			System.out.println("The next element is " + nextElement);
		}
	}
	
	
	static int[] getArray(String arr) { 
		int[] arr1 = new int[20]; // вставляємо набрані цілі числа в масив (кількість елементів з запасом)
		int indFree = 0; // наступний вільний індекс виществореного масиву
		int index = -2; // індекс коми
		while(index != -1) {
			int indLast; // попередній індекс коми
			if(index == -2) {
				index = arr.indexOf(',');
				if(index == -1) {arr1[0] = Integer.valueOf(arr.trim());}
				else {
					indFree += 1;
					arr1[0] = Integer.valueOf(arr.substring(0, index).trim());
				}
			}
			else {
				indLast = index;
				index = arr.indexOf(',', indLast + 1);
				if(index == -1) {arr1[indFree] = Integer.valueOf(arr.substring(indLast + 1).trim());}
				else {
					arr1[indFree] = Integer.valueOf(arr.substring(indLast + 1, index).trim());
					indFree += 1; 
				}
			}
		}
		int[] arr2 = new int[indFree + 1]; // масив з набраних чисел, але без запасу
		for(int i = 0; i < indFree + 1; i++) {arr2[i] = arr1[i];}
		return arr2;
	}
	
	static int getNextEl(int[] arr) { // перевірка кожного елементу на належність до одного з прикладів послідовностей
		int n1 = 0;
		boolean b1 = false; // додатковий біт для виявлення неоднаковості різниці (для арифметичної прогресії)
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] - arr[i - 1] != arr[1] - arr[0]) {b1 = true;}
		}
		boolean b2 = false; // додатковий біт для перевірки кожного елементу на належність до показникової функції 
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != (int)Math.pow(3, i)) {b2 = true;}
		}
		boolean b3 = false; // додатковий біт для послідовності, у якій різниця зростає на одне і те саме число
		int difference = arr[arr.length - 1] - 2 * arr[arr.length - 2] + arr[arr.length - 3];
		for(int i = 2; i < arr.length; i++) {
				if((arr[i] - arr[i - 1]) != (arr[i - 1] - arr[i - 2] + difference)) {b3 = true;}
			}
		boolean b4 = false; // додатковий біт для перевірки кожного елементу на належність до кубічної степеневої функції
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != (int)Math.pow(i + 1, 3)) {b4 = true;}
		}
		boolean b5 = false; // додатковий біт для перевірки кожного елементу на належність до послідовності, у якій наступний елемент удвічі більший попереднього
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i - 1] * 2) {b5 = true;}
		}		// розрахунок наступного елементу в залежності від того, якому зразку послідовність відповідає
		if(arr.length >= 3 && b1 == false) {n1 = 2 * arr[arr.length - 1] - arr[arr.length - 2];} // якщо арифметична прогресія
		else if(arr.length >= 3 && b2 == false) {n1 = (int)Math.pow(3, arr.length);} // якщо показникова функція з основою 3
		else if(arr.length >= 3 && b3 == false) {n1 = 2 * arr[arr.length - 1] - arr[arr.length - 2] + difference;}  // якщо різниця зростає на одне і те саме число
		else if(arr.length >= 3 && b4 == false) {n1 = (int)Math.pow(arr.length + 1, 3);} // якщо кубічна степенева функція
		else if(arr.length >= 3 && b5 == false) {n1 = arr[arr.length - 1] * 2;} // якщо наступний елемент удвічі більший попереднього
		return n1;
	}
}