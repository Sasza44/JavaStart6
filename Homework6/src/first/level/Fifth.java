package first.level;

public class Fifth {

	public static void main(String[] args) {
		String text = "I am a student";
		System.out.println(wordsNumber(text));
	}
	static int wordsNumber(String t) {
		int x = 0;
		for(int i = 0; i < t.length(); i++) {
			if(t.charAt(i) == ' ') {x += 1;}
		}
		if(x > 0) {x += 1;}
		return x;
	}
}