package cityDisplay;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.concurrent.*;

import javax.swing.*;

public class GraphicsEngine extends JApplet implements ActionListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	private static Timer timer;
	private static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	private Color background;

	private boolean sw;

	public Display grid;
	
	public void init() {
		
		timer = new Timer(1, (ActionListener) this);		// set the timer for 1 second
		timer.setInitialDelay(0);		// start after 1 second
		timer.start();  					// run the timer		
        setPreferredSize(new Dimension(width,height));		
		
        grid = new Display();
        
        setSize(width,height);
        //this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        background = Color.blue;
        sw = true;						// request a switch 1st time
        
        
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
		//sets the number of threads appropriate to the # OF TASKS if there is only one task then it sets only one thread
		int numberOfTasks = 1;//sets # of tasks
			int batchSize = 2000;//sets the batch size for system to process the less the better, if greater than 2000 then you will get blue screen
			ExecutorService es = Executors.newFixedThreadPool(3);//sets the number of threads which is 3 in this case
			for (int i = 0; i < numberOfTasks; i += batchSize) {//loop thrue the batch size
			    final int start = i;//create a startubg point 
			    final int last = Math.min(i + batchSize, numberOfTasks);//get the last predicted set of loop
			    es.submit(new Runnable() {//submit the thread to the executor that is hanfeling the thread
			        @Override
			        public void run() {//override the run method in the runnable
			            for (int j = start; j < last; j++)//loop thru the # of tasks
			            {		            
			            	getContentPane().add(new appletPanel(background));//Task
			            }//end
			        }//end
			    });//end
			}//end
			
			Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
			Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
			//System.out.print(es.toString()+"\n");
			for(int i = 0;i < threadArray.length;i++)
			{
				//System.out.println(threadArray[i]);
			}
}

@Override
public void actionPerformed(ActionEvent arg0) {
	
	//this.actionPerformed(MouseClicked);
	
	int numberOfTasks = 1;//sets # of tasks
	int batchSize = 2000;//sets the batch size for system to process the less the better, if greater than 2000 then you will get blue screen
	ExecutorService es = Executors.newFixedThreadPool(3);//sets the number of threads which is 3 in this case
	for (int i = 0; i < numberOfTasks; i += batchSize) {//loop thrue the batch size
	    final int start = i;//create a startubg point 
	    final int last = Math.min(i + batchSize, numberOfTasks);//get the last predicted set of loop
	    es.submit(new Runnable() {//submit the thread to the executor that is hanfeling the thread
	        @Override
	        public void run() {//override the run method in the runnable
	            for (int j = start; j < last; j++)//loop thru the # of tasks
	            {		            
	            	if (appletPanel.mun.sun) { 
	            		
	            		if (background != Color.blue) {
	            		
	            			background = Color.blue;
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
	            }//end
	        }//end
	    });//end
	}//end
	

	
		
	appletPanel.mun.tick(background);
	//appletPanel.clock.tick(background);
	appletPanel.bul.tick(background);
	appletPanel.bul1.tick(background);
	appletPanel.bul2.tick(background);
	appletPanel.bul3.tick(background);
	appletPanel.bul4.tick(background);
	appletPanel.bul5.tick(background);
	appletPanel.bul6.tick(background);
	appletPanel.bul7.tick(background);
	appletPanel.bul8.tick(background);
	appletPanel.bul9.tick(background);
	appletPanel.bul10.tick(background);
	appletPanel.bul11.tick(background);
	appletPanel.bul12.tick(background);
	appletPanel.road.tick(background);
    }

}
			

