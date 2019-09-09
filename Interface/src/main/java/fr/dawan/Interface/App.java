package fr.dawan.Interface;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

/**
 * Hello world!
 *
 */
public class App extends JFrame
{
	public App() {
		
		JComboBox comboBox = new JComboBox();
		getContentPane().add(comboBox, BorderLayout.CENTER);
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
