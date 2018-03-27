import java.io.*;
import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.output.NamespaceContextImpl.Element;
class Matrix {
	// done means the method / constructor is working and it is checked

  private ArrayList <ArrayList<Double>> mat = new ArrayList<ArrayList<Double>>();;
  private int rows;
  private int cols;

  final static Double DV = null;
  
  
// constructors = 3c
  
  
// 1/3
  // it does not uses getters and setters
public Matrix (int rows , int cols  , Double de){

  for (int i = 0 ; i < rows ; i++){ // from every array
    mat.add(new ArrayList <Double>());
    for (int j = 0 ; j < cols ; j++){ // from every element of the arrays
      mat.get(i).add(de);
    }
  }

  this.updateOrder();
}


// 2/3c
// it does not uses getters and setters
public Matrix (Double a [] []){
  // it is already in RECTANGULAR shape
     for (int i = 0 ; i < a.length ; i++){
       ArrayList copy = new ArrayList <Double> ();
       for (int j = 0 ; j < a[i].length ; j++){

             copy.add(a[i][j]);
       }
       mat.add(copy);
     }
        this.updateOrder();
   }


   // 3/3c
     public Matrix (ArrayList  <ArrayList <Double>> a){ //Done
   // this is the first thing that i have done in order to find the largest length number in the ArrayLists
   //then allocate all other arrays Null value , so it could maintain its RECTANGULAR shape.
     int maxLen = 0;
    for (int i = 0 ; i < a.size() ; i++){
      maxLen = Math.max(maxLen , a.get(i).size());
    }
          for (int i = 0 ; i < a.size() ; i++){
            while (a.get(i).size() < maxLen){
               a.get(i).add(DV);
            }
            mat.add(a.get(i));
          }

          this.updateOrder();
    }
     
     
     
     
     
     
    // configure matrix and its order methods:- two parts
    // A) private (inside class)
    // B) public (for Every one)

    // class A (private) methods :- 1

    //1/1
    //updateOrder () analyse the matrix and changes orderOfMatrix
    private void updateOrder (){ //Done
      this.rows = mat.size(); // no. of arrays
      this.cols = mat.get(0).size();// no. of element in each array , i have chosen 0 th row because its the basic row , pretty simple.
    }

    // class B (public) methods :- 1
    // 1/1
    //it is used to change a part of the matrix , requires a starting and a ending point and value to change with 
    public void set (int startRow ,  int startCol , int endRow , int endCol , Double element){ //done
    int copy = startCol;
         for (;startRow <= endRow ; startRow++){
           startCol = copy;
           for (;startCol <= endCol ; startCol++){
             mat.get(startRow).set(startCol , element);
           }
         }
    }
    //1b
    public void set (int endRow , int endCol ,  Double element){//Done
      this.set(0,0,endRow , endCol , element);
    }
    //1c
    public void set (Double element){//Done
      this.set (this.rows -1, this.cols-1 , element);
    }

    
    // 2/2
  //update Matrix by its orderOfMatrix
    // it keeps the data and add new null values

   /* public void updateMatrix (){// add if we reduce size
    boolean orderUpdated = false;//this is done to check if there is a change or not , if not then the loop will not start , if this in not there thenthe loop was starting but not effective , so this is done to reduce time taken 
    if (this.rows!=this.mat.size() || this.cols!=this.mat.get(0).size())  orderUpdated = true;
    for (int i = 0 ; i < this.rows &&orderUpdated ; i++){
      if (i == this.mat.size()) this.mat.add(new ArrayList <Double> ());
      while (mat.get(i).size() < this.cols){
         mat.get(i).add(DV);
      }
    }
  }*/
    
// i have commented this above method as it is limited in its working only useful in condition when orderOfMatrix was bigger than that of original matrix
    // this method can do both condition even when it is smaller
    
