import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random num = new Random();
        boolean againPlay = true;
        int totalScoreGain = 0;
        int playedRound = 0;

        while (againPlay) {
            int numberToGuess = num.nextInt(200)+1; // Range 1 to 200
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedNumberCorrectly = false;

            System.out.println(" Round "+(playedRound +1));
            System.out.println("Guess a number between 1 To 200");

            while (attempts <= maxAttempts && !guessedNumberCorrectly) {
                System.out.println("Enter your Guess Number");
                int guessNumber = sc.nextInt();
                attempts++;

                if(guessNumber == numberToGuess){
                    System.out.println("Correct ! you guess the correct number in  :"+attempts+"Attempts");
                    guessedNumberCorrectly = true;
                    totalScoreGain+=maxAttempts - attempts+1;
                }else if(guessNumber > numberToGuess){
                    System.out.println("ohh No! Too High");
                }else{
                    System.out.println("Too Low!");
                }
            }
            if(!guessedNumberCorrectly){
                System.out.println("You are Out of the Attempts! The number was "+ numberToGuess);
            }
            playedRound++;
            System.out.println("Do you want To Play again?(yes/no)");
            againPlay = sc.next().equalsIgnoreCase("yes");
        }
        System.out.println("Now Game is over !");
        System.out.println("Rounds Played by you = "+ playedRound);
        System.out.println("Total score you gain = "+ totalScoreGain);
        sc.close();
    }
}


