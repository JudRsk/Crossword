package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Squares.AbstractSquare;
import Squares.BlueSquare;
import crosswordCode.Puzzle;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyBoard {

	private JFrame frame;
	private JPanel keyPanel;
		
	private String[][] symbols = {{"A", "Z", "E", "R", "T", "Y", "U", "I", "O", "P"}, 
			{"Q", "S", "D", "F", "G", "H", "J", "K", "L", "M"}, {"W", "X", "C", "V", "B", "N"}};
	
	private CrosswordButton crosswordButton;
	
	private char blueValue;
	//private char[] blueKeys;
	//no need to create 20+ separate listener objects
	private CustomButtonListener listen = new CustomButtonListener();
	
	public KeyBoard(String title, CrosswordButton crosswordButton) {
		this.frame = new JFrame(title);
		this.crosswordButton = crosswordButton;
		
		
		this.keyPanel = new JPanel();
		this.keyPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		if(crosswordButton.getSquare().getColor() == Color.BLUE) {
			BlueSquare blueSquare = (BlueSquare)crosswordButton.getSquare();
			blueValue = blueSquare.getBlueValue();
			}
		
		char[] blueKeys = new char[5];
		blueKeys = getBlueKeys(symbols);
		
		for(int i = 0; i<symbols.length; i++) {
			for(int x = 0; x < symbols[i].length; x++) {
			String symbol = symbols[i][x];
			JButton button = new JButton(symbol);
			if(crosswordButton.getSquare().getColor() == Color.BLUE) {
				button.setEnabled(false);
				for(int h = 0; h < blueKeys.length; h++) {
					if(symbol.charAt(0) == blueKeys[h]) {
					button.setEnabled(true);
					
					} 
				}
			} 
			button.addActionListener(listen);
			c.gridx = x;
			c.gridy = i;
			if (i ==2) {
				c.gridx = x +2;
				}
			keyPanel.add(button, c);
				}
			}
		
		
		/*int counter = 0;
		for (String symbol : this.firstSymbols) {
			JButton button = new JButton(symbol);
			button.addActionListener(listen);
			c.gridx = counter;
			c.gridy = 0;
			this.keyPanel.add(button, c);
			counter++;
		}
		
		counter = 0;
		for (String symbol : this.secondSymbols) {
			JButton button = new JButton(symbol);
			button.addActionListener(listen);
			c.gridx = counter;
			c.gridy = 1;
			this.keyPanel.add(button, c);
			counter++;
		}
		
		counter = 2;
		for (int i = 0; i <= 5; i++) {
			JButton button = new JButton(this.thirdSymbols[i]);
			button.addActionListener(listen);
			c.gridx = counter;
			c.gridy = 2;
			this.keyPanel.add(button, c);
			counter++;
		}
		*/
		
	
		frame.add(this.keyPanel, BorderLayout.PAGE_END);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	//get random characters
	public char[] getBlueKeys(String[][] symbols) {
		Random random = new Random();
		int i = 0;
		String s;
		char key;
		char[] keys = new char[1];
		while (i < 4) {
			int numberX = 0;
			int numberY = 0;
			numberX = random.nextInt(2);
			if (numberX == 2) {
				numberY = random.nextInt(6);
			} else {
				numberY = random.nextInt(10);
			}
			
			s = symbols[numberX][ numberY];
			key = s.charAt(0);
			keys[i] = key;
			keys = Arrays.copyOf(keys, i+2);
			i++;
		} 
		keys[4] = blueValue;
		
		return keys;
	}

	private class CustomButtonListener implements ActionListener {
 
		@Override
		public void actionPerformed(ActionEvent e) {
			String action = ((JButton)e.getSource()).getText();
			char c = action.charAt(0);
			crosswordButton.getSquare().setCharacter(c);
			crosswordButton.setText(action);
			frame.dispose();
			}
			
		}

}
		
	
	


