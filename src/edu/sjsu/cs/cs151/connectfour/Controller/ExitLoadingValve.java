package edu.sjsu.cs.cs151.connectfour.Controller;

import edu.sjsu.cs.cs151.connectfour.View.View;

/** ExitLoadingValve.java
 * 
 * CS 151 Spring 2019
 * Professor Katarzyna Tarnowska
 * 
 * A Valve used when clicking the exit button on the loading panel
 * 
 * @author Holly Lind
 * @since 09.05.2019
 */
public class ExitLoadingValve implements Valve {

	
	public ExitLoadingValve(View view) {
		this.view = view;
	}
	
	
	public ValveResponse execute(Message message) {
		if (message.getClass() != ExitLoadingMessage.class)
			return ValveResponse.MISS;

		//actions in model - none
		
		//actions in view
		//close server - ??????????
		((ExitLoadingMessage) message).toClose.closeConnection();
		
		//replace loading panel with menu
		view.replacePanel(view.getLoadingPanel(), view.getMenuPanel());
		
		return ValveResponse.EXECUTED;
	}

	
	private View view;
}