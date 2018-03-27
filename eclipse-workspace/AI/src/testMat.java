import java.util.*;
public class testMat {

	public static void main(String[] args) {
		
		Matrix m = new Matrix(3,3,1.0);
		m.display();
		System.out.print(m.toString(  ));
	
 /*        ArrayList <ArrayList<Double>> a = new ArrayList <ArrayList<Double>> ();
		a.add(new ArrayList <Double>());
		a.get(0).add(10.0);
		a.get(0).add(20.0);
		a.add(new ArrayList <Double>());
		a.get(1).add(10.0);
		a.get(1).add(20.0);
		a.get(1).add(20.0);  
		a.get(1).add(20.0);
		      Matrix m =new Matrix(a);
		      m.display();
		      m.set( 100.0);
		      m.display();*/
 /* ArrayList <Double>arr = new ArrayList <Double>();
	ArrayList <Double>arr2 = new ArrayList <Double>();
	int  n = 100000;
	for (int i = 0 ; i < n ; i++) {
		arr.add(Math.random() * 100);
		arr2.add(Math.random() * 100);
	}
	//print(arr);
	//print(arr2);
	int nupon2 = n/2;
	long arr11 = System.nanoTime();
	
	for (int i = 0 ; i < n/2 ; i++) {
		arr.remove(nupon2);
	}
	long arr12 = System.nanoTime();
	//print(arr);	
	
	
	long arr21 = System.nanoTime();
	
	int i = arr2.size()-1;
	for ( ; i >= n/2 ; i--) {
		arr2.remove(i);
		}
	long arr22 = System.nanoTime();
	//print (arr2);
	long arr1d = arr12-arr11;
	double arr2d = (double)arr22-arr21;
	System.out.println(arr1d);
	System.out.println(arr2d);
	System.out.println (arr1d/arr2d);
	
	}

	public static void print(ArrayList a) {
		for (int  i = 0 ; i < a.size() ; i++) {
			System.out.println (i + "     ---    "+a.get(i));
		}
		System.out.println ("--------------------");
		*/
		
	}



		
		
		}


