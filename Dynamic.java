
public class Dynamic {

	String[] x,y;
	int m,n;
	int[][] table;
	int comparisons;
	public static void main(String[] args) {
		String[] x = { "T", "G", "T", "T", "A", "G", "C", "C", "G", "A"};
		String[] y = { "T", "G", "T", "T", "A", "G", "C", "C", "G", "A"};
		Dynamic Dy = new Dynamic(x, y);
		
		long startTime = System.nanoTime();
		Dy.opt();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		System.out.println(Dy.comparisons);

	}
	
	public Dynamic(String[] x, String[] y) {
		this.x = x;
		this.y = y;
		this.m = x.length;
		this.n = y.length;
		this.comparisons = 0;
		table = new int[x.length + 1][y.length + 1];
		
		
	}
	
	public int opt() {
		int penalty = 0;
		
		for(int a = 0; a < table[0].length; a++) { //Rightmost Column Base case
			this.table[x.length][a] = 2 * (y.length - a);
			//System.out.println(table[x.length][a]);
		}
		
		for(int b = 0; b < table.length; b++) { //Bottom Row Base case
			this.table[b][y.length] = 2 * (x.length - b);
			//System.out.println(table[b][y.length]);
		}
		
		for(int a = m-1; a>= 0; a--) {
			for(int b = n-1; b >= 0; b--) {
				if(x[a] == y[b]) {
					comparisons++;
					penalty = 0;
				}else {
					comparisons++;
					penalty = 1;
				}
				table[a][b] = Math.min(table[a+1][b+1]+penalty,Math.min(table[a+1][b]+2, table[a][b+1]+2));
			}
		}
		
		//for(int a = 0; a < table.length; a++) {
			//for(int b = 0; b < table[0].length; b++) {
				//System.out.print(table[a][b] + ", ");
			//}
			//System.out.println();
		//}
		
		return table[0][0];
		
	}

}
