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

public class MoonObj extends JPanel
{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Point points;		// define a list of points
	
	private static final int RED = 255;					// define gold color
	private static final int GREEN = 215;
	private static final int BLUE = 0;
	
	private int radius;								// size of the Sun
    private Color shade;
    private int states;		
 	private int cState;
 	
 	int incrX;
 	int incrY;

	private int incre;
	private int resetincre = this.radius;

   //-----------------------------------------------------------------
   //  constructor places the object and sets the number of states
   //-----------------------------------------------------------------
 	public MoonObj(int x, int y, int r, int fx, int fy, int stat)
 	{

 		
 		points = new Point();
	  
 		setBackground(Color.LIGHT_GRAY);
      
 		points.x = x;					// x coordinate
 		points.y = y;					// y coordinate            
 		radius = r;						// radius
 		
 		incrX = (fx - x)/stat;			// x increment
 		incrY = (fy - y)/stat;			// y increment
 		this.incre = r;
 		states = stat;		// number of states
 	
 	
 		cState = 0;
 		shade = new Color(RED,GREEN,BLUE);
 		
      
   }

   //-----------------------------------------------------------------
   //  Displays the mouse point locations, rectangle, and triangle
   //  input by the user.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {     
	  super.paintComponent (page);			// present the blank page

      page.setColor(Color.white);
	  page.drawOval(points.x - incre,points.y- radius, radius, radius);  
	  page.fillOval(points.x - incre,points.y- radius, radius, radius);
	  
      page.setColor (Color.LIGHT_GRAY);			// set the base color
	  page.drawOval(points.x - radius+5,points.y- radius, radius, radius);  
      page.fillOval(points.x - radius+5,points.y -radius, radius, radius);
      
 
 
   }

   

   // Event to adjust the display.
   
   public void tick() {

	if (cState < states) {					// loop through the number of states
	   
		if ((states - cState) % 10 == 0) {
		
			if (cState < (states/2))			// adjust the color 
				shade = shade.darker();
			else
				shade = shade.brighter();
	   	
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
		System.out.println("Increment to chage whatever x "+points.x);
		System.out.println("Increment to chage whatever y "+points.y);


		
	}


}
   