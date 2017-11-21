package cityDisplay;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.util.ArrayList;

// Map of the object deployment in a GridBag implementation
//
// 

public class GridMap {

	public int HORIZONAL = 0;				// 	number of horizontal grids
	public int VERTICAL = 0;				//	number of vertical grids
	
	// Grid dimension values
	
	ArrayList<GridObject> gridmap = new ArrayList<GridObject>();
	
	
	public int[] hGrid;							// height increments
	public int[] wGrid;							// width increments
	public double[] hWt;						// height weights
	public double[] wWt;						// width weights
	
	public String[][] gridchart;				// object gridmap
	
	
	int ht;										// height work area
	int wd;										// width work area
	

	// constructor
	/**********************************************************************************
	 * 
	 * @param rows - number of rows in the grid
	 * @param cols - number of columns in the grid
	 * @param width - width of the screen in pixels or 0 if default
	 * @param height - height of the screen in pixels or 0 if default
	 */
	
	GridMap(int cols, int rows, int width, int height) {
		
		HORIZONAL = cols;					// save the rows
		VERTICAL = rows;					// save the columns
		
		Dimension screenSize = 					// get the screen dimensions
				Toolkit.getDefaultToolkit().getScreenSize();
		
		// use the default screen size if width = 0
		
		if (width == 0) 
			wd = screenSize.width;					// get the width
		else
			wd = width;
		
		// use the default screen height if height = 0
		
		if (height == 0)
			ht = screenSize.height;					// get the height
		else
			ht = height;
		
		System.out.println("Screen ht: " + ht + " width: " + wd);
		
		int hIncr = ht/VERTICAL-1;				// calculate the pixel increment less 1 for border
		int wIncr = wd/HORIZONAL-1;
		double hdIncr = (double) 1/VERTICAL;	// calculate the weight per column
		double wdIncr = (double) 1/HORIZONAL;	
				
		hGrid = new int[VERTICAL+1];			// build the height grid
		wGrid = new int[HORIZONAL+1];			// build the width grid
		hWt = new double[VERTICAL+1];			// build the height weight grid
		wWt = new double[HORIZONAL+1];			// build the width weight grid
		
		hGrid[0] = 0;							// initialze first element
		wGrid[0] = 0;
		hWt[0] = 0;
		wWt[0] = 0;	
		
		// create the horizonal pixel size and weight grids 
		
		for (int i = 1; i <= HORIZONAL; i ++) {	
			wGrid[i] = wGrid[i-1] + wIncr; 
			wWt[i] = wWt[i-1] + wdIncr;
		}
		
		// create the vertical pixel size and weight grids
		
		for (int i = 1; i <= VERTICAL; i++) {
			hGrid[i] = hGrid[i-1] + hIncr;
			hWt[i] = hWt[i-1] + hdIncr;
		}
		
		// crate the chart of objects in the gridbag design
		
		gridchart = new String[VERTICAL][HORIZONAL];
		
		// mark the grid entries empty
		
		for (int i = 0; i < VERTICAL; i++)
			for (int j = 0; j < HORIZONAL; j++) 
				gridchart[i][j] = "";
		
	}
	
	/**********************************************************************
	 * Add a new object into the Grid 
	 * 	 * 
	 * @param name	= name of the object as a String
	 * @param row = upper left column in the Grid relative to 0.
	 * @param col = upper left row in the grid relative to 0
	 * @param wide = width of the display in grids 1 - n
	 * @param high = height of the display in grids 1 - n
	 * @return = true if object successfully added.
	 */
	
	public boolean addObject(String name, int row, int col, int wide, int high) {
		
		if (row < 0 || row >= HORIZONAL) {
			
			System.out.println("Object: " + name + " row value: " + row 
					+ " outside of the Grid, bypassed!");
			return false;
			
		}
		
		if (col < 0 || col >= VERTICAL) {
			
			System.out.println("Object: " + name + " column value: " + col 
					+ " outside of the Grid, bypassed!");
			return false;
			
		}		
		
		if ((col + high) > VERTICAL) { 					// object extends outside of the grid?
			
			System.out.println("Vertical coordinates of " + name + " too big! Adjusting");
			high = (col + high) - VERTICAL;
			
		}
		
		if ((row + wide) > HORIZONAL) {					// object extends below the grid?
			
			System.out.println("Horizonal coordinates of " + name + " too big! Adjusting");
			wide = ((row + wide) - HORIZONAL);
			
		}
			
		// put the object name in the chart in the display location
		
		for (int i = col; i < (col + high); i++)
			for (int j = row; j < (row + wide);j++) {
				
				if (gridchart[i][j].contentEquals("")) 	// if empty, add the object			
					gridchart[i][j] = name;					
				else {
					System.out.println("Object conflict at row: " + i 
							+ " col: " + j + "\n" 
							+ "Occupied by object: " + gridchart[i][j] + ", bypassed!");
				return false;
				}
			}
		
		
		gridmap.add(new GridObject(name,row,col,wide,high));	// add the object to the grid
		
		return true;
	}
	
	// get the object constraints from the gridchart.
	
	public GridBagConstraints getConstraints(String name, GridBagConstraints g) {
		
		GridBagConstraints gbc = g;
		
		GridObject obj = searchObject(name);
		
		if (obj == null) {
			System.out.println("Could not retrieve constraints for: " + name);
			return gbc;
		}
		
		
		gbc.gridx = obj.row;
		gbc.gridy = obj.col;
		gbc.gridwidth = obj.hor;
		gbc.gridheight = obj.vert;
		gbc.weightx = wWt[obj.hor];
		gbc.weighty = hWt[obj.vert];				
		
		return gbc;
		
	}
	
	// get the object dimension from the gridchart.
	
	public Dimension getDimension(String name) {
		
			
		GridObject obj = searchObject(name);
		
		if (obj == null) 
			return (new Dimension());
		else {
			
			return (new Dimension(wGrid[obj.hor],hGrid[obj.vert]));
				
		}
		
		
	}
	
	// print out the gridchart for information
	
	public void printMap() {
		
		System.out.println("\n\t\t\t\tObject GridBox Map");
		
		System.out.print("\t\t\t");
		
		for (int i = 0; i < HORIZONAL; i++) 
			System.out.print(i + "\t");
		
		System.out.print("\n\tPixels\t\t");
		
		for (int i = 0; i < HORIZONAL; i++) {

			System.out.print(wGrid[i+1]+ "\t");
		}
		System.out.print("\n\t\tWeight\t");
		
		for (int i = 0; i < HORIZONAL; i++)
			
			System.out.printf("%1.2f\t" ,wWt[i+1]);
		
		System.out.println("");
		
		for (int i = 0; i < VERTICAL; i++) {

			System.out.print(i);
			
			System.out.print("\t" + hGrid[i+1] + "\t");
			System.out.printf("%1.2f  ", hWt[i+1]);
			System.out.print("\t");
			
			for (int j = 0; j < HORIZONAL; j++) {			
				
				System.out.print(gridchart[i][j] + "\t");
				
			}
			
			System.out.println("");
		}
		
	}
	
	
	
	
	// search the grid map for the object
	
	private GridObject searchObject(String name) {
		
		for (int i = 0; i < gridmap.size(); i++) {
			
			if (gridmap.get(i).object.contentEquals(name))
				
				return gridmap.get(i);
		}
		
		System.out.println("Could not find Object: " + name);
		
		return null;
			
			
	}
			
		
		
}
	