    public void updateMatrix () { // Done
    //first we will process rows then cols
    if (this.rows > this.mat.size())
    {
    	while (this.mat.size() < this.rows) {
    		ArrayList <Double> a = new ArrayList <Double>();
    		while (a.size() <this.mat.get(0).size() )
    			a.add(DV);
    		this.mat.add(a);
    	}
    }
    	else if (this.rows < this.mat.size()) {
    		for (int i = this.mat.size()-1 ; i >=this.rows;i--) {//  i have removed the last element because its a lot faster than removing a element from middle.See carefully that i have said " i >=this.rows " as i am coming from backwards so i have to remove the this.row 'th element also , then only i could have this. row one more than last indexed element 
    			this.mat.remove(i);
    		}
    	}
    
    //now we will see the cols
    if (this.cols > this.mat.get(0).size()) {
    	
    	for (int i = this.mat.get(0).size() ; i < this.cols ; i++ ) {// for every col in row starting from max size present
    		for (int j = 0 ; j < this.rows ; j++) {//for every row 
    			this.mat.get(j).add(DV); // see the beauty of coding as we dont have to tell to add at i position , but it understood it, because everytime it will be at the least.
    		}
    	}
    }
    
    else if (this.cols < this.mat.get(0).size()) {
    	for (int i = this.mat.get(0).size() -1; i >= this.cols ; i--) {//for every cols last element start loop to the decereae point
    		for (int j = 0 ; j < this.rows ; j++) {//in every row remove the last Element , i have removed the last element because its a lot faster than removing a element from middle 
    			this.mat.get(j).remove(i);
    		}
    	}
    }
    
    }


  public void setOrder (int rows , int cols){//Done
        this.rows = rows;
        this.cols = cols;
        this.updateMatrix();
  }

  public void setOrder (String s){//Done
  String Srows = "";
  String Scols = "";
  for (int i = 0 ; i < s.length() ; i++){
  char ch = s.charAt(i);
  if (ch == 'x'){
  Srows = s.substring( 0 , i).trim();
  Scols = s.substring( i+1 , s.length()).trim();
  break;
    }
    }
  this.setOrder(Integer.parseInt(Srows) , Integer.parseInt(Scols));
  }
    // general methods (here is a rule now that we will use getter and setter after they are defined, if i you in above methods that will cause StackOverflow Error)
  
  public Double getElement (int row , int col) {//
	  return mat.get(row).get(col);
  }
  public void addRow () {//Done
  this.setOrder(this.rows+1,this. cols);
  }
  public void addCol () {//Done
  this.setOrder(this.rows,this. cols+1);
  }

  public void setElement (int rows , int cols , Double element) {//Done
	if (rows >= this.rows || cols >= this.cols)this.setOrder(rows+1, cols+1); 
	 this.mat.get(rows).set(cols, element);
  }

   public int getRows (){//Done
	   return this.rows;
   }
   
   public int getCols () {//Done
	   return this.cols;
   }
  
   public boolean equalsOrder (Matrix a) {//Done
	   return this.rows == a.getRows() && this.cols == a.getCols();
   }
   public boolean equlas(Matrix a) {//Done
	   if (this.equalsOrder(a)) {
		   for (int i = 0 ; i < this.rows ; i++) {
			   for (int j = 0 ; j < this.cols ; j++) {
				   if (this.getElement(i, j)!=a.getElement(i, j)) {
					   return false;
				   }
			   }
		   }
		   return true;
	   }
	   else return false;
   }
  // imalise matrix methods 
   //So it do not include the limit  but could give a min value
   public static Matrix rand (int rows , int cols , double min , double limit) {//Done
	   Matrix ret = new Matrix(rows, cols , null);
	  
	   for (int i = 0 ; i < ret.getRows() ; i++) {
		   for (int j= 0 ; j < ret.getCols() ; j++) {
			  ret.setElement(i,j,min+Math.random()*limit);
		   }
	   }
	   return ret;
   }
   public static Matrix rand (int rows , int cols  ) {//Done
	   return Matrix.rand(rows, cols,00. , 1.0);
   }
   

