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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

//This class will handle entering the first or new API keys, it will also check if an API key is valid, and store API keys if requested.
public class KeyEntry 
{
	String api_info;
	String api_key;
	
	//Constructor.
	public KeyEntry () throws IOException
	{	
		//For file input
		FileReader filew = new FileReader ("C://temp_troy//MySavedKeys.txt");
		BufferedReader inp = new BufferedReader (filew);
		
		//Key saver object
		SaveKeys saver = new SaveKeys ();
		
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
		JComboBox <String> rememberKey = new JComboBox <String> ();
		
		rememberKey.addItem("Select Saved Key");
		
		String keyLine = inp.readLine();
		
		ArrayList <KeyCaller> keyInfo = new ArrayList <KeyCaller> ();
		
		while (keyLine != null)
		{
			JsonReader read = Json.createReader (new StringReader (keyLine));
			JsonObject keyObject = read.readObject();
			
			read.close();
			
			rememberKey.addItem (keyObject.getString ("name"));
			
			keyInfo.add (new KeyCaller (keyObject.getString ("name"), keyObject.getString ("key")));
			
			keyLine = inp.readLine();
		}
		
		inp.close();
		
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
		keyEnter.setLocation (dim.width/2 - keyEnter.getSize().width/2, dim.height/2 - keyEnter.getSize().height/2);
		keyEnter.setVisible (true);
		
		//ActionListener for button.
		confirmButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent event)
			{
				CallRequests call = new CallRequests ();
				
				api_key = keyField.getText();
				
				try 
				{
					String response = call.makerequest ("https://api.guildwars2.com/v2/tokeninfo?access_token=" + api_key);
					api_info = response;
				} 
				catch (IOException e) 
				{
					JOptionPane.showMessageDialog (null, "We ran into an issue when attempting to authenticate your key, this could mean you entered an invalid key or that your computer could not connect to ArenaNet's servers.\n"
					+ "Please make sure your key is correct and you are still connected to the internet.", "Problem with API Key", JOptionPane.ERROR_MESSAGE);
				}
				
				if (rememberKeyBox.isSelected ())
				{
					try 
					{
						saver.save (api_info,  api_key);
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
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
					CallRequests call = new CallRequests ();
					
					api_key = keyField.getText ();
					
					try 
					{
						String response = call.makerequest ("https://api.guildwars2.com/v2/tokeninfo?access_token=" + api_key);
						api_info = response;
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					
					if (rememberKeyBox.isSelected ());
					{
						try 
						{
							saver.save (api_info, api_key);
						} 
						catch (IOException e) 
						{
							e.printStackTrace();
						}
					}
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
					int index = rememberKey.getSelectedIndex() - 1;
					
					if (index > -1)
					{
						keyField.setText (keyInfo.get (index).getKey());
					}
					else if (index == -1)
					{
						keyField.setText ("");
					}
					
				}
			}
			
		});
	}
	
	//Final variables.
	static final int WIDTH = 550;
	static final int HEIGHT = 150;
	static final Dimension dim = Toolkit.getDefaultToolkit ().getScreenSize ();
}
