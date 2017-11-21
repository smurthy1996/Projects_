package cityDisplay;
//package SkyLine;


//********************************************************************
//  RubberLinesPanel.java       Author: Lewis/Loftus
// 								Modified by S.Murthy
//
//  Represents the Sun display object in the Office Panel.
//********************************************************************

import java.awt.*;

import javax.swing.*;

public class Buildingobj extends JPanel
{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Point points;		// define a list of points
	
	private static final int RED = 255;					// define gold color
	private static final int GREEN = 0;
	private static final int BLUE = 0;
	
	private int radius;								// size of the Sun
    private Color shade;
    private int states;		
 	private int cState;    
 	int incrX;
 	int incrY;
 	Color shade2;
 	Color shade3;
	private int incre;
	private int resetincre = this.radius;
	private int increment = 100;
 	private int width = 550 ,height = 100;
 	private Color clr;
 	private Color background;

   //-----------------------------------------------------------------
   //  constructor places the object and sets the number of states
   //-----------------------------------------------------------------
 	public Buildingobj(int x, int y, int r, int fx, int fy, int stat,int increment,Color clr)
 	{

 		
 		points = new Point();
	  
 		background = clr;
 		setBackground(background);
      
 		points.x = x;					// x coordinate
 		points.y = y;					// y coordinate            
 		radius = r;						// radius
 		this.clr = clr;
 		incrX = (fx - x)/stat;			// x increment
 		incrY = (fy - y)/stat;			// y increment
 		this.incre = r;
 		states = stat;		// number of states
 	
 	
 		cState = 0;
 		shade = new Color(RED,GREEN,BLUE);
 		this.increment += increment;

 		
      
   }

   //-----------------------------------------------------------------
   //  Displays the mouse point locations, rectangle, and triangle
   //  input by the user.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics g)
   {     
	  super.paintComponent (g);			// present the blank page

	  this.setBackground(background);

      int[] xcords1 = {10,40,129,100};
      int[] ycords1 = {0+increment,0+increment,0+increment,0+increment};
      
      g.drawPolygon(xcords1,ycords1,4);
      g.setColor(shade.brighter());
      g.fillPolygon(xcords1,ycords1,4);
      
     

      
      
      int[] rect1cordsx = {10,100,100,10};
      
      int[] rect1cordsy = {0+increment,0+increment,     450+100,450+100};
      
      //Color Shade = new Color(200,20,60);
      g.setColor(shade.darker());
      g.drawPolygon(rect1cordsx, rect1cordsy, 4);//front rectangle
      g.fillPolygon(rect1cordsx, rect1cordsy, 4);


      
      
      int[] rect2cordsx = {100,100,129,129};
      
      int[] rect2cordsy = {450+100   ,0+increment,0+increment    ,420+100};
      
      //Color Shade2 = new Color(220,20,60);
      g.setColor(shade.brighter());
      
      g.drawPolygon(rect2cordsx, rect2cordsy, 4);//side rectangle
      g.fillPolygon(rect2cordsx, rect2cordsy, 4);
      
      for(int i = 0;i < this.height-20;i += 20)
      {
    	  for(int j = 0; j < this.width-increment;j+=20)
    	  {
    		  g.setColor(Color.yellow);
    		  g.draw3DRect(i+20, j+increment+10, 10, 10, true);
    		  g.fill3DRect(i+20, j+increment+10, 10, 10,true);
    	  }
      }
      
      
   }
   


   

   // Event to adjust the display.
   
   public void tick(Color bg) {

	background = bg;   
	   
	if (cState < states) {					// loop through the number of states
	   
		if ((states - cState) % 20 == 0) {
		
			if (cState < (states/2))			// adjust the color 
				shade = shade.brighter();
			else
				shade = shade.darker();
	   	
		}
		
	   	points.x += incrX;					// adjust the points
	   	points.y += incrY;
	   	if(incre < 100)
	   	{
	   		incre += 1;
	   	}
	   	else
	   	{
	   		incre = radius;
	   	}
	   
	   	cState++;							// track the loops
	   		   
		} else {
	   
	   
			incrX *= -1;					// return direction
			incrY *= -1;
	   
			cState = 0;						// reset the count
		}
	
		repaint();							// repaint the display
		System.out.println(incre);
		System.out.println("Increment to chage whatever x "+states);
		System.out.println("Increment to chage whatever y "+cState);


		
	}
   
   	public void bildsquare()
   	{
   		
   	}


}
   