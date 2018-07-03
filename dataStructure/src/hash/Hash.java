package hash;

import java.util.HashMap;
import java.util.Scanner;

public class Hash {
	public static void main(String[] args) {
		int a1=new Scanner(System.in).nextInt();
		int a2=new Scanner(System.in).nextInt();
		int a3=new Scanner(System.in).nextInt();
		int a4=new Scanner(System.in).nextInt();
		int a5=new Scanner(System.in).nextInt();
		solve(a1,a2,a3,a4,a5);
	}
	static void solve(int a1, int a2, int a3, int a4, int a5) {
		HashMap<Integer, Integer> m = new HashMap<>();
		for (int i = -50; i < 50; i++) {
			for (int j = - 50; j < 50; j++) {
				for (int k = -50; k < 50; k++) {
					int t = a1 * i * i * i + a2 * j * j * j + a3 * k * k * k;
					Integer p = m.get(t);
					if (p == null)
						m.put(t, 1);
					else
						m.put(t, p + 1);
				}
			}
		}

		int sum = 0;
		for (int i = -50; i < 50; i++) {
			for (int j = -50; j < 50; j++) {
				int t = a4 * i * i * i +  a5 * j * j * j;
				Integer p = m.get(-t);

				if (p != null)
					sum += p;
			}
		}

		System.out.print(sum);
	}
}