   // display methods
    public String toString(String space ,  String newLine){//Done

      String ret = "";
      for (int i = 0 ;i< this.rows ; i++){
           for (int j = 0 ; j <this.cols; j++)
             ret += this.getElement(i, j)+((j != this.cols-1)?space:"");
             ret+=newLine;
      }
      return ret;
    }
    public String toString(String space){//Done
      return this.toString (space , "\n");
    }
    public String toString(){//Done
      return this.toString (" ");
    }
    public void display(){//Done
      System.out.println (this.toString());
    }
// simple Arithemetic Oprations
    public void add (double c){
      for (int i = 0 ; i < mat.size() ; i++){
           for (int j = 0 ;j < mat.get(i).size() ; j++){

            mat.get(i).set(j , mat.get(i).get(j) + c);

           }
      }
    }

      public void sub (double c){
        for (int i = 0 ;i < mat.size() ; i++){
             for (int j = 0 ;j < mat.get(i).size() ; j++){

              mat.get(i).set(j , mat.get(i).get(j) - c);
             }
        }
      }

        public void mul (double c){
          for (int i = 0 ;i < mat.size() ; i++){
               for (int j = 0 ;j <  mat.get(i).size() ; j++){

                mat.get(i).set(j , mat.get(i).get(j) * c);

               }
          }
        }

          public void div (double c){
            for (int i = 0 ;i <  mat.size() ; i++){
                 for (int j = 0 ; j <  mat.get(i).size() ; j++){

                  mat.get(i).set(j , mat.get(i).get(j) / c);

                 }
            }
    }

    public void mod (int c){
      for (int i = 0 ;i <  mat.size() ; i++){
           for (int j = 0 ;j < mat.get(i).size() ; j++){

            mat.get(i).set(j , mat.get(i).get(j) % c);

           }
      }
      }
    
    // Add or sub Matrix
    public Matrix add(Matrix a) {
    	Matrix ret = new Matrix (this.rows , this.cols , null);
    	if(this.equalsOrder(a)) {
 		   for (int i = 0 ; i < this.rows ; i++) {
 			   for (int j = 0 ; j < this.cols ; j++) {
 				  ret.setElement(i, j, this.getElement(i , j)   +  a.getElement(i,j));
 			   }
 		   }
 		   
 	   }
 	  return ret;
    }
    
    public Matrix sub(Matrix a) {
    	Matrix ret = new Matrix (this.rows , this.cols , null);
    	if(this.equalsOrder(a)) {
 		   for (int i = 0 ; i < this.rows ; i++) {
 			   for (int j = 0 ; j < this.cols ; j++) {
 				  ret.setElement(i, j, this.getElement(i , j)   -  a.getElement(i,j));
 			   }
 		   }
 		   
 	   }
 	  return ret;
    }
    
    public Matrix dotProduct(Matrix a) {
    	Matrix ret = new Matrix (this.rows , this.cols , null);
    	if(this.equalsOrder(a)) {
 		   for (int i = 0 ; i < this.rows ; i++) {
 			   for (int j = 0 ; j < this.cols ; j++) {
 				  ret.setElement(i, j, this.getElement(i , j)   *  a.getElement(i,j));
 			   }
 		   }
 		   
 	   }
 	  return ret;
    }
    
    public Matrix mul(Matrix a) {
    	if(this.cols == a.getRows()) {
    	Matrix ret = new Matrix (this.rows , a.getCols() , null);
 		   for (int i = 0 ; i < this.rows ; i++) {
 			   for (int j = 0 ; j < this.cols ; j++) {
 				   
 				   Double data = 0.0;
 				   for (int x = 0 ; x < this.rows;x++) {
 					   data+=this.getElement( i,x)*a.getElement(x, j );
 				   }
 				  ret.setElement(i, j,   data);
 			   }
 		   }
 		   return ret;
 	   }
    	else return null;
    }
    
    
    	
    	
    }
    		
    		
    		
