import java.util.*;
import java.util.Random;

class GuessGame
{
    public static void main (String ar[])
    {
        Scanner scanner = new Scanner(System.in);
        String game = "yes";
        
        while (game.equals("yes"))
        {
            Random rno =  new Random();
            int randomnumber =  rno.nextInt(99);
            int guess = -1;
            int tries = 0;

            while(guess != randomnumber)
            {
                System.out.println("Guess a number between 0 and 99: ");
                guess = scanner.nextInt();
                tries++;

                if(guess == randomnumber)
                {
                    System.out.println("Congratulations ! You guessed the number in  " + tries + " attempts...");
                    System.out.println("do you want to play the game again? type yes or no to continue");
                    game = scanner.next().toLowerCase();
                }
                else if (guess > randomnumber)
                {
                    System.out.println("your guess no is too high, please try again. ");
                }
                else
                {
                    System.out.println("your guess is too low, please try again. ");
                }
            }
        }
    }
}