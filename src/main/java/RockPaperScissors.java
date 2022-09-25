import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int play = 0; // current move by player (rock, paper, scissors)
        int cpuPlay; // cpu's current move

        boolean notValid; // used for ensuring inputs are valid
        int noRounds = 0; // number of rounds
        boolean playing; // game runs while playing is true
        String playAgain; // does the player want to play again at the end of the game

        int playerWins = 0;
        int cpuWins = 0;
        int ties = 0;

        playing = true;
        while (playing) {
            System.out.println("ROCK, PAPER, SCISSORS\n");
            Thread.sleep(1000);

            // ask how many rounds (max 10 min 1)
            notValid = true;
            while (notValid) { // check input is between 1 and 10
                System.out.println("How many rounds would you like to play?\n(hint: must be a number between 1 and 10)");
                noRounds = scanner.nextInt();
                if (!(noRounds >= 1 && noRounds <= 10)) {
                    System.out.println("Cannot play %d rounds. Please enter a number between 1 and 10.");
                } else {
                    notValid = false;
                }
            }

            // play round
            for ( int i=0; i < noRounds; i++ ) {
                System.out.printf("\n***ROUND %d***\n\n", i+1);
                Thread.sleep(1000);

            //ask user for their choice: 1 rock, 2 paper 3 scissors
                notValid = true;
                while (notValid) { // check if valid input (1, 2 or 3)
                    System.out.println("Enter your choice:\n(1) rock\n(2) paper\n(3) scissors");
                    play = scanner.nextInt();
                    if (!Arrays.asList(1,2,3).contains(play)) { // if answer not 1, 2 or 3
                        System.out.println("Invalid play. Please enter 1, 2 or 3.");
                    } else {
                        notValid = false;
                    }
                }
                scanner.nextLine();
                System.out.print("You played: ");
                switch (play) {
                    case 1 -> System.out.print("Rock!\n");
                    case 2 -> System.out.print("Paper!\n");
                    case 3 -> System.out.print("Scissors!\n");
                }
                Thread.sleep(1000);

            //randomly generate cpu's choice & print
                cpuPlay = random.nextInt(1,3);
                System.out.print("The computer played: ");
                switch (cpuPlay) {
                    case 1 -> System.out.print("Rock!\n");
                    case 2 -> System.out.print("Paper!\n");
                    case 3 -> System.out.print("Scissors!\n");
                }
                Thread.sleep(1000);

                // print results of round & update wins variables
                if (play == 2 && cpuPlay == 1) {
                    System.out.println("Paper wraps rock! You win.");
                    playerWins += 1;
                } else if (cpuPlay == 2 && play == 1) {
                    System.out.println("Paper wraps rock! The computer wins.");
                    cpuWins += 1;
                } else if (play == 3 && cpuPlay == 2) {
                    System.out.println("Scissors cuts paper! You win.");
                    playerWins += 1;
                } else if (cpuPlay == 3 && play == 2) {
                    System.out.println("Scissors cuts paper! The computer win.");
                    cpuWins += 1;
                } else if (play == 1 && cpuPlay == 3) {
                    System.out.println("Rock breaks scissors! You win.");
                    playerWins += 1;
                } else if (cpuPlay == 1 && play == 3) {
                    System.out.println("Rock breaks scissors! The computer wins.");
                    cpuWins += 1;
                } else if (play == cpuPlay) {
                    System.out.println("It's a tie!");
                    ties += 1;
                }
                Thread.sleep(1000);
            }

            //declare winner
            System.out.printf("\nPlayer wins: %d\nComputer wins: %d\nTies: %d\n", playerWins, cpuWins, ties);
            Thread.sleep(1000);
            if (playerWins > cpuWins) {
                System.out.println("You won! Congratulations.");
            } else if (cpuWins > playerWins) {
                System.out.println("The computer won! Better luck next time.");
            } else {
                System.out.println("It's a tie overall!");
            }
            Thread.sleep(1000);

            //ask if user want to play again
            System.out.println("Would you like to play again? Enter 'yes' or 'no'!");
            playAgain = scanner.nextLine();

            if (playAgain.equals("no")) {
                System.out.println("Thanks for playing.");
                playing = false; // program stops running when playing is false
            }
            Thread.sleep(1000);
        }
    }

}
