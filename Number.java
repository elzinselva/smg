import java.util.Random;
import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int score = 0;
        boolean playing = true;

        while (playing) {
            System.out.println("Assume a number between 1 and 100:");
            int uGuess = scanner.nextInt();
            attempts++;

            if (uGuess == rNumber) {
                System.out.println("Excellent job!");
                System.out.println(" You solved it in " + attempts  );

                score += (10 - attempts);

                System.out.println("Again? (yes/no)");
                String ans = scanner.next();

                if (ans.equalsIgnoreCase("no")) {
                    playing = false;
                } else {
                    rNumber = random.nextInt(100) + 1;
                    attempts = 0;
                }
            } else if (uGuess < rNumber) {
                System.out.println("lower mark.So please try again.");
            } else {
                System.out.println("higher mark.So please try again.");
            }

            if (attempts > 11) {
                System.out.println("Sorry, you're out of tries.");
                System.out.println("The exact number was:"  + rNumber);
                playing = false;
            }
        }

        System.out.println("you've scored " + score + " out of 10 in total.");

        scanner.close();
    }
}