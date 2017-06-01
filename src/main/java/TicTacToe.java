import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class TicTacToe {
	JFrame _frame = new JFrame("Tic-Tac-Toe");
	JPanel _ttt = new JPanel();
	JPanel _newPanel = new JPanel();
	JButton[] _buttons = new JButton[9];
	JButton _newGame = new JButton();
	int state = 0;
	
	public static void main(String[] args) {
		new TicTacToe();

	}
	
	public TicTacToe(){
		_frame.setVisible(true);
		_frame.setSize(500, 500);
		_frame.setVisible(true);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_ttt.setLayout(new GridLayout(3, 3));
		_newPanel.setLayout(new FlowLayout());
		
		_frame.add(_ttt, BorderLayout.NORTH);
		_frame.add(_newPanel, BorderLayout.SOUTH);
		
		for (int j = 0; j < 9; j++) {
		    // Make a new button in the array location with text "_"
		    _buttons[j] = new JButton("_");
		    // Associate a new ButtonListener to the button (see below)
		    ActionListener buttonListener = new ButtonListener();
		    _buttons[j].addActionListener(buttonListener);
		    // Set the font on the button
		    _buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
		    // Add this button to the _ttt panel
		    _ttt.add(_buttons[j]);
		}
		
		_newGame = new JButton("New Game");		
		ActionListener buttonListener2 = new ButtonListener2();
		_newGame.setFont(new Font("Courier", Font.PLAIN, 48));
		_newGame.addActionListener(buttonListener2);
		_newPanel.add(_newGame);
		
	}

	class ButtonListener implements ActionListener {

		// Every time we click the button, it will perform
		// the following action.

		public void actionPerformed(ActionEvent e) {

		    JButton source = (JButton) e.getSource();
		    String currentText = source.getText();
		    
		    if (currentText.equals("_") && state == 0) {
		    	source.setText("X");
		    	source.setEnabled(false);		    	
		    	
		    } else if (currentText.equals("_") && state == 1){
		    	source.setText("O");
		    	source.setEnabled(false);
		    	
		    } else {
		    	source.setText("_");
		    }
		    
		    state = 1 - state;
		}
	    
	}
	
	class ButtonListener2 implements ActionListener {

		// Every time we click the button, it will perform
		// the following action.

		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < 9; i++){
				_buttons[i].setEnabled(true);
				_buttons[i].setText("_");
				
			}
		}
	    
	}

}
