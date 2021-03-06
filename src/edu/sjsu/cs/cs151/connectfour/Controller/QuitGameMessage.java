package edu.sjsu.cs.cs151.connectfour.Controller;

/** QuitGameMessage.java
 * 
 * CS 151 Spring 2019
 * Professor Katarzyna Tarnowska
 * 
 * A Message for when the game is quit
 * See QuitGameValve for controller functionality
 * 
 * @author Holly Lind
 * @since 04.05.2019
 */
public class QuitGameMessage extends Message {
	
	public QuitGameMessage(boolean localGame) {
		this.localGame = localGame;
	}
	
	public boolean getLocalGame() {
		return localGame;
	}
	
	private boolean localGame;
}
