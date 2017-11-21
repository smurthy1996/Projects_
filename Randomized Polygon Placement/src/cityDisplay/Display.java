package cityDisplay;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

public class Display {

	final int HORIZONAL = 8;				// number of horizonal grids
	final int VERTICAL = 5;					// number of vertical grids
	
	// Grid dimension values
	
	ArrayList<GridMap> gridmap = new ArrayList<GridMap>();
	
	
	public int[] hGrid;							// height increments
	public int[] wGrid;							// width increments
	public double[] hWt;						// height weights
	public double[] wWt;							// width weights
	
	int ht;										// height work area
	int wd;										// width work area
	
	
	Display() {									// constructor
	

		
		
		Dimension screenSize = 					// get the screen dimensions
				Toolkit.getDefaultToolkit().getScreenSize();
		
		ht = screenSize.height;					// get the height
		wd = screenSize.width;					// get the width
		
		System.out.println("Screen ht: " + ht + " width: " + wd);
		
		int hIncr = ht/VERTICAL-1;				// calculate the pixel increment less 1 for border
		int wIncr = wd/HORIZONAL-1;
		double hdIncr = 1/VERTICAL;
		double wdIncr = 1/HORIZONAL;	
				
		hGrid = new int[VERTICAL+1];			// build the height grid
		wGrid = new int[HORIZONAL+1];			// build the width grid
		hWt = new double[VERTICAL+1];
		wWt = new double[HORIZONAL+1];
		
		hGrid[0] = 0;							// initialze first element
		wGrid[0] = 0;
		hWt[0] = 0;
		wWt[0] = 0;	
		
		for (int i = 1; i <= HORIZONAL; i ++) {
			wGrid[i] = wGrid[i-1] + wIncr; 
			wWt[i] = wWt[i-1] + wdIncr;
		}
		for (int i = 1; i <= VERTICAL; i++) {
			hGrid[i] = hGrid[i-1] + hIncr;
			hWt[i] = hWt[i-1] + hdIncr;
		}
		
		
	}
	
			
		
	
	
}
