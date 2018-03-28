package codingTrain_Tests;

import java.util.ArrayList;

class Quadtree {
    Rectangle boundry;
    int capacity; // max no. of points
    ArrayList <Point> points ;
    boolean divide = false;
    Quadtree northeast; 
      Quadtree northwest;
      Quadtree southeast;
      Quadtree southwest;
    
    public Quadtree (Rectangle rect , int cap){
      this.boundry = rect;
      this.capacity = cap;
      points = new ArrayList<Point>();
    }
    
    public boolean contains (Point p){
     return  p.x <= this.boundry.x+this.boundry.width &&
             p.x >= this.boundry.x-this.boundry.width &&
             p.y <= this.boundry.y+this.boundry.height &&
             p.y >= this.boundry.y-this.boundry.height ;
    }
    
    public void insert (Point p){
      if (!this.contains(p)) return;
      if (this.points.size() < this.capacity ){
      this. points.add(p); 
      }
      else {
        if (!this.divide) {
        subDivide();
        }
        
        this.northeast.insert(p);
        this.northwest.insert(p);
        this.southeast.insert(p);
        this.southwest.insert(p);
     }
    }
    public void  subDivide (){
      int x = this.boundry.x;
      int y = this.boundry.y;
      int w = this.boundry.width;
      int h = this.boundry.height;
       this.northeast = new Quadtree(new Rectangle (x+w/2 , y-h/2 , w/2 , h/2),capacity);
      this.northwest = new Quadtree(new Rectangle (x-w/2 , y-h/2 , w/2 , h/2),capacity);
      this.southeast = new Quadtree(new Rectangle (x+w/2 , y+h/2 , w/2 , h/2),capacity);
      this.southwest = new Quadtree(new Rectangle (x-w/2 , y+h/2 , w/2 , h/2),capacity);
      this.divide = true;  
  }
 /* public void show (){
  stroke(255);
  noFill();
  rectMode(CENTER);
  rect (this.boundry.x , this.boundry.y , this.boundry.width *2 , this.boundry.height*2);
  if (this.divide){
   this.northeast.show();
   this.northwest.show();
   this.southeast.show();
   this.southwest.show();
  }
  }*/
    
    
    
    
    
  }