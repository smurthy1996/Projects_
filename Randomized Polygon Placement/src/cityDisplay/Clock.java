package cityDisplay;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;


import javax.swing.JPanel;

public class Clock extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Point center;		// Center of the circle
	
	
    int radius;								// size of the clock
    int left;								// left edge
    int top;								// top edge
    int degrees;							// degree variable
    
    double tickDegrees;

    int hourDegrees;						// hour hand degrees
    int minuteDegrees;						// minute hand degrees
    Double x1,y1,x2,y2;						// work areas
    
    Color background;
    
    boolean hour;							// indicates the hour moved.
 	
 	  //-----------------------------------------------------------------
    //  constructor places the object and sets the number of states
    //-----------------------------------------------------------------
  	public Clock(int x, int y, int r, int fx, int fy, double stat, Color bkg)
  	{

  		// x = left edge of clock
  		// y = top edge of clock
  		// r = radius of the clock
  		
  		center = new Point();
  		degrees = 360;
  		background = bkg;
  
  		setBackground (background);
  		left = x;
  		top = y;
  		center.x = x + r;					// x coordinate
  		center.y = y + r;					// y coordinate            
  		radius = r;						// radius
  		
  		if (60 % stat != 0) 
  			System.out.println("Tick minutes must be a multiple factor of 60!");
  		
  		
  		tickDegrees = (stat * 360)/60;				// tick Degrees
  		hourDegrees = 270;				// 6 oclock
  		minuteDegrees = 90;				// 12 am/pm
  		hour = false;
  		
        	
  	}
 	
    //-----------------------------------------------------------------
    //  Displays the clock
    //  input by the user.
    //-----------------------------------------------------------------
    public void paintComponent (Graphics page)
    {     
 	  
    	setBackground(background);
    	
    	Graphics2D comp2D = (Graphics2D) page;
    	
    	super.paintComponent (page);			// present the blank page

    	page.setColor (Color.WHITE);			// set the base color

    	// set the pen 
    	BasicStroke pen = new BasicStroke(5.0F, BasicStroke.CAP_BUTT, 
                BasicStroke.JOIN_BEVEL);
       
    	// start with black
    	comp2D.setColor(Color.BLACK);
    	comp2D.setStroke(pen);
    	comp2D.drawOval(left,top, 2*radius, 2*radius);
    	// change to white
    	comp2D.setColor(Color.WHITE);
    	comp2D.fillOval(left,top, 2*radius, 2*radius);
      
    	degrees = 0;
    	// back to black
    	comp2D.setColor(Color.BLACK);
    	
    	// paint the 5 minute marks on the clock face
    	
    	while (degrees < 360) {
    		
    		x1 = (double) getPoint(degrees,radius,1.0,center).x; 
    		y1 = (double) getPoint(degrees,radius,1.0,center).y;
    		x2 = (double) getPoint(degrees,radius,.9,center).x;
    		y2 = (double) getPoint(degrees,radius,.9,center).y;
    		
    		comp2D.draw(new Line2D.Double(x1,y1,x2,y2));
    		
    		degrees += 360/12;			// calculate 5 minute increments
    		    		
    	}
    	
    	// extract the points for the hour hand
    	
		x1 = (double) getPoint(hourDegrees,radius,.5,center).x; 
		y1 = (double) getPoint(hourDegrees,radius,.5,center).y;
		x2 = (double) getPoint(hourDegrees,radius,0,center).x;
		y2 = (double) getPoint(hourDegrees,radius,0,center).y;
		
		comp2D.draw(new Line2D.Double(x1,y1,x2,y2));  	
      
		// extract the points for the minute hand
      
		x1 = (double) getPoint(minuteDegrees,radius,.8,center).x; 
		y1 = (double) getPoint(minuteDegrees,radius,.8,center).y;
		x2 = (double) getPoint(minuteDegrees,radius,0,center).x;
		y2 = (double) getPoint(minuteDegrees,radius,0,center).y;
		
		comp2D.draw(new Line2D.Double(x1,y1,x2,y2));    
               
    }
    

    // Event to adjust the display.
    
    public void tick(Color bg) {

    	background = bg;
    	// increment to the next minute
    	minuteDegrees -= (minuteDegrees > 360 ? 0 : (minuteDegrees <= 0 ? -360 :
    			tickDegrees ));
    	
    	// increment to the next hour
    	
    	
    	if (minuteDegrees <= 90 && hour) {  				// at top of the hour?
    		
    	
    		if (hourDegrees <= 0) 					// are we at zero degrees
    			hourDegrees = 360 - 360/12;			// yes start at 360 again
    		else
    			hourDegrees -= 360/12;				// move to next hour
    	
    		hour = false;
    	}
    	
    	if (minuteDegrees > 90)
    		hour = true;
    	
 		repaint();							// repaint the display
 	}
	
 
    // method to get the point at a specified distance (as a percent) from the
    // center of a circle on a radius based on the angle (theta) of the
    // line in the circle.
    //
    // y = sin(theta) * radius 
    // x = cos(theta) * radius
    //
    // theta = angle in degrees
    // radius = radius of the circle
    // percent = percentage of the radius locating the point
    // x & Y coordinates of the center of the circle.
    
    private Point getPoint(int theta, int radius, double percent, Point center) {
    	
    	Point point = new Point(0,0);
    	
    	double radian = Math.toRadians(theta);
    	
    	point.y = center.y - (int) (Math.sin(radian) * (radius * percent) );
    	
    	point.x = center.x + (int) (Math.cos(radian) * (radius * percent) );
    	
    	return point;
    		
    }
    
    
    
}
