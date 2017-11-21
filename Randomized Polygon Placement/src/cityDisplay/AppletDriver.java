package cityDisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AppletDriver extends JApplet implements ActionListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	private static Timer timer;
	
	private Color background;
	private boolean sw;
	
//	public Display grid;				// grid of dimensions ***
										// pixel dimensions for 
	
	public void init() {
		
		timer = new Timer(100, (ActionListener) this);		// set the timer for 1 second
		timer.setInitialDelay(100);		// start after 1 second
		timer.start();  // run the timer
		

		
        setPreferredSize(new Dimension(1450,1000));		
		
        setSize(1450,1000);
 
        background = Color.BLACK;
        sw = false;						// request a switch 1st time
 
        try {
			
			javax.swing.SwingUtilities.invokeAndWait(new Runnable()
			{
            public void run()
            {
                 createGUI();
            }
        });
    }
    catch (Exception e)
    {
        System.err.println("createGUI didn't successfully complete");
    }
}


	
private void createGUI()
{
//    Frame f = new Frame("GridBag Layout Example");
//    appletPanel jp = new appletPanel(background);
//
//
//    f.add("Center", jp);
//    f.pack();
//    f.setSize(f.getPreferredSize());
//    f.show();

//	appletPanel jp = new appletPanel(background);
	
     getContentPane().add(new appletPanel(background));
	
	

}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

	if (appletPanel.mun.sun) { 
	
		if (background != Color.LIGHT_GRAY) {
		
			background = Color.LIGHT_GRAY;
			sw = true;
		}
		
	} else {
		
		if (background != Color.BLACK) {
			background = Color.BLACK;
			sw = true;
		}
	}

	if (sw) {
		
		getContentPane().removeAll();
		getContentPane().add(new appletPanel(background));
		validate();
		setVisible(true);
		sw = false;
		
	}
	
		
	appletPanel.mun.tick(background);
	appletPanel.clock.tick(background);
	appletPanel.bul.tick(background);
	appletPanel.bul1.tick(background);
	appletPanel.bul2.tick(background);
	appletPanel.bul3.tick(background);
	appletPanel.bul4.tick(background);
	appletPanel.bul5.tick(background);
	appletPanel.bul6.tick(background);
	appletPanel.bul7.tick(background);
	appletPanel.bul8.tick(background);
	appletPanel.road.tick(background);
	
}
}
			

