// Daniel Shiffman
// http://codingtra.in
// http://patreon.com/codingtrain
//Videos
//Part 1:
//https://www.youtube.com/watch?v=OJxEcs0w_kE
//Part 2: 
//https://www.youtube.com/watch?v=QQx_NmCIuCY

//This code is only part 1 video of the challenge. 

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
    
    public boolean insert (Point p){
      if (!this.contains(p)) return false; //<>//
      if (this.points.size() < this.capacity ){
      this. points.add(p); 
      return true;
      }
      else {
        if (!this.divide) {
        subDivide();
        }
        if (this.northeast.insert(p)){
         return true; 
        }
        else if (this.northwest.insert(p)){
          return true;
        } 
        else if (this.southeast.insert(p)){
          return true;
        }
        else if(this.southwest.insert(p)){
          return true;
        } 
        else return false; //<>//
     }
    }
   public void  subDivide (){
      double x = this.boundry.x;
      double y = this.boundry.y;
      double w = this.boundry.width;
      double h = this.boundry.height;
       int newCapacity = capacity; 
       if (w*h <= 0.25) {
          newCapacity = Integer.MAX_VALUE-100;
      }
      
       this.northeast = new Quadtree(new Rectangle (x+w/2 , y-h/2 , w/2 , h/2),newCapacity);
      this.northwest = new Quadtree(new Rectangle (x-w/2 , y-h/2 , w/2 , h/2),newCapacity);
      this.southeast = new Quadtree(new Rectangle (x+w/2 , y+h/2 , w/2 , h/2),newCapacity);
      this.southwest = new Quadtree(new Rectangle (x-w/2 , y+h/2 , w/2 , h/2),newCapacity);
      this.divide = true;  
     
      
      for (int i = this.capacity-1 ; i >= 0 ; i--){
        
        Point p = this.points.get(this.points.size()-1);
         if (this.northeast.insert(p)){
           
           this.points.remove(this.points.size()-1);
        }
        else if (this.northwest.insert(p)){
        this.points.remove(this.points.size()-1);
        } 
        else if (this.southeast.insert(p)){
         this.points.remove(this.points.size()-1);
        }
        else if(this.southwest.insert(p)){
         this.points.remove(this.points.size()-1);
        }
        
      }
      
      }
      
  public void show (){
  stroke(255);
  strokeWeight(1);
  noFill();
  rectMode(CENTER);
  rect ((float)this.boundry.x , (float)this.boundry.y , (float)this.boundry.width *2 , (float)this.boundry.height*2);
  if (this.divide){
   this.northeast.show();
   this.northwest.show();
   this.southeast.show();
   this.southwest.show();
  }
  // (for showing points)
  for (Point p:points){
    strokeWeight(4);
    point((float)p.x , (float)p.y);
  }
  
    
  }
    
    
    
  }