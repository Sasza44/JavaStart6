package first.level;

public class Second {

	public static void main(String[] args) {
		int a11 = 34;
		double a22 = 5.47;
		String a33 = "Number ";
		System.out.println(addAll(a11, a22, a33));
	}
	static String addAll(int a1, double a2, String a3) {
		return a3 + String.valueOf(a1 + a2);
	}
}
