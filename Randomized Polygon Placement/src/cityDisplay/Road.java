package cityDisplay;
//package SkyLine;


//********************************************************************
//  RubberLinesPanel.java       Author: Lewis/Loftus
// 								Modified by S.Murthy
//
//  Represents the Sun display object in the Office Panel.
//********************************************************************

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;
import javax.swing.*;

public class Road extends JPanel
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
	Image Jgrass,JCar;
	int width, height;

	private Color background;

	private int cmove = 0;

	private BufferedImage JCar3;

   //-----------------------------------------------------------------
   //  constructor places the object and sets the number of states
   //-----------------------------------------------------------------
 	public Road(int x, int y, int stat,Color bg)
 	{

 		  try {
 				Jgrass = ImageIO.read(new File("JGrass.png"));
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 		  try {
 				JCar = ImageIO.read(new File("JCar2.png"));
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}

 		background = bg;
 		points = new Point();  
 		setBackground(background);     
 		
 		width = x;
 		height = y;
 		points.x = 0;					// x coordinate
 		points.y = 0;					// y coordinate           
 		
// 		radius = r;						// radius
// 		incrX = (fx - x)/stat;			// x increment
// 		incrY = (fy - y)/stat;			// y increment
// 		this.incre = r;
 		states = stat;		// number of states
 		cState = 0;
 		shade = new Color(RED,GREEN,BLUE);
// 		vec = new Vector<Object>(100);
}

   //-----------------------------------------------------------------
   //  Displays the mouse point locations, rectangle, and triangle
   //  input by the user.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics g)
   {     
		 setBackground(Color.DARK_GRAY);

	  super.paintComponent (g);			// present the blank page

	 
	  g.setColor(Color.LIGHT_GRAY);
	  g.draw3DRect(0,height,width,height,false);
	  g.fill3DRect(0,height,width,height,false);
	  
      
	  for(int i = 0;i < width; i+=150)
	  {
		  g.setColor(Color.YELLOW);
		  g.draw3DRect(i,30,100,10,true);
		  g.fill3DRect(i,30,100,10,true);
	  }
		  
//	  g.drawImage(Jgrass, 0,20, this);


//	  g.setColor(Color.black);
//	  g.draw3DRect(0, 145, 2000, 50, true);
//	  g.fill3DRect(0, 145, 2000,  50, true);   
//	  
	  g.drawImage(JCar, width-cmove,  0,this);
	  //g.drawImage(JCar3, 0+this.cmove, -295,this);

   }


   

   // Event to adjust the display.
   
   public void tick(Color bg) {

		background = bg;

	if (cState < states) {					// loop through the number of states
	   
		if ((states - cState) % .5 == 0) {
		
			
				if(this.cmove < 2000)
				{
					cmove += 50;
				}
				else
				{
					cmove = 0;
				}
			}
		
//	   	points.x += incrX;					// adjust the points
//	   	points.y += incrY;
//	   	if(incre < 100)
//	   	{
//	   		incre += 1;
//	   	}
//	   	else
//	   	{
//	   		incre = radius;
//	   	}
//	   
	   	cState++;							// track the loops
	   		   
		} else {
	   
	   
//			incrX *= -1;					// return direction
//			incrY *= -1;
//	   
			cState = 0;						// reset the count
		}
	
		repaint();							// repaint the display
		this.validate();

		
	}


}