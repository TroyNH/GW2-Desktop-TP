package internalAssessment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

//This class will handle entering the first or new API keys, it will also check if an API key is valid, and store API keys if requested.
public class KeyEntry 
{
	//Constructor.
	public KeyEntry () throws IOException
	{
		//File writer for storing saved keys
		FileWriter filew = new FileWriter ("C:\\temp_Troy\\MySavedKeys.out");
		PrintWriter output = new PrintWriter(filew);
		
		//Frame to hold input text box and labels for clarification.
		JFrame keyEnter = new JFrame ();
		
		//Panels.
		JPanel labelHolder = new JPanel ();
		JPanel textHolder = new JPanel ();
		JPanel rememberKeyandConfirmHolder = new JPanel ();
		
		//Instructions.
		JLabel instruct = new JLabel ("Please enter your API key.");
		//Field for API key (72 characters)
		JTextField keyField = new JTextField (46);
		//ComboBox for list of user's saved keys.
		JComboBox rememberKey = new JComboBox ();
		//Checkbox to save key.
		JCheckBox rememberKeyBox = new JCheckBox ("Save my key.");
		//Confirm button.
		JButton confirmButton = new JButton ("Enter");
		
		//Restricts characters that can be entered to 72, the length of an API key.
		((AbstractDocument)keyField.getDocument ()).setDocumentFilter (new LimitFilter (72));
		
		//Adding components to their respective panels.
		labelHolder.add (instruct);
		textHolder.add (keyField);
		rememberKeyandConfirmHolder.add (rememberKey);
		rememberKeyandConfirmHolder.add (rememberKeyBox);
		rememberKeyandConfirmHolder.add (confirmButton);
		
		//Adding panels to frame.
		keyEnter.add (labelHolder, BorderLayout.NORTH);
		keyEnter.add (textHolder, BorderLayout.CENTER);
		keyEnter.add (rememberKeyandConfirmHolder, BorderLayout.SOUTH);
		
		//Open frame.
		keyEnter.setSize (WIDTH, HEIGHT);
		keyEnter.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		keyEnter.setResizable (false);
		keyEnter.setLocation (dim.width/2 - keyEnter.getSize().width/2, dim.height/2 - keyEnter.getSize().height);
		keyEnter.setVisible (true);
		
		//ActionListener for button.
		confirmButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent event)
			{
				if (rememberKeyBox.isSelected ())
				{
					
				}
				
				//Check API key supplied by user when ENTER button is clicked.
				@SuppressWarnings ("unused")
				Authenticate running = new Authenticate(keyField.getText());
			}
		});
		
		//KeyboardListener.
		keyField.addKeyListener (new KeyListener ()
		{
			@Override
			public void keyPressed (KeyEvent event)
			{
				if (event.getKeyCode() == KeyEvent.VK_ENTER)
				{
					//Check API key supplied by user when ENTER key is pressed.
					@SuppressWarnings ("unused")
					Authenticate running = new Authenticate(keyField.getText());
				}
			}

			@Override
			public void keyReleased (KeyEvent e) 
			{
				
			}

			@Override
			public void keyTyped (KeyEvent e) 
			{
				
			}
		});
		
		//Check for a new selection from the combo box
		rememberKey.addItemListener(new ItemListener ()
		{
			@Override
			public void itemStateChanged(ItemEvent event) 
			{
				if (event.getStateChange() == ItemEvent.SELECTED)
				{
					
				}
			}
			
		});
	}
	
	//Final variables.
	static final int WIDTH = 550;
	static final int HEIGHT = 150;
	static final Dimension dim = Toolkit.getDefaultToolkit ().getScreenSize ();
}
