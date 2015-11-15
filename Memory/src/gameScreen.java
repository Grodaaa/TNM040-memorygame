import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static java.util.Collections.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class gameScreen extends JFrame implements ActionListener
{
	private JPanel pnlPlayer, pnlCards;
	private int cards = startScreen.getNumberOfCards(), checkCards = 2;
	private JButton[] card = new JButton[startScreen.getNumberOfCards()];
	private JButton exit, back;
	private JTextArea player1, player2;
	private int visble, counter = 0;
	private ArrayList<Integer> gameList = new ArrayList<Integer>();
	private ArrayList<ImageIcon> gameImages = new ArrayList<ImageIcon>();
	private ImageIcon defaultCard, activePlayer = new ImageIcon("Active/Active.png"), inactivePlayer = new ImageIcon("Active/Inactive.png"),
						winner = new ImageIcon("Active/winner.png"), loser = new ImageIcon("Active/loser.png"),
						draw1 = new ImageIcon("Active/Draw1.png"), draw2 = new ImageIcon("Active/Draw2.png");
	private ImageIcon[] imageArray = new ImageIcon[24];
	private int[] value = new int[2], ID = new int[2];
	private int currentPlayer;
	private int player1Points = 0, player2Points = 0;
	private String player1Text, player2Text;
	private String name1 = startScreen.getPlayer1Name(), name2 = startScreen.getPlayer2Name();
	private JLabel imgPlayer1, imgPlayer2;
	private Color colour = new Color(255,255,240);

	public gameScreen()
	{

    	//Panel west
    	pnlCards = new JPanel();
    	

        //Skapar korten till spelet
        for (int i = 0; i < card.length; i++)
    	{
    		card[i] = new JButton();
    		card[i].setFont(new Font("Sans Serif", Font.BOLD, 28));
    	}
        if(cards == 6)
        {
        	pnlCards.setLayout(new GridLayout(3,2));
        	card6Images();
        	defaultCard = new ImageIcon("6images/card.png");
        }
        else if(cards == 12)
        {
        	pnlCards.setLayout(new GridLayout(4,3));
        	card12Images();
        	defaultCard = new ImageIcon("12images/card.png");
        }
        else if(cards == 24)
        {
        	pnlCards.setLayout(new GridLayout(6,4)); 
        	card24Images();
        	defaultCard = new ImageIcon("24images/card.png");
        }
        
        for(int i = 0; i < card.length;i++)
    	{
    		pnlCards.add(card[i]);
    		card[i].setLayout(new BorderLayout());
    		card[i].setPreferredSize(new Dimension(60,60));
    		card[i].addActionListener(this);
    		card[i].setIcon(defaultCard);
    	}
        
        imgPlayer1 = new JLabel();
        	imgPlayer1.setSize(new Dimension(200,150));
        	imgPlayer1.setIcon(activePlayer);
        imgPlayer2 = new JLabel();
        	imgPlayer2.setSize(new Dimension(200,150));
        	imgPlayer2.setIcon(inactivePlayer);
        
        pnlCards.setPreferredSize(new Dimension(450,675));

    	//Panel east
    	pnlPlayer = new JPanel();
    	pnlPlayer.setLayout(new BorderLayout());
    	pnlPlayer.setPreferredSize(new Dimension(250,250));
    	pnlPlayer.setBackground(colour);
    	
    	JPanel buttonPanel = new JPanel();
    	back = new JButton("Restart");
    		back.setFont(new Font("SansSerif", Font.BOLD, 20));
    		back.setForeground(Color.BLUE);
    	back.addActionListener(this);
    	back.setPreferredSize(new Dimension(120,60));
    	exit = new JButton("Exit");
    		exit.setFont(new Font("SansSerif", Font.BOLD, 20));
    		exit.setForeground(Color.RED);
    	exit.addActionListener(this);
    	exit.setPreferredSize(new Dimension(120,60));
    	buttonPanel.add(back);
    	buttonPanel.add(exit);
    	buttonPanel.setBackground(colour);
    	
    	String name1 = startScreen.getPlayer1Name();
    	String name2 = startScreen.getPlayer2Name();
    	player1Text = "\n\n\n\n\n\n  " + name1 + "\n" + "  " +  "Score: " + player1Points;
    		
    	player2Text = "\n\n\n\n\n\n  " + name2 + "\n" +  "  " + "Score: " + player2Points;
    	player1 = new JTextArea(player1Text);
    		player1.setFont(new Font("Sans Serif" ,Font.BOLD, 25));
    		player1.setEditable(false);
    		player1.setPreferredSize(new Dimension(250,250));
    		player1.add(imgPlayer1);
    		player1.setBackground(null);
    	
    	player2 = new JTextArea(player2Text);
    		player2.setFont(new Font("Sans Serif" ,Font.PLAIN, 20));
    		player2.setEditable(false);
    		player2.setPreferredSize(new Dimension(250,227));
    		player2.add(imgPlayer2);
    		player2.setBackground(null);
    	
    	pnlPlayer.add(buttonPanel, BorderLayout.SOUTH);
    	pnlPlayer.add(player1, BorderLayout.NORTH);
    	pnlPlayer.add(player2, BorderLayout.CENTER);
    	
    	add(pnlPlayer, BorderLayout.EAST);
    	add(pnlCards, BorderLayout.CENTER);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("Epic Memory Grand Game of Cerebral Cortex");
    	setSize(700, 675);
    	setVisible(true);
    	setResizable(false);
    	
    	
    	setArrayListText();
    	
    	currentPlayer = 1;
    
	}
	public void card6Images()
	{
		imageArray[0] = new ImageIcon("6images/img1.png");
		imageArray[1] = new ImageIcon("6images/img2.png");
		imageArray[2] = new ImageIcon("6images/img3.png");
		
		
	}
	public void card12Images()
	{
		imageArray[0] = new ImageIcon("12images/img1.png");
		imageArray[1] = new ImageIcon("12images/img2.png");
		imageArray[2] = new ImageIcon("12images/img3.png");
		imageArray[3] = new ImageIcon(("12images/img4.png"));
		imageArray[4] = new ImageIcon(("12images/img5.png"));
		imageArray[5] = new ImageIcon(("12images/img6.png"));
		

	}
	public void card24Images()
	{
		imageArray[0] = new ImageIcon("24images/img1.png");
		imageArray[1] = new ImageIcon("24images/img2.png");
		imageArray[2] = new ImageIcon("24images/img3.png");
		imageArray[3] = new ImageIcon(("24images/img4.png"));
		imageArray[4] = new ImageIcon(("24images/img5.png"));
		imageArray[5] = new ImageIcon(("24images/img6.png"));
		imageArray[6] = new ImageIcon(("24images/img7.png"));
		imageArray[7] = new ImageIcon(("24images/img8.png"));
		imageArray[8] = new ImageIcon(("24images/img9.png"));
		imageArray[9] = new ImageIcon(("24images/img10.png"));
		imageArray[10] = new ImageIcon(("24images/img11.png"));
		imageArray[11] = new ImageIcon(("24images/img12.png"));	
		
	}
	
	public void switchPlayers()
	{
		if(getCurrentPlayer() == 1)
		{
			setCurrentPlayer(2);
		}
		else if(getCurrentPlayer() == 2)
		{
			setCurrentPlayer(1);
		}
	}
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public void setCurrentPlayer (int currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}
	public void ActivePlayer()
	{
		if(getCurrentPlayer() == 1)
		{
			player1.setFont(new Font("Sans Serif" ,Font.BOLD, 25));
			player2.setFont(new Font("Sans Serif" ,Font.PLAIN, 20));
			imgPlayer1.setIcon(activePlayer);
			imgPlayer2.setIcon(inactivePlayer);
			
		}
		else if(getCurrentPlayer() == 2)
		{
			player2.setFont(new Font("Sans Serif" ,Font.BOLD, 25));
			player1.setFont(new Font("Sans Serif" ,Font.PLAIN, 20));
			imgPlayer2.setIcon(activePlayer);
			imgPlayer1.setIcon(inactivePlayer);
		}
	}
	
	public void setArrayListText()
	{
		for(int i = 0; i < 2; i++)
		{
			for(int j = 1; j < (card.length / 2)+1; j++)
			{
				gameList.add(j);
				gameImages.add(imageArray[j-1]);
			}
			shuffle(gameList);
		}
	}

	public boolean sameValues()
	{			
		
		if(value[0] == value[1])
		{
			return true;

		}
		return false;
	}
	public void winner()
	{
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(back == e.getSource())
		{
			setVisible(false);
			new startScreen();
		}
		if(exit == e.getSource())
		{
			System.exit(0);
		}
		
		for(int i = 0; i < card.length; i++)
		{
			if(card[i] == e.getSource())
			{
				
				card[i].setIcon(gameImages.get(gameList.get(i)));
				card[i].setDisabledIcon(gameImages.get(gameList.get(i)));
				card[i].setEnabled(false);
				
				counter++;
				if(counter == 3)
				{
					if(sameValues())
					{
						card[ID[0]].setEnabled(false);
						card[ID[1]].setEnabled(false);
						checkCards += 2;
						
							if(getCurrentPlayer() == 1)
							{
								player1Points++;
								player1.setText("\n\n\n\n\n\n  " + name1 + "\n" + "  " +  "Score: " + player1Points);
								
							}
							else if(getCurrentPlayer() == 2)
							{
								player2Points++;
								player2.setText("\n\n\n\n\n\n  " + name2 + "\n" + "  " +  "Score: " + player2Points); 
								
							}
							if(checkCards == cards)
							{
								if(getCurrentPlayer() == 1)
								{
									player1Points++;
									player1.setText("\n\n\n\n\n\n  " + name1 + "\n" + "  " +  "Score: " + player1Points);
									if(player1Points > player2Points)
									{
										imgPlayer1.setIcon(winner);
										imgPlayer2.setIcon(loser);
										player1.setText("\n\n\n\n\n\n  " + name1 + "\n" + "  " +  "Score: " + player1Points);
									}
									else if(player2Points == player1Points)
									{
										player2.setText("\n\n\n\n\n\n  " + name2 + "\n" + "  " +  "Score: " + player2Points + 
												"\n" + " It's a draw!");
										player1.setText("\n\n\n\n\n\n  " + name1 + "\n" + "  " +  "Score: " + player1Points + 
												"\n" + " It's a draw!");
										imgPlayer1.setIcon(draw1);
										imgPlayer2.setIcon(draw2);
									}
								}
								else if(getCurrentPlayer() == 2)
								{
									player2Points++;
									player2.setText("\n\n\n\n\n\n  " + name2 + "\n" + "  " +  "Score: " + player2Points); 
									if(player2Points > player1Points)
									{
										imgPlayer1.setIcon(loser);
										imgPlayer2.setIcon(winner);
										player2.setText("\n\n\n\n\n\n  " + name2 + "\n" + "  " +  "Score: " + player2Points);
									}
									else if(player2Points == player1Points)
									{
										player2.setText("\n\n\n\n\n\n  " + name2 + "\n" + "  " +  "Score: " + player2Points + 
												"\n" + "  It's a draw!");
										player1.setText("\n\n\n\n\n\n  " + name1 + "\n" + "  " +  "Score: " + player1Points + 
												"\n" + "  It's a draw!");
										imgPlayer1.setIcon(draw1);
										imgPlayer2.setIcon(draw2);
									}
								}
							}
					}
					else
					{
						card[ID[0]].setEnabled(true);
						card[ID[0]].setText("");
						card[ID[0]].setIcon(defaultCard);
						card[ID[1]].setEnabled(true);
						card[ID[1]].setText("");
						card[ID[1]].setIcon(defaultCard);
						switchPlayers();
						ActivePlayer();
					}
					counter = 1;
					
				}
				if(counter == 1)
				{
					ID[0] = i;
					value[0] = gameList.get(i);
				
				}
				if(counter == 2)
				{
					ID[1] = i;
					value[1] = gameList.get(i);
				}
				
			}

		}
		
	}

}
