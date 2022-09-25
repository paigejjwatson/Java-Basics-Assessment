import java.util.Scanner;

public class HealthyHearts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age;
        System.out.print("What is your age? ");
        age = scanner.nextInt();
        scanner.nextLine();

        int maxHeartRate = 220 - age; // max HR
        int lowerHeartRate = maxHeartRate / 2; // lower boundary of target HR - 50% of max
        int upperHeartRate = (int)Math.ceil((85 / 100f) * maxHeartRate); // upper target HR bound - 85% of max

        System.out.printf("Your maximum heart rate should be %d beats per minute\n", maxHeartRate);
        System.out.printf("Your target HR Zone is %d - %d beats per minute", lowerHeartRate, upperHeartRate);

    }
}
