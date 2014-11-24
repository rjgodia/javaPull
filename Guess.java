package q2;
import java.util.Random;
import java.util.Scanner;
/**
 * <p>This class generates a  guessing game where the user tries to guess
 * the hidden integer value.</p>
 *
 * @author Ralph Godia
 * @version 1.0
 */
public class Guess {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        
        /**
         * <p> Declare necessary variables. </p>
         */
        
        boolean playAgain = true;
        Scanner scan = new Scanner(System.in);

        /**
         * <p> This while loop will runs the game unless the user quits.</p>
         */
        
        while (playAgain) {
            int guess = 0;
            int count = 0;
            int one = 1;
            final int hundred = 100;
            final int stop = 0;
            Random num = new Random();
            int x = num.nextInt(hundred) + one;
            // System.out.println(x);

            System.out.print("\nEnter an integer [1-100] to"
                    + " guess OR enter [0] to quit:\n");

            /**
             * <p> This while loop continuously asks for the user's guess
             * until a correct answer matches. </p>
             */
            while (guess != x) {
                guess = scan.nextInt();
                count++;
                if (guess == stop) {
                    /**
                     * <p> Ends the round. </p>
                     */
                    System.out.println("===Round Ended===");
                    break;                
                } else if (guess == x) {
                    System.out.println("Correct! You got the right answer in "
                            + count + " guess(es).");
                    break;
                } else if (guess > x) {
                    System.out.print("Lower! ");
                } else if (guess < x) {
                    System.out.print("Higher! ");
                }
            }
            
            System.out.print("\nPlay Again? [y/n] ");
            String play = scan.next();
            
            /**
             * <p> If the user enters y, the program will run fresh again.
             * A new random number is generated as well.</p>
             */
            
            if (play.equalsIgnoreCase("y")) {
                playAgain = true;
                System.out.println("\n===New Game===\n");
            } else {
                System.out.println("\n===Game Over===");
                /**
                 * <p> Ends the game. </p>
                 */
                playAgain = false;
            }
            count = 0;
            guess = 0;
        }
        scan.close();
    }
};
