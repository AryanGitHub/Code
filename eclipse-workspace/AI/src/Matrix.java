import java.io.*;
import java.util.*;
class Matrix {

  private ArrayList <ArrayList<Double>> mat = new ArrayList<ArrayList<Double>>();;
  private int rows;
  private int cols;

  final static Double DV = null;
// constructors = 3c
// 1/3
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
     public Matrix (ArrayList  <ArrayList <Double>> a){
   // this is the first thing that i have done in order to find the largest number in the ArrayList
   //then allocate all other arrays Null value , so to maintain its RECTANGULAR shape
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
    private void updateOrder (){
      this.rows = mat.size(); // no. of arrays
      this.cols = mat.get(0).size();// no. of element in each array
    }

    // class B (public) methods :- 1
    // 1/1
    public void set (int startRow ,  int startCol , int endRow , int endCol , Double element){
    int copy = startCol;
         for (;startRow < endRow ; startRow++){
           startCol = copy;
           for (;startCol < endCol ; startCol++){
             mat.get(startRow).set(startCol , element);
           }
         }
    }
    //1b
    public void set (int endRow , int endCol ,  Double element){
      this.set(0,0,endRow , endCol , element);
    }
    //1c
    public void set (Double element){
      this.set (this.rows , this.cols , element);
    }

    //update Matrix by its orderOfMatrix
    // it keeps the data and add new null values
    // 2/2

    public void updateMatrix (){// add if we reduce size
    boolean orderUpdated = false;//this is done to check if there is a change or not , if not then the loop will not start , if this in not there thenthe loop was starting but not effective , so this is done to reduce time taken 
    if (this.rows!=this.mat.size() || this.cols!=this.mat.get(0).size())  orderUpdated = true;
    for (int i = 0 ; i < this.rows &&orderUpdated ; i++){
      if (i == this.mat.size()) this.mat.add(new ArrayList <Double> ());
      while (mat.get(i).size() < this.cols){
         mat.get(i).add(DV);
      }
    }
  }

  public void setOrder (int rows , int cols){
        this.rows = rows;
        this.cols = cols;
        this.updateMatrix();
  }

  public void setOrder (String s){//not working
  String Srows = "";
  String Scols = "";
  for (int i = 0 ; i < s.length() ; i++){
  char ch = s.charAt(i);
  if (ch == 'x'){
  Srows = s.substring( 0 , i).trim();
  Srows = s.substring( i+1 , s.length()).trim();
  break;
    }
    }
  this.setOrder(Integer.parseInt(Srows) , Integer.parseInt(Scols));
  }
    // general methods
  
  public Double getElement (int row , int col) {
	  return mat.get(row).get(col);
  }
  public void addRow () {
  this.setOrder(this.rows+1,this. cols);
  }
  public void addCol () {
  this.setOrder(this.rows,this. cols+1);
  }

  public void setElement (int row , int col , Double element) {
	// if (row < this.rows || cols < this.cols)this.setOrder(row, col); not working perfectily
	  this.mat.get(row).set(col, element);
  }

   public int getRows (){
	   return this.rows;
   }
   
   public int getCols () {
	   return this.cols;
   }
  
   public boolean equalsOrder (Matrix a) {
	   return this.rows == a.getRows() &&this.cols == a.getCols();
   }
   public boolean equlas(Matrix a) {
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
   
   public static Matrix rand (int rows , int cols , int min , int limit) {
	   Matrix ret = new Matrix(rows, cols , null);
	  
	   for (int i = 0 ; i < ret.getRows() ; i++) {
		   for (int j= 0 ; j < ret.getCols() ; j++) {
			  ret.setElement(i,j,min+Math.random()*limit);
		   }
	   }
	   return ret;
   }
   public static Matrix rand (int rows , int cols , int min ) {
	   return Matrix.rand(rows, cols, min , 1);
   }
   

   // display methods
    public String toString(String space ,  String newLine){

      String ret = "";
      for (int i = 0 ;i< mat.size() ; i++){
           for (int j = 0 ; j <mat.get(i).size() ; j++)
             ret += mat.get(i).get(j)+((j != mat.get(i).size())?space:"");
             ret+=newLine;
      }
      return ret;
    }
    public String toString(String space){
      return this.toString (space , "\n");
    }
    public String toString(){
      return this.toString (" ");
    }
    public void display(){
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
    		
    		
    		