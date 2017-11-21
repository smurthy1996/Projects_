package cityDisplay;
//package SkyLine;


//********************************************************************
//  RubberLinesPanel.java       Author: Lewis/Loftus
// 								Modified by S.Murthy
//
//  Represents the Sun display object in the Office Panel.
//********************************************************************

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class MoonObj2 extends JPanel
{
   

	private static final long serialVersionUID = 1L;

	private Point moonPoints;		// define a list of points

	private static final int moonRED = 255;					// define gold color
	private static final int moonGREEN = 215;
	private static final int moonBLUE = 0;
	
	private int moonRadius;								// size of the Sun
    private Color moonShade;
    private int moonStates;		
 	private int mooncState;
 	private Color background;
 	
 	int moonIncrX;
 	int moonIncrY;

 	int StartX;
 	int StartY;
 	
	private int incre;
	
	private Point points;		// define a list of points
	
	private static final int RED = 255;					// define gold color
	private static final int GREEN = 255;
	private static final int BLUE = 0;
	
    int radius;								// size of the Sun
    Color shade;
 	int states;		
 	int cState;
 	
 	int incrX;
 	int incrY;

 	public char direction;
 	public boolean sun;
 
//	private Color Light_Grey;

	//-----------------------------------------------------------------
   //  constructor places the object and sets the number of states
   //-----------------------------------------------------------------
 	public MoonObj2(int x, int y, int r, int fx, int fy, int stat,Color bkg)
 	{

 		StartX = x;
 		StartY = y;
 		
 		moonPoints = new Point();
 		background = bkg;
 		setBackground(background);
      
 		moonPoints.x = x;					// x coordinate
 		moonPoints.y = y;					// y coordinate            
 		moonRadius = r;						// moonRadius

 		moonIncrX = (fx - x)/stat;			// x increment
 		moonIncrY = (fy - y)/stat;			// y increment
 		incre = 0;
 //		moonStates = stat;
 		moonStates = (fx - x) / moonIncrX;		// number of states
 	
 	
 		mooncState = 0;
 		moonShade = new Color(moonRED,moonGREEN,moonBLUE);
 		
 		direction = 'r';
 		
		points = new Point();
		  
		 
 		setBackground ( background);
      
 		points.x = x;					// x coordinate
 		points.y = y;					// y coordinate            
 		radius = r;						// radius
 		
 		incrX = (fx - x)/stat;			// x increment
 		incrY = (fy - y)/stat;			// y increment
 		
 		states = (fx - x)/incrX;		// number of states
 	
 	
 		cState = 0;
 		shade = new Color(RED,GREEN,BLUE);
 		
 		sun = true;
 		    
   }

 	private void doDrawing(Graphics g) {
 		
 		setBackground(background);
 		
 		Graphics2D g2d = (Graphics2D) g;

 	      g2d.setColor(Color.white);
 	      
  	     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
	    		  (!sun? 10 : 0) * 0.1F));
	 	      
 		  g2d.drawOval(moonPoints.x,moonPoints.y, 2*moonRadius, 2*moonRadius);  
 		  g2d.fillOval(moonPoints.x,moonPoints.y, 2*moonRadius, 2*moonRadius);
 		  
 	      g2d.setColor (background);			// set the base color
 		  g2d.drawOval(moonPoints.x +incre,moonPoints.y, 2*moonRadius, 2*moonRadius);  
 	      g2d.fillOval(moonPoints.x +incre,moonPoints.y, 2*moonRadius, 2*moonRadius);
 	         		
 		
 		
 	     g2d.setColor (shade);			// set the base color
 	      
 	     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
 	    		  (sun? 10: 0) * 0.1F));
 	 

 	 	  g2d.drawOval(points.x,points.y, 2*radius, 2*radius);  
 	      g2d.fillOval(points.x,points.y, 2*radius, 2*radius);
 	         	
 		
 		
 	}
 	
 	
 	
 	
 	
   //-----------------------------------------------------------------
   //  Displays the mouse point locations, rectangle, and triangle
   //  input by the user.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {     
	  super.paintComponent (page);			// present the blank page
      
      doDrawing(page);						// insert the objects
 
   }

   

   // Event to adjust the display.
   
   public void tick(Color bg) {

	background = bg;   
	   
	if (mooncState < moonStates) {					// loop through the number of moonStates
	   
//		if ((moonStates - mooncState) % 10 == 0) {
//
//		
//			if (mooncState < (moonStates/2))			// adjust the color 
//				moonShade = moonShade.darker();
//			else
//				moonShade = moonShade.brighter();
//	   	
//		}
		
		if((moonStates - mooncState) % 25 == 0)
		{

			
			
			incre += (direction == 'r' ? 1 : -1);
			
			if (incre > 2*moonRadius + 5) 
				direction = 'l';
			if (incre < 1)
				direction = 'r';
			
		   	
	
		}
		
	   	moonPoints.x += moonIncrX;					// adjust the moonPoints
	   	moonPoints.y += moonIncrY;

	   
	   	mooncState++;							// track the loops
	   		   
		} else {
	   
	   
			moonPoints.x = StartX;
			moonPoints.y = StartY;
	   
			mooncState = 0;						// reset the count
			
			sun = (sun? false : true);
		}
	
//		repaint();							// repaint the display
//		System.out.println(incre);
//		System.out.println("Increment to chage whatever x "+this.moonStates);
//		System.out.println("Increment to chage whatever y "+this.mooncState);
//

		
	
	if (cState < states) {					// loop through the number of states
		
		points.x += incrX;					// adjust the points
	   	points.y += incrY;
	   
	   	cState++;							// track the loops
	   		   
		} else {
	   
			
	   
			points.x = StartX;				// reset the direction
			points.y = StartY;
	   
			cState = 0;						// reset the count
		
		}
	
		repaint();							// repaint the display
	}


}
   