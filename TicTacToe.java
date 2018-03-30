/*
Name: Ash Scarbrough
Assignment: Homework 4 - Part 1
Class: CSCI-C490 Mobile Application Development
Semester: Summer Session 1, 2016
Date: 5/6/2016
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Class creates a GUI Application that enables players to play Tic-Tac-Toe
public class TicTacToe extends JFrame implements ActionListener
{											// Implements ActionListener
    public static final int WIDTH = 400;  // Window sized to program needs
    public static final int HEIGHT = 300;
    public int totalStepsFinished = 0;   // Counts number of steps taken in game
    
    JLabel MessageLabel;
    JButton aB1;
    JButton aB2;
    JButton aB3;
    JButton aB4;
    JButton aB5;
    JButton aB6;
    JButton aB7;
    JButton aB8;
    JButton aB9;
    JButton resetButton;
    
    /*
     * MAIN Program    
     */
   	public static void main (String[] args){  
   		TicTacToe gui = new TicTacToe();  // New instance of TicTacToe GUI is created
   		gui.setVisible(true);			  // and made visible
	} // main
	
   	
   	// TicTacToe GUI designed and set up
	public TicTacToe(){
		// Set general window attributes (title, size, close condition, layout)
		setTitle("Tic-Tac-Toe Game");  
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Initial Message: first move given to O's
		MessageLabel = new JLabel ("Please make a move (O)");
		add (MessageLabel, BorderLayout.NORTH);
		
		// Set Center GameGrid (9x9)
		JPanel gameGrid = new JPanel();
		gameGrid.setLayout(new GridLayout(3,3));
		aB1 = new JButton();  // Action Buttons 1-9 created
		aB1.addActionListener(this);  // Each button provided action listener
		
		aB2 = new JButton();
		aB2.addActionListener(this);
		
		aB3 = new JButton();
		aB3.addActionListener(this);
		
		aB4 = new JButton();
		aB4.addActionListener(this);
		
		aB5 = new JButton();
		aB5.addActionListener(this);
		
		aB6 = new JButton();
		aB6.addActionListener(this);
		
		aB7 = new JButton();
		aB7.addActionListener(this);
		
		aB8 = new JButton();
		aB8.addActionListener(this);
		
		aB9 = new JButton();
		aB9.addActionListener(this);
		
		// Add buttons to the grid sequentially
		gameGrid.add(aB1);	
		gameGrid.add(aB2);
		gameGrid.add(aB3);
		gameGrid.add(aB4);
		gameGrid.add(aB5);
		gameGrid.add(aB6);
		gameGrid.add(aB7);
		gameGrid.add(aB8);
		gameGrid.add(aB9);
		add(gameGrid, BorderLayout.CENTER);
		
		// Set bottom buttonPanel (Reset Button)
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		resetButton= new JButton("Reset");
		resetButton.addActionListener(this);
		resetButton.setBackground(Color.RED);
		resetButton.setFocusPainted(false);
		buttonPanel.add(resetButton);
		add(buttonPanel, BorderLayout.SOUTH);
	} // TicTacToe
	
	
	// Based on the number of steps completed, returns String "O" or "X"
	// indicating whose turn it is.
	public String whoseTurn(int x)
	{
		if ((totalStepsFinished % 2) == 0) // If turn is even, O's turn
			return "O";
		else								// If odd, X's turn
			return "X";
	} //whoseTurn
	
	// Method determines which button was pressed via ActionListener
	// an appropriate response is given for each particular button
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getSource() instanceof JButton) // Ensure event is a JButton
		{
			if (e.getSource() == resetButton)  // reset returns all buttons to
			{								   // original state
				totalStepsFinished = 0;
				aB1.setText("");   // Set all button values back to empty
				aB2.setText(""); 
				aB3.setText(""); 
				aB4.setText(""); 
				aB5.setText(""); 
				aB6.setText(""); 
				aB7.setText(""); 
				aB8.setText(""); 
				aB9.setText(""); 
				aB1.setEnabled(true);  // re-enable all buttons
				aB2.setEnabled(true);
				aB3.setEnabled(true);
				aB4.setEnabled(true);
				aB5.setEnabled(true);
				aB6.setEnabled(true);
				aB7.setEnabled(true);
				aB8.setEnabled(true);
				aB9.setEnabled(true);
				MessageLabel.setText("Please make a move (O)");
			}
			// If grid action button is selected: O or X gets the Square
			// and square is disabled for future use, program check for a winner
			else if (e.getSource() == aB1)
			{
				getsTheSquare (aB1);
				aB1.setEnabled(false);
				checkWhoWins();
			}	
			else if (e.getSource() == aB2)
			{
				getsTheSquare (aB2);
				aB2.setEnabled(false);
				checkWhoWins();
			}
			else if (e.getSource() == aB3)
			{
				getsTheSquare (aB3);
				aB3.setEnabled(false);
				checkWhoWins();
			}
			else if (e.getSource() == aB4)
			{
				getsTheSquare (aB4);
				aB4.setEnabled(false);
				checkWhoWins();
			}
			else if (e.getSource() == aB5)
			{
				getsTheSquare (aB5);
				aB5.setEnabled(false);
				checkWhoWins();
			}
			else if (e.getSource() == aB6)
			{
				getsTheSquare (aB6);
				aB6.setEnabled(false);
				checkWhoWins();
			}
			else if (e.getSource() == aB7)
			{
				getsTheSquare (aB7);
				aB7.setEnabled(false);
				checkWhoWins();
			}
			else if (e.getSource() == aB8)
			{
				getsTheSquare (aB8);
				aB8.setEnabled(false);
				checkWhoWins();
			}
			else if (e.getSource() == aB9)
			{
				getsTheSquare (aB9);	
				aB9.setEnabled(false);
				checkWhoWins();
			}
		}
	} //assumingCorrectNumberFormats
	
	
	// Method determines if it is O's or X's turn, marking the chosen button
	// with the appropriate Letter accordingly
	// Method takes "selected action button" as its parameter
	public void getsTheSquare(JButton aB)
	{
		String mark = whoseTurn(totalStepsFinished);
		aB.setText(mark);
	} //getsTheSquare
	
	
	// Method checks if anybody is a winner by checking all winning combinations.
	// if three-in-a-row is found for any combination (vertical/horizontal/diagonal)
	// a JPanel message will 
	private void checkWhoWins()
	{	// If O wins any combination of winning arrangements
		if ((aB1.getText() == "O" && aB2.getText() == "O" && aB3.getText()== "O")
			|| (aB4.getText() == "O" && aB5.getText() == "O" && aB6.getText() == "O")
			|| (aB7.getText() == "O" && aB8.getText() == "O" && aB9.getText() == "O")
			|| (aB1.getText() == "O" && aB4.getText() == "O" && aB7.getText() == "O")
			|| (aB2.getText() == "O" && aB5.getText() == "O" && aB8.getText() == "O")
			|| (aB3.getText() == "O" && aB6.getText() == "O" && aB9.getText() == "O")
			|| (aB1.getText() == "O" && aB5.getText() == "O" && aB9.getText() == "O")
			|| (aB3.getText() == "O" && aB5.getText() == "O" && aB7.getText() == "O"))
		{  // Message "O" wins is displayed, and game grid disabled for play 
			MessageLabel.setText("O wins the game!");
			aB1.setEnabled(false);
			aB2.setEnabled(false);
			aB3.setEnabled(false);
			aB4.setEnabled(false);
			aB5.setEnabled(false);
			aB6.setEnabled(false);
			aB7.setEnabled(false);
			aB8.setEnabled(false);
			aB9.setEnabled(false);
		}  // If X wins any combination of winning arrangements
		else if ((aB1.getText() == "X" && aB2.getText() == "X" && aB3.getText()== "X")
			|| (aB4.getText() == "X" && aB5.getText() == "X" && aB6.getText() == "X")
			|| (aB7.getText() == "X" && aB8.getText() == "X" && aB9.getText() == "X")
			|| (aB1.getText() == "X" && aB4.getText() == "X" && aB7.getText() == "X")
			|| (aB2.getText() == "X" && aB5.getText() == "X" && aB8.getText() == "X")
			|| (aB3.getText() == "X" && aB6.getText() == "X" && aB9.getText() == "X")
			|| (aB1.getText() == "X" && aB5.getText() == "X" && aB9.getText() == "X")
			|| (aB3.getText() == "X" && aB5.getText() == "X" && aB7.getText() == "X"))
		{  // Message "X" wins is displayed, and game grid disabled for play 
			MessageLabel.setText("X wins the game!");
			aB1.setEnabled(false);
			aB2.setEnabled(false);
			aB3.setEnabled(false);
			aB4.setEnabled(false);
			aB5.setEnabled(false);
			aB6.setEnabled(false);
			aB7.setEnabled(false);
			aB8.setEnabled(false);
			aB9.setEnabled(false);
		}  // If there are no winners but no free spaces remain, display Tie message
		else if (aB1.getText() != "" && aB2.getText() != "" && aB3.getText()!= ""
			&& aB4.getText() != "" && aB5.getText() != "" && aB6.getText() != ""
			&& aB7.getText() != "" && aB8.getText() != "" && aB9.getText() != "")
				MessageLabel.setText("You two get tied!");
		else    // if no winner, and not a tie, it is the next player's turn
		{
			totalStepsFinished++;
			MessageLabel.setText("Please make a move (" 
					+ whoseTurn(totalStepsFinished) + ")");
		}
	}
}