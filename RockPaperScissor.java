import java.util.Random;
import java.util.*;

public class RockPaperScissor
{
    public static void main(String[] ar)
    {
        System.out.println("0 for rock , 1 for paper , 2 for scissor");
        Scanner sc = new Scanner(System.in);
        int plymove = sc.nextInt();
        System.out.println("Your move : " + plymove);
        Random  rnd = new Random();
        int commove = rnd.nextInt(3);
        System.out.println("Computer's move is : " + commove);
        if(commove == plymove)
        {
            System.out.println("the match is Draw ");
        }
        else if(plymove == 0 && commove == 1 || plymove == 1 && commove ==2 || plymove == 2 && commove == 0 )
        {
            System.out.println("lost :( ... Please Try Again");
        }
        else{
            System.out.println("cong... you won :) ");
        }
        System.out.println("thanks for playing game !");
    }
}