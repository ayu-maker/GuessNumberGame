import java.util.Random;
import java.util.Scanner;

public class CreateGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random random = new Random();// Create the object of Random class
        int maxAttempts = 10;// We provide only 10 attempts
        int winscore = 0;

        System.out.println("Welcome to the Guess Number Game!");
        boolean playAnotherRound = true;// For play mutiple times

        while (playAnotherRound) { // It will do the work till value of playAnotherRound is true
            int randomNumber = random.nextInt(100) + 1; // Intially it generate random number b/w 0 to 99 so we add +1
                                                        // to generate till 100
            int attempts = 0; // Intitially we did not use any attempt
            boolean GuessedCorrectly = false; // Intially no guessed value is correct

            System.out.println("Please Guess a number between 1 and 100.");

            while (attempts < maxAttempts && !GuessedCorrectly) { // condition for we have remaining attempt and did not
                                                                  // guessed any correct value
                System.out.print("Enter your Guess Number: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == randomNumber) { // conditon when user enter correct guessed value
                    GuessedCorrectly = true;
                    winscore += (maxAttempts - attempts + 1) * 10;// calcualte here win score of user
                    System.out.println("Congratulations! You Guessed the correct number.");
                    System.out.println("Your score is: " + winscore);
                } else if (userGuess > randomNumber) {
                    System.out.println("Try again! Your Guess is too high.");
                } else {
                    System.out.println("Try again! Your Guess is too low.");
                }

                if (!GuessedCorrectly) {
                    System.out.println("You have " + (maxAttempts - attempts) + " attempts remaining."); // calcualtion
                                                                                                         // of attempt
                }
            }

            if (!GuessedCorrectly) {
                System.out
                        .println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Do you want to play another round? (yes/no)");
            String response = sc.next();

            if (!response.equalsIgnoreCase("yes")) { // for play another round
                playAnotherRound = false;
                System.out.println("Thank you for playing! Your final score is: " + winscore);
            }
        }

        sc.close();
        // we calculate user score as per their remaining attempts
    }
}
