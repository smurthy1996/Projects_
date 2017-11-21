package cityDisplay;

//********************************************************************
//  RubberLinesPanel.java       Author: Lewis/Loftus
// 								Modified by S.Murthy
//
//  Represents the Sun display object in the Office Panel.
//********************************************************************

import java.awt.*;
import javax.swing.*;

public class SunObject extends JPanel
{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

   //-----------------------------------------------------------------
   //  constructor places the object and sets the number of states
   //-----------------------------------------------------------------
 	public SunObject(int x, int y, int r, int fx, int fy, int stat)
 	{


 		points = new Point();
	  
 
 		setBackground (Color.LIGHT_GRAY);
      
 		points.x = x;					// x coordinate
 		points.y = y;					// y coordinate            
 		radius = r;						// radius
 		
 		incrX = (fx - x)/stat;			// x increment
 		incrY = (fy - y)/stat;			// y increment
 		
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

      page.setColor (shade);			// set the base color
     

	  page.drawOval(points.x - radius,points.y- radius, radius, radius);  
      page.fillOval(points.x - radius,points.y -radius, radius, radius);
        
   }
   

   // Event to adjust the display.
   
   public void tick() {

	if (cState < states) {					// loop through the number of states
		
		points.x += incrX;					// adjust the points
	   	points.y += incrY;
	   
	   	cState++;							// track the loops
	   		   
		} else {
	   
	   
			incrX *= -1;					// return direction
			incrY *= -1;
	   
			cState = 0;						// reset the count
		}
	
		repaint();							// repaint the display
	}

}
   