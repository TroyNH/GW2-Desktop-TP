package purmutations;

import javax.swing.text.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;

public class Permutated
{
	public static void main (String args [])
	{
		//Graphics!
		JFrame frame = new JFrame ();
		JPanel panel = new JPanel ();
		JPanel panel2 = new JPanel ();
		
		//Graphics!!
		JLabel dlabel = new JLabel ("To Be Permuted:");
		JTextField text = new JTextField (10);
		
		//Buttons!
		JButton go = new JButton ("Enter");
		JRadioButton radperm = new JRadioButton ("Permutation");
		JRadioButton radder = new JRadioButton ("Derangement");
		
		ButtonGroup bg = new ButtonGroup();
		
		//ActionsListener for button
		go.addActionListener(new ActionListener()
		{
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					frame.dispose();
					
					if (radperm.isSelected())
					{
						Permute doThing = new Permute (text.getText());
					}
					else if (radder.isSelected())
					{
						Derange doOtherThing = new Derange (text.getText());
					}
					else
					{
						System.out.println("Please make a selection.");
					}
				}
				
				catch (IOException e)
				{
					System.out.println(e);
				}
			}	
		});
		
		//Graphics!!!
		dlabel.setFont (new Font ("Dialog", Font.PLAIN, 20));
		text.setFont (new Font ("Dialog", Font.PLAIN, 20));
		go.setFont (new Font ("Dialog", Font.PLAIN, 20));
		
		//Establish character limit for JTextField
		((AbstractDocument)text.getDocument()).setDocumentFilter(new LimitFilter(10));
		
		//Button Group
		bg.add (radperm);
		bg.add (radder);
		
		//Graphics!!!!
		panel.add (dlabel);
		panel.add (text);
		
		//Graphics!!!!!
		panel2.add (radperm);
		panel2.add (radder);
		panel2.add (go);
		
		//GRAPHICS!
		frame.add (panel, BorderLayout.CENTER);
		frame.add (panel2, BorderLayout.SOUTH);
		
		//MORE GRAPHICS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		frame.setSize (WIDTH, HEIGHT);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setResizable (false);
		frame.setLocation (dim.width/2 - frame.getSize().width/2, dim.height/2 - frame.getSize().height);
		frame.setVisible (true);
	}

	//Final variables
	static final int WIDTH = 350;
	static final int HEIGHT = 125;
	static final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
}
