package cityDisplay;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;



import javax.imageio.ImageIO;
import javax.swing.*;
	
public class Grass extends JPanel {


	
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
	 	public Grass(int x, int y, int stat,Color bg)
	 	{

	 		  try {
	 				Jgrass = ImageIO.read(new File("JGrass.png"));
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
	 		
//	 		radius = r;						// radius
//	 		incrX = (fx - x)/stat;			// x increment
//	 		incrY = (fy - y)/stat;			// y increment
//	 		this.incre = r;
	 		states = stat;		// number of states
	 		cState = 0;
	 		shade = new Color(RED,GREEN,BLUE);
//	 		vec = new Vector<Object>(100);
	}

	   //-----------------------------------------------------------------
	   //  Displays the mouse point locations, rectangle, and triangle
	   //  input by the user.
	   //-----------------------------------------------------------------
	   public void paintComponent (Graphics g)
	   {     
			 setBackground(background);

		  super.paintComponent (g);			// present the blank page

		 

			  
		  g.drawImage(Jgrass, 0, 0,width,height,
				  0, 0, 337, 211, this);



	   }


	   

	   // Event to adjust the display.
	   
	   public void tick(Color bg) {

			background = bg;

		if (cState < states) {					// loop through the number of states
		   
	
//		   
		   	cState++;							// track the loops
		   		   
			} else {
		   
		   

				cState = 0;						// reset the count
			}
		
			repaint();							// repaint the display
			this.validate();

			
		}

}
