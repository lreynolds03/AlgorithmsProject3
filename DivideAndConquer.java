
import java.lang.System;
public class DivideAndConquer {

	String[] x;
	String[] y;
	int m, n;

	public static void main(String[] args) {
		String[] x = { "A", "A","C","A","G","T","T","A","C","C"};
		String[] y = { "T", "A","A","G","G","T","C","A"};
		
		DivideAndConquer DC = new DivideAndConquer(x, y);
		long startTime = System.nanoTime();
		DC.opt(0, 0);
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
	}

	public DivideAndConquer(String[] x, String[] y) {
		this.x = x;
		this.y = y;
		this.m = x.length;
		this.n = y.length;
	}

	public int opt(int i, int j) {
		int penalty;
		if (i == x.length) {
			 return 2 * (n - j);
		} else if (j == y.length) {
			return 2 * (m - i);
		} else {
			if (x[i] == y[j]) {
				penalty = 0;
			} else {
				penalty = 1;

			}
			 return Math.min(opt(i + 1, j + 1) + penalty, Math.min(opt(i + 1, j) + 2, opt(i, j + 1) + 2));
		}
	}

}
