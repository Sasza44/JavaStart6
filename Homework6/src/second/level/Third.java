package second.level;

import java.util.Arrays;

public class Third {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4}; // масив, який змінюватиме програма
		System.out.println(Arrays.toString(arr));
		change(arr.length - 1, arr);
	}
	static void change(int n, int[] a) {
		if(n == 0) {return;}
		int x = 0;
		for(int i = 1; i <= n; i++) {
			int[] a1 = new int[n]; // масив для контролю співпадань
			for (int i1 = 0; i1 < a1.length; i1++) {a1[i1] = 0;}
			for(int j = 1; j <= i; j++) {
				a1[j - 1] = a[i];
				int j1 = 0;
				boolean b = false; // біт виявлення співпадання
				do {
					b = false;
					for(int k = 0; k < a1.length; k++) {
						if(a1[k] == a[j1]) {
							b = true;
							j1 += 1;
						}
					}
				} while(b == true);
				x = a[j1];
				a[j1] = a[i];
				a[i] = x;
				System.out.println(Arrays.toString(a));
				change(i - 1, a);
			}
		}
	}
}