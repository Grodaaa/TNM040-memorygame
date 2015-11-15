import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class startScreen extends JFrame implements ActionListener {

	private JPanel pnlText, pnlStart, pnlRules, pnlEast, pnlWest;
	private JLabel imageLabel;
	private JButton start, exit;
	public static String player1Name;
	public static String player2Name;
	private static JTextField p1NameField, p2NameField;
	private static int nCards = 6;
	private JComboBox inputCards;
	private Color colour = new Color(255,255,240);
	
	public startScreen()
	{
		pnlRules = new JPanel();
		pnlRules.setLayout(new GridLayout());
		pnlRules.setBackground(colour);
		
		imageLabel = new JLabel();
		
		ImageIcon startImage = new ImageIcon("Cards/Questiommark_.png");
        imageLabel.setIcon(startImage);
        
        JTextArea rules = new JTextArea("\n\n This is a memory game. The goal is to match as " +
        		"\n many cards as possible." +
        		"\n\n Rules: Player 1 starts with picking two cards, " +
        		"\n if they match the player gets to play again, " +
        		"\n if they don't they flip back and it's Player 2's turn. " +
        		"\n For each pair the player earns one point. " +
        		"\n The player with the most points wins the game." +
        		"\n\n Tip: Remember where each picture is so you can " +
        		"\n match them when it's your turn.");
			rules.setEditable(false);
			rules.setPreferredSize(new Dimension(250,310));
			rules.setBackground(colour);
			rules.setFont(new Font("Sans Serif" ,Font.PLAIN, 15));
		
		pnlRules.add(imageLabel);
		pnlRules.add(rules);
		
		pnlText = new JPanel();
		pnlText.setLayout(new FlowLayout());
		
		p1NameField = new JTextField("Player 1");
			p1NameField.setPreferredSize(new Dimension(300,30));
			JLabel player1NameLabel = new JLabel("Enter Player 1: ");
				player1NameLabel.setFont(new Font("Sans Serif" ,Font.PLAIN, 15));
		p2NameField = new JTextField("Player 2");
			p2NameField.setPreferredSize(new Dimension(300,30));
			JLabel player2NameLabel = new JLabel("Enter Player 2: ");
				player2NameLabel.setFont(new Font("Sans Serif" ,Font.PLAIN, 15));
		inputCards = new JComboBox();
			inputCards.addActionListener(this);
			JLabel inputCardsLabel = new JLabel("Number of cards: ");
			inputCardsLabel.setFont(new Font("Sans Serif" ,Font.PLAIN, 15));
			
			inputCards.addItem("6"); inputCards.addItem("12"); inputCards.addItem("24");
		
		pnlText.add(player1NameLabel);
		pnlText.add(p1NameField);
		pnlText.add(player2NameLabel);
		pnlText.add(p2NameField);
		pnlText.add(inputCardsLabel);
		pnlText.add(inputCards);
		pnlText.setBackground(colour);
			
		
		pnlStart = new JPanel();
			pnlStart.setBackground(colour);
		exit = new JButton("EXIT");
			exit.setFont(new Font("SansSerif", Font.BOLD, 20));
			exit.setForeground(Color.RED);
		exit.addActionListener(this);
			exit.setPreferredSize(new Dimension(120,60));
		pnlStart.add(exit);
		start = new JButton("PLAY");
			start.setFont(new Font("SansSerif", Font.BOLD, 20));
			start.setForeground(Color.GREEN);
			start.addActionListener(this);
			start.setPreferredSize(new Dimension(120,60));
		pnlStart.add(start);
		
		pnlWest = new JPanel();
			pnlWest.setPreferredSize(new Dimension(160,100));
			pnlWest.setBackground(colour);
		pnlEast = new JPanel();
			pnlEast.setPreferredSize(new Dimension(160,100));
			pnlEast.setBackground(colour);
		
		add(pnlRules, BorderLayout.NORTH);
		add(pnlWest, BorderLayout.WEST);
		add(pnlText, BorderLayout.CENTER);
		add(pnlEast, BorderLayout.EAST);
		add(pnlStart, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("Epic Memory Grand Game of Cerebral Cortex");
    	setSize(750, 675);
    	setVisible(true);
    	setResizable(false);
	}
	public static String getPlayer1Name()
	{
		return p1NameField.getText();
	}
	public static String getPlayer2Name()
	{
		return p2NameField.getText();
	}
	public static int getNumberOfCards()
	{
		return nCards;
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == start)
		{
			setVisible(false);
			new gameScreen();
		}
		if(exit == e.getSource())
		{
			System.exit(0);
		}
		if (inputCards.getSelectedIndex() == 0) {
			nCards = 6;
		}
		else if (inputCards.getSelectedIndex() == 1) {
			nCards = 12;

		}
		else if (inputCards.getSelectedIndex() == 2) {
			nCards = 24;

		}

	}

}
