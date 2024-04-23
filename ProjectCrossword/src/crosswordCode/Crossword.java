package crosswordCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Squares.*;
import gui.CrosswordButton;
import gui.KeyBoard;

public class Crossword {

	private JFrame frame;	
	
	public Crossword(Puzzle crosswordPuzzle, SolutionPuzzle solPuzzle) {
		this.frame = new JFrame("Swedish-style crossword puzzle");

		//make first panel with crossword puzzle instructions
		JPanel panel1 = new JPanel(); 
		JLabel label1 = new JLabel();
		
		ArrayList<String> paneeltext = crosswordPuzzle.getPanel();
		panel1.setLayout(new GridLayout(paneeltext.size()+1, 1));
		label1.setText("Crossword puzzle instructions: ");
		panel1.add(label1);
		for (String text: paneeltext) {
			JLabel label2 = new JLabel(text, JLabel.LEFT);
			panel1.add(label2);
		}
		
		//make second panel with crossword 
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(crosswordPuzzle.getWidth(), crosswordPuzzle.getHeight()));
		
		ArrayList<AbstractSquare> squaresPanel = crosswordPuzzle.getSquares();
		for (int i = 0; i < squaresPanel.size(); i++) {
			CrosswordButton button = new CrosswordButton(squaresPanel.get(i));
			Color color = squaresPanel.get(i).getColor();
			button.setBackground(color);
			button.setBorder(BorderFactory.createLineBorder(color.BLACK));
			if (color == Color.WHITE || color == Color.GRAY || (color == Color.BLUE)) {
				button.addActionListener(new ComputeActionListener());
			}
			
			panel2.add(button);
			
		}
				
		//make third panel with the solution puzzle and check button
		JPanel panel3 = new JPanel();		
		JButton check = new JButton("Check");
		
		ArrayList<CheckSquare> checkPanel = solPuzzle.getCheck();
		panel3.setLayout(new GridLayout(1, checkPanel.size()));
		for (int i = 0; i < checkPanel.size(); i++) {
			CrosswordButton button = new CrosswordButton(checkPanel.get(i));
			Color color = checkPanel.get(i).getColor();
			button.setBackground(color);
			button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			button.addActionListener(new ComputeActionListener());
			panel3.add(button);
			
		}
		
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean checksolution = solPuzzle.checkSolution2();
				JFrame frame = new JFrame();
				JPanel finalPanel = new JPanel();
				JLabel done = new JLabel();
			    finalPanel.setLayout(new FlowLayout());
				if (checksolution == true) {
				   done = new JLabel("The solution is correct");
				} else {
				   done = new JLabel("The solution is not correct");
				    
				}
				finalPanel.add(done);
				frame.add(finalPanel);
			    frame.pack();
			    frame.setVisible(true);
			} 
			
		});
		
		panel3.add(check);
		
		//frame layout
		frame.setLayout(new BorderLayout());
		frame.add(panel1, BorderLayout.LINE_START);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.PAGE_END);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private class ComputeActionListener implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				KeyBoard keyboard = new KeyBoard("Enter a character", (CrosswordButton)e.getSource());
				
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(frame, "An exception has occurred: " + ex, "Error!", 				JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// Opbouwen puzzel

		String location = "src/crosswordCode/";
		InputStream input = null;
		Properties prop = new Properties();
		String fileName = "";
		String solution = "";
		String line ="";
		int lineNumber = 0;
		int height = 0;
		int width = 0;
		
		String[] sqCharacters = new String[0];
		String grid ="";
		char bluevalue =' ';

		try {
			input = new FileInputStream(location + "config.properties");

			// load a properties file
			prop.load(input);

			// get the property values and print it out
			fileName = prop.getProperty("filename");
			solution = prop.getProperty("solution");

		} catch (IOException ex) {
			ex.printStackTrace();

		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		Puzzle crosswordPuzzle = new Puzzle();
		Puzzle sol = new Puzzle(solution.length(), 1);
		SolutionPuzzle solPuzzle = new SolutionPuzzle(sol);

		try(BufferedReader br = new BufferedReader(new FileReader(location + fileName))) {

			while((line=br.readLine()) !=null) {
				//System.out.println(lineNumber);
				lineNumber++;

				
				
				// Instantiate dimension in first line
				if (lineNumber == 1) {
					String[] dim = line.split(" ");
					width = Integer.parseInt(dim[0]);
					height = Integer.parseInt(dim[1]);
					
					crosswordPuzzle.setWidthHeight(width, height);
				}

				// determine the lines for the squares 
				if ((lineNumber > 1) && (lineNumber <= (1 + height))) {
					grid = grid.concat(line + " ");
				}

				// text of panel
				if (lineNumber > 1+height){
					crosswordPuzzle.addPanel(line);

				}
			} 

			//add squares to crossword puzzle
			sqCharacters = grid.split(" ");
			for (int i = 0; i < sqCharacters.length; i++) {
				if (sqCharacters[i].equals("O")) {
					WhiteSquare white = new WhiteSquare(1+i%width,1+i/width);
					crosswordPuzzle.addSquares(white);
				}

				if (sqCharacters[i].equals("X")) {
					BlackSquare black = new BlackSquare(1+i%width,1+i/width);
					crosswordPuzzle.addSquares(black);

				}

				if (sqCharacters[i].contains("H")) {
					String waarde = sqCharacters[i];
					bluevalue = waarde.charAt(2);
					BlueSquare blue = new BlueSquare(1+i%width,1+i/width, bluevalue);
					crosswordPuzzle.addSquares(blue);

				}

				if (sqCharacters[i].equals("S")) {
					GraySquare gray = new GraySquare(1+i%width,1+i/width);
					crosswordPuzzle.addSquares(gray);

				}


			}

			//make checksquares
			for (int i = 0; i < solution.length(); i++) {
				CheckSquare check = new CheckSquare(1+i, 1, solution.charAt(i));
				solPuzzle.addCheckSquares(check); 
			}	


			/*System.out.println(crosswordPuzzle.getPanel());
			System.out.println(crosswordPuzzle.getHeight());
			System.out.println(crosswordPuzzle.getWidth());
			System.out.println(Arrays.toString(sqCharacters));
			System.out.println(sqCharacters.length);
			System.out.println(solPuzzle.checkSolution());
			solPuzzle.checkSolution2();
			 */

			br.close();

		} catch(FileNotFoundException fnf) {
			System.out.println("File not found: " + fnf);
		} catch(IOException io) {
			System.out.println("An error occurred while reading the input file: " + io);
		}


		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Crossword(crosswordPuzzle, solPuzzle);
				
			}
		});

	}

}
