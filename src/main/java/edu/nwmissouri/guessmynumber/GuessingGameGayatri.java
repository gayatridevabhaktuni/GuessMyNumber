package edu.nwmissouri.guessmynumber;

import javax.swing.*;

/**
 * “Guess a Number” game that allows user to guess a random number. Uses Swing
 * to make a nice graphical user interface.
 *
 * Original Source: https://hackr.io/blog/java-projects
 *
 * Read about jOptionPane:
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 * .showInputDialog() .showMessageDialog()
 *
 * @author Denise Case
 */
public class GuessingGameGayatri {

    public static void main(String[] args) {
        // TODO: change magicNumber to secretNumber Hint: Right-click / Refactor / Rename
        int magicNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + magicNumber);
        int count = 1;

        while (userAnswer != magicNumber) {
            // TODO: create 3 local variables for the arguments so we know what they mean
            // showInputDialog - the first argument is always null (no parent)
             String message = "Enter a guess between 1 and 100"; // what type?
            String title = "Guessing Game" ;// what type?
            int messageType = JOptionPane.INFORMATION_MESSAGE;
//             Works the same as original 3 but more expressive - this is an example of a what? Hint: enum
           String response = JOptionPane.showInputDialog(null, message, title, messageType);
            userAnswer = Integer.parseInt(response);

            JOptionPane.showMessageDialog(null, "" + knowGuess(userAnswer, magicNumber, count));
            count++;
        }
    }

    // TODO: Refactor / Rename determineGuess to calculateMessage
    public static String knowGuess(int userAnswer, int magicNumber, int count) {
        // TODO: Instead of "Try Number" which sounds like we should try that as a guess...
        // Say "You've used " + count + guesses.
        // If count is one, use "guess", else use "guesses" HINT: Ternary operator
        String s = (count == 1)? " guess.": " guesses.";
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == magicNumber) {
            return "Correct!\n you are done in " + count +s;
        } else if (userAnswer > magicNumber) {
            return "Your guess is too high, try again.\n this is " + count+ s;
        } else if (userAnswer < magicNumber) {
            return "Your guess is too low, try again.\nthis is " + count+ s;
        } else {
            return "Your guess is incorrect\n this is " + count+ s;
        }
    }
}
