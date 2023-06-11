package first.level;

public class Third {

	public static void main(String[] args) {
		int lenght = 39;
		int width = 6;
		rectangle(lenght, width);
	}
	static void rectangle(int l, int w) {
		for(int i = 1; i <= w; i++) {
			if(i == 1 || i == w) {
				for(int j = 1; j <= l; j++) {
					System.out.print("*");
				}
			}
			else {
				for(int j = 1; j <= l; j++) {
					if(j == 1 || j == l) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}
