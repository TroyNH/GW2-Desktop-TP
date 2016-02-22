package internalAssessment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TPMain
{
	public TPMain ()
	{	
		//Frame, it holds things.
		JFrame metaFrame = new JFrame ();
		
		//Panel
		JPanel tabPanel = new JPanel (new GridBagLayout ());
		
		int padx = 80;
		int pady = 100;
		
		//Tabs, many tabs, GridBagLayouts are gross but SOOOO GOOD.
		GridBagConstraints a = new GridBagConstraints ();
		a.fill = GridBagConstraints.BOTH;
		a.gridx = 0;
		a.gridy = 0;
		a.ipady = pady;
		a.ipadx = padx;
		JButton profileButton = new JButton ();
		profileButton.setToolTipText ("Profile");
		tabPanel.add (profileButton, a);
		
		GridBagConstraints b = new GridBagConstraints ();
		b.fill = GridBagConstraints.BOTH;
		b.gridx = 0;
		b.gridy = 1;
		b.ipady = pady;
		b.ipadx = padx;
		JButton tpButton = new JButton ();
		tpButton.setToolTipText ("Trading Post");
		tabPanel.add (tpButton, b);
		
		GridBagConstraints c = new GridBagConstraints ();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = pady;
		c.ipadx = padx;
		JButton buyButton = new JButton ();
		buyButton.setToolTipText ("Buy");
		tabPanel.add (buyButton, c);
		
		GridBagConstraints d = new GridBagConstraints ();
		d.fill = GridBagConstraints.BOTH;
		d.gridx = 0;
		d.gridy = 3;
		d.ipady = pady;
		d.ipadx = padx;
		JButton sellButton = new JButton ();
		sellButton.setToolTipText ("Sell");
		tabPanel.add (sellButton, d);
		
		GridBagConstraints e = new GridBagConstraints ();
		e.fill = GridBagConstraints.BOTH;
		e.weightx = 0.5;
		e.weighty = 0.5;
		e.gridx = 0;
		e.gridy = 4;
		e.ipady = 100;
		JButton dummyButton = new JButton ();
		tabPanel.add (dummyButton, e);
		
		//Dummy Button
		dummyButton.setEnabled(false);
		
		//Action Listeners for switching tabs
		profileButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e) 
			{
				CardLayout cl = (CardLayout) metaPanel.getLayout ();
				cl.show (metaPanel, "profile");
			}
		});
		
		tpButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e)
			{
				CardLayout cl = (CardLayout) metaPanel.getLayout ();
				cl.show (metaPanel, "trade");
			}
		});
		
		buyButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e)
			{
				CardLayout cl = (CardLayout) metaPanel.getLayout ();
				cl.show (metaPanel, "buy");
			}
		});
		
		sellButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e)
			{
				CardLayout cl = (CardLayout) metaPanel.getLayout ();
				cl.show (metaPanel, "sell");
			}
		});
		
		//Set up each tab
		profile ();
		tradePost ();
		buyPanel ();
		sellPanel ();
		
		//BUILD!!
		metaFrame.add (tabPanel, BorderLayout.WEST);
		metaFrame.add (metaPanel, BorderLayout.CENTER);
		metaFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		metaFrame.setResizable (true);
		metaFrame.setSize (WIDTH, HEIGHT);
		metaFrame.setLocation (dim.width/2 - metaFrame.getSize().width/2, dim.height/2 - metaFrame.getSize().height/2);
		metaFrame.setVisible (true);
	}
	
	//Profile Tab
	public void profile ()
	{
		JPanel profilePane = new JPanel (new GridBagLayout ());
		
		JLabel accName = new JLabel ("Account Name:");
		JLabel acaccName = new JLabel ("yorTman.3512");
		JLabel keyName = new JLabel ("API Key:");
		JLabel key = new JLabel ("8B4CE529-55CD-114E-B27A-AB75CC2650C3A4B2B178-C268-41D4-A685-B21DC069DFDD");
		
		accName.setHorizontalAlignment (SwingConstants.CENTER);
		acaccName.setHorizontalAlignment (SwingConstants.CENTER);
		keyName.setHorizontalAlignment (SwingConstants.CENTER);
		key.setHorizontalAlignment (SwingConstants.CENTER);
		
		accName.setFont (profileFont);
		acaccName.setFont (profileFont);
		keyName.setFont (profileFont);
		key.setFont (profileFont);
		
		GridBagConstraints a = new GridBagConstraints ();
		a.fill = GridBagConstraints.HORIZONTAL;
		a.weightx = 0.1;
		a.gridx = 0;
		a.gridy = 0;
		profilePane.add(accName, a);
		
		GridBagConstraints b = new GridBagConstraints ();
		b.fill = GridBagConstraints.HORIZONTAL;
		b.weightx = 0.1;
		b.gridx = 0;
		b.gridy = 1;
		b.insets = new Insets (0, 0, 10, 0);
		profilePane.add (acaccName, b);
		
		GridBagConstraints c = new GridBagConstraints ();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets (10, 0, 0, 0);
		profilePane.add (keyName, c);
		
		GridBagConstraints d = new GridBagConstraints ();
		d.fill = GridBagConstraints.HORIZONTAL;
		d.weightx = 0.1;
		d.gridx = 0;
		d.gridy = 3;
		profilePane.add (key, d);
		
		metaPanel.add (profilePane, "profile");
	}
	
	//Trade tab
	public void tradePost ()
	{
		JPanel tradePane = new JPanel (new BorderLayout ());
		JPanel buttonBar = new JPanel (new GridBagLayout ());
		
		int buttonPadding = 115;
		
		//Tabs, many tabs, GridBagLayouts are gross but SOOOO GOOD.
		GridBagConstraints a = new GridBagConstraints ();
		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.gridx = 0;
		a.gridy = 0;
		a.ipady = buttonPadding;
		JButton armor = new JButton ("A");
		buttonBar.add (armor, a);
		
		GridBagConstraints b = new GridBagConstraints ();
		b.fill = GridBagConstraints.BOTH;
		b.weightx = 0.1;
		b.weighty = 0.1;
		b.gridx = 1;
		b.gridy = 0;
		b.ipady = buttonPadding;
		JButton weapons = new JButton ("W");
		buttonBar.add (weapons, b);
		
		GridBagConstraints c = new GridBagConstraints ();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.1;
		c.weighty = 0.1;
		c.gridx = 2;
		c.gridy = 0;
		c.ipady = buttonPadding;
		JButton upgrades = new JButton ("U");
		buttonBar.add (upgrades, c);
		
		GridBagConstraints d = new GridBagConstraints ();
		d.fill = GridBagConstraints.BOTH;
		d.weightx = 0.1;
		d.weighty = 0.1;
		d.gridx = 3;
		d.gridy = 0;
		d.ipady = buttonPadding;
		JButton skins = new JButton ("S");
		buttonBar.add (skins, d);
		
		GridBagConstraints e = new GridBagConstraints ();
		e.fill = GridBagConstraints.BOTH;
		e.weightx = 0.1;
		e.weighty = 0.1;
		e.gridx = 4;
		e.gridy = 0;
		e.ipady = buttonPadding;
		JButton	crafting = new JButton ("C");
		buttonBar.add (crafting, e);
		
		GridBagConstraints f = new GridBagConstraints ();
		f.fill = GridBagConstraints.BOTH;
		f.weightx = 0.1;
		f.weighty = 0.1;
		f.gridx = 5;
		f.gridy = 0;
		f.ipady = buttonPadding;
		JButton other = new JButton ("O");
		buttonBar.add (other, f);
		
		tradePane.add (buttonBar, BorderLayout.NORTH);
		
		metaPanel.add (tradePane, "trade");
	}
	
	//Buy tab
	public void buyPanel ()
	{
		JPanel buyPane = new JPanel (new BorderLayout ());
		JPanel buttonBar = new JPanel (new GridBagLayout ());
		
		int buttonPadding = 115;
		
		//Tabs, many tabs, GridBagLayouts are gross but SOOOO GOOD.
		GridBagConstraints a = new GridBagConstraints ();
		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.gridx = 0;
		a.gridy = 0;
		a.ipady = buttonPadding;
		JButton current = new JButton ("C");
		buttonBar.add (current, a);
		
		GridBagConstraints b = new GridBagConstraints ();
		b.fill = GridBagConstraints.BOTH;
		b.weightx = 0.1;
		b.weighty = 0.1;
		b.gridx = 1;
		b.gridy = 0;
		b.ipady = buttonPadding;
		JButton past = new JButton ("P");
		buttonBar.add (past, b);
		
		buyPane.add (buttonBar, BorderLayout.NORTH);
		
		metaPanel.add (buyPane, "buy");
	}
	
	//Sell tab
	public void sellPanel ()
	{
		JPanel sellPane = new JPanel (new BorderLayout ());
		JPanel buttonBar = new JPanel (new GridBagLayout ());
		
		int buttonPadding = 115;
		
		//Tabs, many tabs, GridBagLayouts are gross but SOOOO GOOD.
		GridBagConstraints a = new GridBagConstraints ();
		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.gridx = 0;
		a.gridy = 0;
		a.ipady = buttonPadding;
		JButton current = new JButton ("C");
		buttonBar.add (current, a);
		
		GridBagConstraints b = new GridBagConstraints ();
		b.fill = GridBagConstraints.BOTH;
		b.weightx = 0.1;
		b.weighty = 0.1;
		b.gridx = 1;
		b.gridy = 0;
		b.ipady = buttonPadding;
		JButton past = new JButton ("P");
		buttonBar.add (past, b);
		
		sellPane.add (buttonBar, BorderLayout.NORTH);
		
		metaPanel.add (sellPane, "sell");
	}
	
	//The panel that holds 4 other panels, the metaPanel/Panelception
	static final JPanel metaPanel = new JPanel (new CardLayout ());
	
	//Some boring stuff
	static final int WIDTH = 1000;
	static final int HEIGHT = 700;
	static final Dimension dim = Toolkit.getDefaultToolkit ().getScreenSize ();
	
	//FONTS
	Font profileFont = new Font ("Consolas", Font.PLAIN, 20);
}
