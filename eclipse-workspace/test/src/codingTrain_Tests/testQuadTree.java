package codingTrain_Tests;

public class testQuadTree {

	public static void main(String[] args) {
		int width = 400;
		int height = 400;
	
	
		Quadtree q = new Quadtree (new Rectangle (width/2 , height/2 , width/2 , height/2) , 2);
		  q.insert(new Point(20,20));
		  q.insert(new Point(21,21));
		  q.insert(new Point(22,22));
		  q.insert(new Point(23,23));
		  q.insert(new Point(23,20));
		  q.insert(new Point(20,20));
		  q.insert(new Point(20,20));
		 /*for(int i = 0 ; i < 10 ; i++){
		    Point p = new Point((int)random(0 , width) , (int)random (0 , height));
		    q.insert(p);}*/

		
	}
		  
		  public static int random (int l , int max) {
			  return (int)(l+Math.random()*(max-l));
					  }

}
