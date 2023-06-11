package second.level;

import java.util.Arrays;

public class Second {

	public static void main(String[] args) {
		int x1 = 0; // перше трицифрове число
		int x2 = 0; // друге трицифрове число
		int r1 = 0; // результат множення двох трицифрових чисел
		int r2 = 0; // дзеркальне відображення результату множення
		int r = 1; // змінна для зберігання максимального результату множення
		for(int i = 900; i <= 999; i++) {
			for(int j = 900; j <= 999; j++) {
				r1 = i * j;
				r2 = mirror(r1);
				if(r1 == r2 && r1 > r) {
					r = r1;
					x1 = i;
					x2 = j;
				}
			}
		}
		System.out.println(r);
		System.out.println(x1);
		System.out.println(x2);
	}

	static int mirror(int r) {
		int[] arr1 = new int[6];
		arr1[0] = r / 100000;
		arr1[1] = (r - arr1[0] * 100000) / 10000;
		arr1[2] = (r - arr1[0] * 100000 - arr1[1] * 10000) / 1000;
		arr1[3] = (r - arr1[0] * 100000 - arr1[1] * 10000 - arr1[2] * 1000) / 100;
		arr1[4] = (r - arr1[0] * 100000 - arr1[1] * 10000 - arr1[2] * 1000 - arr1[3] * 100) / 10;
		arr1[5] = r - arr1[0] * 100000 - arr1[1] * 10000 - arr1[2] * 1000 - arr1[3] * 100 - arr1[4] * 10;
		int[] arr2 = new int[6];
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[arr1.length - 1 - i];
		}
		return arr2[0] * 100000 + arr2[1] * 10000 + arr2[2] * 1000 + arr2[3] * 100 + arr2[4] * 10 + arr2[5];
	}
}
