import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by molayodecker on 20/08/2016.
 */
public class Prompter {
    Jar jar = new Jar("Coins", 1);
    public Prompter() {
        Random random = new Random();
        System.out.println("ADMINISTRATOR SETUP");
        System.out.println("==============================");
        Scanner stdin = new Scanner(System.in);
        System.out.printf("Name of items in the jar: ");
        jar.item = stdin.next();
        System.out.printf("Maximum number of %s in the jar: ", jar.getItem());
        //Fix if user does not type an integer
        try {
            jar.maxItemAllowed = stdin.nextInt();
        }catch (InputMismatchException e){
                throw new InputMismatchException("You enter a invalid input ");
        }
        //Randomize number
        int randomizer = random.nextInt(jar.maxItemAllowed);
        System.out.printf("PLAYER %n%n");
        System.out.printf("============================== %n%n");
        System.out.printf("Your goal is to how many %s are in the jar. Your guess should be between 1 and %d %n%n", jar.getItem(), jar.getmaxNumber());
        System.out.printf("Ready? (Press Enter to start guessing)%n%n");
        int guessedNumber = 0;
        int count = 0;
        do {
            System.out.printf("Guess : ");
            guessedNumber = stdin.nextInt();
            count++;
            if (guessedNumber > jar.getmaxNumber()) {
                System.out.printf("Your guess of %s is too high %n", guessedNumber);
                count--;
            } else if (guessedNumber < 1) {
                System.out.printf("Your guess of %s is too low %n", guessedNumber);
                count--;
            } else if (guessedNumber == randomizer) {
                System.out.printf("Congratulations - you guessed " +
                        "that there are %d %s in the jar " +
                        "it took you %d guess(es) to get is right. %n", guessedNumber, jar.getItem(), count);
                System.exit(0);
            }
        } while (guessedNumber != randomizer);
    }
}