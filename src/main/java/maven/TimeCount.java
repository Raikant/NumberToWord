package maven;

public class TimeCount {
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		while (true) {
			if (System.currentTimeMillis() - now > 10) {
				System.out.println("over");
				System.exit(0);
			}
			System.out.println("waiting");
		}
	}
}
