/**
 * @(#)MemoryGame.java
 *
 *
 * @author 
 * @version 1.00 2012/9/17
 */

import java.awt.*;

import javax.swing.*;

public class MemoryGame extends JFrame
{
	
    public MemoryGame() 
    {
		Container c = getContentPane();
        c.setLayout(new BorderLayout());
        new startScreen();

    }
    
    public static void main(String[] args) 
	{
		new MemoryGame();

	}

}