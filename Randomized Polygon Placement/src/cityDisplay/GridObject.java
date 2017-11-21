	
package cityDisplay;

/*****************************************************************************
 * 
 * @author 
 *
 *	Class to represent a display object's characteristic
 *
 *
 */

public class GridObject {
	
	public String object;				// object name
	public int row;						// starting grid row, 0 - n
	public int col;						// starting grid column, 0 - n
	public int hor;						// Horizontal grids
	public int vert;					// vertical grids
	
	
	GridObject (String n, int r, int c, int h, int v) {
		
		object = n;						// object name
		row = r;						// grid row number
		col = c;						// grid column number
		hor = h;						// weight in grids
		vert = v;						// height in grids
		
	}

}
