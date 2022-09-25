import java.util.*;

public class DogGenetics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int breedIndex;
        int percentage;
        List<String> dogBreeds = new ArrayList<>();
        Collections.addAll(dogBreeds, "Giant Schauzer", "Alpine Dachsbracke", "West highland terrier", "Chihuahua", "American foxhound", "Staffordshire bull terrier", "Golden retriever", "Border collie", "Cockapoo", "Bernese mountain dog", "Rottweiler", "Fox terrier", "Entlebucher mountain dog", "Affenpinscher", "Shiba inu", "Dachshund", "Bloodhound", "Great Pyrenees");

        // ask for dogs name
        String dogName;
        System.out.print("What is your dog's name? ");
        dogName = scanner.nextLine();

        System.out.printf("Well then, I have this highly reliable report on %s's prestigious background right here.\n", dogName);
        System.out.printf("\n%s is:\n\n", dogName);

        // print percentages
        int total = 100; // starting percentage - 100%
        for (int i=0; i<5; i++) {
            breedIndex = random.nextInt(dogBreeds.size()); // choose random breed from dogBreeds list
            if (i == 4) {
                percentage = total; // for final breed, percentage is the remaining numbers from 100.
            } else {
                percentage = random.nextInt(1, (int)(80/100f * total)); // percentage can be from 1 to 80% of the remaining percentage (as a safety boundary so total isn't drained too quickly)
            }
            System.out.printf("%d%% %s\n", percentage, dogBreeds.get(breedIndex));
            total -= percentage; // how much out of 100 is left to assign
            dogBreeds.remove(breedIndex); // remove breed from list so it is not chosen again
        }
        System.out.println("\nWow, that's QUITE the dog!");
    }






}
