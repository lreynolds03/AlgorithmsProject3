
import java.lang.System;
public class DivideAndConquer {

	String[] x;
	String[] y;
	int m, n, comparisons;

	public static void main(String[] args) {
		String[] x = { "T", "G", "T", "T", "A", "G", "C", "C", "G", "A"};
		String[] y = { "T", "G", "T", "T", "A", "G", "C", "C", "G", "A"};
		
		DivideAndConquer DC = new DivideAndConquer(x, y);
		long startTime = System.nanoTime();
		DC.opt(0, 0);
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		System.out.println(DC.comparisons);
	}

	public DivideAndConquer(String[] x, String[] y) {
		this.x = x;
		this.y = y;
		this.m = x.length;
		this.n = y.length;
		this.comparisons = 0;
	}

	public int opt(int i, int j) {
		int penalty;
		if (i == x.length) {
			comparisons++;
			 return 2 * (n - j);
		} else if (j == y.length) {
			comparisons+=2;
			return 2 * (m - i);
		} else {
			comparisons+=2;
			if (x[i] == y[j]) {
				comparisons++;
				penalty = 0;
			} else {
				comparisons++;
				penalty = 1;
			}
			 return Math.min(opt(i + 1, j + 1) + penalty, Math.min(opt(i + 1, j) + 2, opt(i, j + 1) + 2));
		}
	}

}
