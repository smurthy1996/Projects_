package cityDisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class appletPanel extends JPanel {
	


	/**
	 * 
	 */
	private static Random ran = new Random();
	
	private static GridMap grid = new GridMap(8,13,0,0);			// populate the grid of dimensions, assume full screen ***

	//public static Moon mun = new Moon(30, 0, 25, 680, 20, 400,Color.LIGHT_GRAY);
	public static Moon mun = new Moon(30, 10, 25, grid.wGrid[7]-100, 10, 300,Color.LIGHT_GRAY);	

	public static Clock clock = new Clock(35, 30, 40, 50, 250, 2, Color.LIGHT_GRAY);
	public static Building bul = new Building(grid.wGrid[2],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
//	public static Building bul = new Building(grid.hGrid[2],grid.wGrid[4],0,60, Color.LIGHT_GRAY);		
	public static Building bul1 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul2 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul3 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul4 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul5 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul6 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul7 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul8 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul9 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul10 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul11 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Building bul12 = new Building(grid.wGrid[1],grid.hGrid[8],Math.abs(ran.nextInt(grid.hGrid[8]/2)),60, Color.LIGHT_GRAY);	
	public static Grass grass1 = new Grass(grid.wGrid[1],grid.hGrid[1],60,Color.LIGHT_GRAY);
	public static Grass grass2 = new Grass(grid.wGrid[1],grid.hGrid[1],60,Color.LIGHT_GRAY);
	public static Grass grass3 = new Grass(grid.wGrid[1],grid.hGrid[1],60,Color.LIGHT_GRAY);
	public static Grass grass4 = new Grass(grid.wGrid[1],grid.hGrid[1],60,Color.LIGHT_GRAY);
	public static Grass grass5 = new Grass(grid.wGrid[1],grid.hGrid[1],60,Color.LIGHT_GRAY);
	public static Grass grass6 = new Grass(grid.wGrid[1],grid.hGrid[1],60,Color.LIGHT_GRAY);
	public static Grass grass7 = new Grass(grid.wGrid[1],grid.hGrid[1],60,Color.LIGHT_GRAY);
	public static Grass grass8 = new Grass(grid.wGrid[1],grid.hGrid[1],60,Color.LIGHT_GRAY);
	public static Road road = new Road(grid.wGrid[8],grid.hGrid[2], 60,Color.LIGHT_GRAY);		
	
	private static Color background;
		
	JButton but = new JButton("Click To hack the buildings");
	
	private static final long serialVersionUID = 1L;

	public appletPanel (Color bg) {
		

		grid.addObject("clock",7,0,1,2);
		grid.addObject("bul",0,2,2,8);
		grid.addObject("mun",0,0,7,2);	
		grid.addObject("bul1",2,2,1,8);
		grid.addObject("bul2",3,2,1,8);
		grid.addObject("bul3",4,2,1,8);
		grid.addObject("bul4",5,2,1,8);
		grid.addObject("bul5",6,2,1,8);
		grid.addObject("bul6",7,2,1,8);
		grid.addObject("bul7",8,2,1,8);
		grid.addObject("grass1",0,10,1,1);
		grid.addObject("grass2",1,10,1,1);		
		grid.addObject("grass3",2,10,1,1);		
		grid.addObject("grass4",3,10,1,1);		
		grid.addObject("grass5",4,10,1,1);		
		grid.addObject("grass6",5,10,1,1);		
		grid.addObject("grass7",6,10,1,1);	
		grid.addObject("grass8",7,10,1,1);
		grid.addObject("road",0,11,8,2);
				
		grid.printMap();
		

				
//		setBackground(Color.GRAY);		// need to change to bg *****
		

		GridBagLayout gridBag = new GridBagLayout();		
		GridBagConstraints gbc = new GridBagConstraints();				
	        
	    gbc.fill = GridBagConstraints.BOTH;
	        
	    JPanel panel = new JPanel();
	    panel.setLayout(gridBag);
		
		panel.setBackground(Color.WHITE);
		gbc.insets = new Insets(0,0,0,0);

		gbc.ipady = 0;
		gbc.ipadx = 0;
		
		// construct Moon panel
	
		gbc = grid.getConstraints("mun",gbc);
		mun.setPreferredSize(grid.getDimension("mun"));		
		panel.add(mun,gbc);
		
		// construct the Clock
		
		gbc = grid.getConstraints("clock",gbc);
		clock.setPreferredSize(grid.getDimension("clock"));
		panel.add(clock,gbc);

		// Construct the 7 building
		
		gbc = grid.getConstraints("bul", gbc);
		bul.setPreferredSize(grid.getDimension("bul"));
		panel.add(bul,gbc);
		

		gbc = grid.getConstraints("bul1", gbc);
		bul1.setPreferredSize(grid.getDimension("bul1"));		
		panel.add(bul1,gbc);
		
		gbc = grid.getConstraints("bul2", gbc);
		bul2.setPreferredSize(grid.getDimension("bul2"));		
		panel.add(bul2,gbc);

		gbc = grid.getConstraints("bul3", gbc);
		bul3.setPreferredSize(grid.getDimension("bul3"));		
		panel.add(bul3,gbc);
		
		gbc = grid.getConstraints("bul4", gbc);
		bul4.setPreferredSize(grid.getDimension("bul4"));		
		panel.add(bul4,gbc);
		
		gbc = grid.getConstraints("bul5", gbc);
		bul5.setPreferredSize(grid.getDimension("bul5"));		
		panel.add(bul5,gbc);

		gbc = grid.getConstraints("bul6", gbc);
		bul6.setPreferredSize(grid.getDimension("bul6"));		
		panel.add(bul6,gbc);

		// construct the grass objects
		
		gbc = grid.getConstraints("grass1",gbc);
		grass1.setPreferredSize(grid.getDimension("grass1"));
		panel.add(grass1,gbc);

		gbc = grid.getConstraints("grass2",gbc);
		grass2.setPreferredSize(grid.getDimension("grass2"));
		panel.add(grass2,gbc);
		
		gbc = grid.getConstraints("grass3",gbc);
		grass3.setPreferredSize(grid.getDimension("grass3"));
		panel.add(grass3,gbc);
		
		gbc = grid.getConstraints("grass4",gbc);
		grass4.setPreferredSize(grid.getDimension("grass4"));
		panel.add(grass4,gbc);
		
		gbc = grid.getConstraints("grass5",gbc);
		grass5.setPreferredSize(grid.getDimension("grass5"));
		panel.add(grass5,gbc);
		
		gbc = grid.getConstraints("grass5",gbc);
		grass5.setPreferredSize(grid.getDimension("grass5"));
		panel.add(grass5,gbc);
		
		gbc = grid.getConstraints("grass6",gbc);
		grass6.setPreferredSize(grid.getDimension("grass6"));
		panel.add(grass6,gbc);
		
		gbc = grid.getConstraints("grass7",gbc);
		grass1.setPreferredSize(grid.getDimension("grass7"));
		panel.add(grass7,gbc);

		gbc = grid.getConstraints("grass8",gbc);
		grass8.setPreferredSize(grid.getDimension("grass8"));
		panel.add(grass8,gbc);
		
		// construct the road object
		
		gbc = grid.getConstraints("road", gbc);
		road.setPreferredSize(grid.getDimension("road"));		
		panel.add(road,gbc);
	
		add(panel);		
	}
	
}
