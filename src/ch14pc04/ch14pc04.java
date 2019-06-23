package ch14pc04;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

/**
 * Applet that displays a thermometer by means of a slider object. 
 * When the slider is moved, the corresponding temperature is displayed 
 * in a text box.
 * 
 * @author frank
 */
public class ch14pc04 extends JApplet implements ChangeListener {
    // Components
    private Container container;
    private JPanel sliderPanel;
    private JPanel displayPanel;
    private JPanel titlePanel;
    
    private JSlider slider;
    private JLabel titleLabel;
    private JLabel tempLabel;
    private JTextField temp;
    
    
    /**
     * Initialize the applet
     */
    public void init () {
        
        container = getContentPane();
	container.setLayout (new BorderLayout ());

	// Instantiate the panels and GUI components
        titlePanel = new JPanel ();
	displayPanel = new JPanel ();
	sliderPanel = new JPanel ();
        
        // Instantiate the title and add it to the title panel
	titleLabel = new JLabel ("Move the slider to adjust the temperature.");
	titlePanel.add(titleLabel);
	
	// Instantiate the slider object and establish parameters
	slider = new JSlider (JSlider.VERTICAL, -50, 120, 70);
	slider.setMajorTickSpacing(10);
	slider.setMinorTickSpacing(5);
	slider.setPaintTicks(true);
	slider.setPaintLabels(true);

	// Add the changelistener to the slider
        slider.addChangeListener (this);
	sliderPanel.add(slider);
        
        // Instantiate the textfield and make it uneditable
	temp = new JTextField ("70", 2);
        temp.setEditable(false);
 	
        // Instanteate the temperature label and add it to the display panel
	tempLabel = new JLabel ("Degrees Fahrenheit");
	displayPanel.add(temp);
	displayPanel.add(tempLabel);
	

	// Add the panels to the container
        container.add(titlePanel, BorderLayout.NORTH);
	container.add(sliderPanel, BorderLayout.CENTER);
	container.add(displayPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Method to monitor the state change event
     * @param e 
     */
    public void stateChanged (ChangeEvent e) {
        
        temp.setText(Integer.toString(slider.getValue()));
   }
}
