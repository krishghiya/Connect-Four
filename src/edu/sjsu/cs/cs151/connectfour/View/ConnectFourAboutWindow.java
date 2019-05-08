
/** ConnectFourAboutWindow.java
 * 
 * CS 151 Spring 2019
 * Professor Katarzyna Tarnowska
 * 
 * About window for Connect Four. 
 * 
 * @author Albert Ong
 * @since 24.04.2019
 */

package edu.sjsu.cs.cs151.connectfour.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;


public class ConnectFourAboutWindow extends JPanel {
  
  
  public ConnectFourAboutWindow(ConnectFourMainWindow parent) {
    
    // Sets the background color to white. 
    setBackground(Color.WHITE);
    
    // Adds the grid layout and sets the constraints. 
    GridBagLayout layout = new GridBagLayout();
    setLayout(layout);
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.insets = new Insets(0, 0, 20, 0);
    
    // Adds the about page text
    URL url = ConnectFourMainWindow.class.getResource("/resources/ConnectFourAboutWindow_text.png");
    JLabel text = new JLabel(new ImageIcon(url));
    add(text, gbc);
    
    // Creates the okay button. 
    JButton button = new JButton();
    button.setName("ABOUT_OKAY");
    button.setPreferredSize(new Dimension(400, 80));
    URL url_select = ConnectFourMainWindow.class.getResource("/resources/menu_button_okay_select.png");
    URL url_deselect = ConnectFourMainWindow.class.getResource("/resources/menu_button_okay_deselect.png");
    button.setIcon(new ImageIcon(url_deselect));
    button.setRolloverIcon(new ImageIcon(url_select));
    button.addActionListener(parent);
    
    // Makes the border and content of the button opaque. 
    button.setOpaque(false);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
    
    // Adds the okay button. 
    add(button, gbc);
    
    setVisible(true);
  }
}
