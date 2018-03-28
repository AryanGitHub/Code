
public class timeaddsubtest {

	public static void main(String[] args) {
		int n = 100000;
		double data  [] = new double[n];
		double data2  [] = new double[n];
		for (int i = 0 ; i < n  ; i ++) {
			data[i] =  Math.random();
			data2[i] =  Math.random();
		}
		
		long add1 = System.nanoTime();
		for (int i = 0 ; i < n  ; i ++) {
			double a = data[i] + data[i];
		}
		long add2 = System.nanoTime();
		
		
		long sub1 = System.nanoTime();
		for (int i = 0 ; i < n  ; i ++) {
			double a = data[i] - data[i];
		}
		long sub2 = System.nanoTime();
		
		long add = add2-add1;
		long sub = sub2-sub1;
		
		System.out.println(add);
		System.out.println(sub);
	}

}
