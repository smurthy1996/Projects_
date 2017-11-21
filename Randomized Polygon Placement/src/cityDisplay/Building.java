package cityDisplay;
//package SkyLine;


//********************************************************************
//  RubberLinesPanel.java       Author: Lewis/Loftus
// 								Modified by S.Murthy
//
//  Represents the Sun display object in the Office Panel.
//********************************************************************

import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Building extends JPanel
{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Point p1,p2,p3,p4,p5,p6,p7,p8;		// define a list of points
	
	private static final int RED = 255;					// define gold color
	private static final int GREEN = 0;
	private static final int BLUE = 0;
	private static Random ran = new Random();
	
//	private int radius;								// size of the Sun
    private Color shade;
    private int states;		
 	private int cState;    
 	int incrX;
 	int incrY;
 	Color shade2;
 	Color shade3;
	private int incre;
//	private int resetincre = this.radius;
	private int increment = 100;
 	private int width = 550 ,height = 100;
 	//private Color clr;
 	private Graphics g;
 	private int[][] wind;

	private int ye;

	private int ys;

	int hWindows, vWindows;
	int doorWidth;
	
	private Color backround;


   /*-----------------------------------------------------------------
   //  constructor places the object and sets the number of states
	
	Parameters:
		w = width of the panel
		h = height of the panel
		adj = dynamic adjustment
		stat = adjust value for upper y values
		clr = color
	
   //-----------------------------------------------------------------*/
 	public Building(int w, int h, int adj, int stat,Color clr)
 	{

 		backround = clr;
 		
 		p1 = new Point();			// upper left corner
 		p2 = new Point();			// lower left corner
 		p3 = new Point();			// upper right corner
 		p4 = new Point();			// lower left corner
 		p5 = new Point();			// upper right corner shadow
 		p6 = new Point();			// lower left corner shadow
 		p7 = new Point();

 		int widthAdj = ran.nextInt(20);
 		
 		
 		setBackground(Color.LIGHT_GRAY);
      
 		p1.x = 10 + widthAdj;		// upper left corner
 		p1.y = adj;					            

 		p2.x = 10 + widthAdj;		// lower left corner
 		p2.y = h;
 		
 		p3.x = w -15 - widthAdj ;	// upper right corner of building
 		p3.y = adj;
 		
 		p4.x = w -15 - widthAdj;	// lower right corner building
 		p4.y = h;
 		
 		p5.x = w - widthAdj ;		// upper right corner shadow
 		p5.y = adj;

 		p6.x = w - widthAdj;		// lower right corner shadow
 		p6.y = h;
 		
 		doorWidth = (p3.x - p1.x)/5;
 		
 		// dimensions for the entry door
 		
 
 		p7.x = (p3.x - p1.x)/2 + p1.x - doorWidth/2 ;		// upper left corner
 		p7.y = h - 20;
 		
 
 		
 		
 		
 		System.out.println("Width: "+ w);
 		System.out.println("Height: " + h);
 		System.out.println("Width adjust: " + widthAdj);
 		
 		System.out.println("P1: " + p1.x + "," + p1.y);
 		System.out.println("P2: " + p2.x + "," + p2.y);
 		System.out.println("P3: " + p3.x + "," + p3.y);
 		System.out.println("P4: " + p4.x + "," + p4.y);
 		System.out.println("P5: " + p5.x + "," + p5.y);
 		System.out.println("p6: " + p6.x + "," + p6.y);
 		System.out.println("P7: " + p7.x + "," + p7.y);
 
 		
 		vWindows = (p2.y - p1.y-50)/20;
 		hWindows = (p3.x - p1.x-15)/20;
 		
 		
 		System.out.println("vWindows: " + vWindows);
 		System.out.println("hWindows: " + hWindows + "\n");
 		// create locations of windows
 		

 		
	   	wind = new int[vWindows][hWindows];		// calculate 20 pixel windows
	   												// in the height of the structure
 		
 		for(int i = 0; i < vWindows;i++)
 		{
 			for(int j = 0;j < hWindows;j++)
 			{
 				wind[i][j] = 0;
 				//System.out.print(wind[i][j]);
 			}
 			
 		}

 			


 		// 		radius = r;						// radius
 		//this.clr = clr;
// 		incrX = (fx - x)/stat;			// x increment
// 		incrY = (fy - y)/stat;			// y increment
// 		this.incre = r;
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

	  this.setBackground(backround);



/*
      int[] xcords1 = {p7.x,p8.x,p9.x,p10.x};
      int[] ycords1 = {p7.y,p8.y,p9.y,p10.y};
      
      g.drawPolygon(xcords1,ycords1,4);
      g.setColor(shade.brighter());
      g.fillPolygon(xcords1,ycords1,4);
  */    
  

      // outline of the building
      
      int[] rect1cordsx = {p1.x,p2.x,p4.x,p3.x};
      
      int[] rect1cordsy = {p1.y,p2.y,p4.y,p3.y };
      
      
      g.setColor(shade.darker());
      g.drawPolygon(rect1cordsx, rect1cordsy, 4);//front rectangle
      g.fillPolygon(rect1cordsx, rect1cordsy, 4);


      // draw the shade
      
      int[] rect2cordsx = {p3.x,p4.x,p6.x,p5.x};
      
      int[] rect2cordsy = {p3.y,p4.y,p6.y,p5.y};
      
      //Color Shade2 = new Color(220,20,60);
      g.setColor(shade.brighter());
      
      g.drawPolygon(rect2cordsx, rect2cordsy, 4);//side rectangle
      g.fillPolygon(rect2cordsx, rect2cordsy, 4);
      
      
      // draw the windows
      
      
      g.setColor(Color.DARK_GRAY.darker());
      
      
      for(int i = 1 ;i <= vWindows ; i++)
      {
    	  
    	  for(int j = 1; j <= hWindows ;j++)
    	  {
    		  
    		  g.draw3DRect(p1.x + j*20, p1.y + i*20 , 12, 12, true);
    		  g.fill3DRect(p1.x + j*20, p1.y + i*20, 12, 12,true);
    		
    		  
 //   		  System.out.println("Window at: " + (p1.x + i*20) + "," + (p1.y + j*20));
    		  
    	  }
    	  
      }
      for(int i = 1;i <= vWindows;i++)
      {
    	  for(int j = 1; j <= hWindows;j++)
    	  {
 			    
    		  if(wind[(i-1)][j-1] == 1)
 	    		  {
 	    			g.setColor(shade2);
 	    		  	g.fill3DRect(p1.x + j*20, p1.y + i*20, 12, 12,true);
 	    		  }
  
    	  
    	  }
   		
    	 }
   

      
	  g.setColor(Color.LIGHT_GRAY);
      g.draw3DRect(p7.x, p7.y, doorWidth, 20, true);
      g.fill3DRect(p7.x, p7.y, doorWidth, 20, true);
      
    
      
   }
   


   

   // Event to adjust the display.
   
   public void tick(Color bg) {
	   
	   backround = bg;

	if (cState < states) {					// loop through the number of states
	   
		if ((states - cState) % 20 == 0) {
		
			if (cState < (states/2))			// adjust the color 
			{
				shade = shade.brighter();
				ys = ran.nextInt(vWindows);

	    	  	ye = ran.nextInt(hWindows);

	    		 wind[ys][ye] = 1;
	    		 shade2 = Color.yellow;
			}
				
			else
			{
				shade = shade.darker();


				
			}

	   	
		}
		
//	   	points.x += incrX;					// adjust the points
//	   	points.y += incrY;
	   	if(incre < 100)
	   	{
	   		incre += 1;
	   	}
	   	else
	   	{
//	   		incre = radius;
	   	}
	   
	   	cState++;							// track the loops
	   		   
		} else {
	   
	   
			incrX *= -1;					// return direction
			incrY *= -1;
	   
			cState = 0;						// reset the count
		}
	
		repaint();							// repaint the display



		
	}
	//@Override




}
   