/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crapstest;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Simulate a game of Craps played with 2 6-sided dice
 */
public class Craps {

    // instance variables
    private boolean traceOn;    // print all rolls of the dice or not?
    private Die dieOne; 	// a 6-sided die object
    private Die dieTwo; 	// another  6-sided die object
    private boolean winner; // result of the game (won/lost)

    /**
     * Create dice and initialize the game
     *
     * @param trace true if user wants all rolls of the dice to be printed,
     * false to just see end result (won or lost)
     */
    public Craps(boolean trace)
      {
        traceOn = trace;
        dieOne = new Die();
        dieTwo = new Die();
        winner = false;
      }

    /**
     * Play a game of craps. Continue throwing until a result is decided
     */
    public int play()
      {
        // String answer = JOptionPane.showInputDialog("Want to play?"
        //        + "\nType Y for Yes or N for No");
        do
          {

            if (traceOn)
              {
                System.out.println("\nThe dice are coming out...");
              }

            // make initial roll of the dice
            int initialRoll = dieOne.roll() + dieTwo.roll();

            if (traceOn)
              {
                System.out.println("Initial Roll:  " + initialRoll);
              }

            // when dice are coming out, 7 or 11 wins, and 2,3, or 12 loses.  Any
            // other number becomes player's "point" to be matched...
            if (initialRoll == 7 || initialRoll == 11)
              {
                winner = true;
                return 1;
              } else if (initialRoll == 2 || initialRoll == 3 || initialRoll == 12)
              {
                winner = false;
                return 2;
              } else	// player's "point" is established
              {
                int point = initialRoll;
                if (traceOn)
                  {
                    System.out.print(point + " is your point.\nRolling...  ");
                  }

                boolean gameOver = false;

                // repeat until the game is over...
                do
                  {
                    // roll again
                    int newRoll = dieOne.roll() + dieTwo.roll();

                    if (traceOn)
                      {
                        System.out.print(newRoll + "  ");
                      }

                    // evaluate the new roll
                    if (newRoll == 7)           // player loses!
                      {
                        winner = false;
                        gameOver = true;
                        return 2;

                      } else if (newRoll == point)  // player wins!
                      {
                        winner = true;
                        gameOver = true;
                        return 1;

                      }
                  } while (!gameOver);

                if (traceOn)
                  {
                    System.out.println();
                  }
              }
            if (isWinner())
              {
                System.out.println("Player wins!\n");
              } else
              {
                System.out.println("Sorry, player loses.\n");
              }
            // answer = "n";
            //answer = JOptionPane.showInputDialog("Play again? \nEnter Y for Yes, or N for No");
          } while (true);

      }

    /**
     * Report outcome of the game.
     *
     * @return true if player won, false if player lost
     */
    public boolean isWinner()
      {
        return winner;
      }
}


