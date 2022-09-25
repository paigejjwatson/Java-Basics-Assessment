public class SummativeSums {

    public static void main(String[] args) {

        int[] array = {}; // array to sum
        int sum = sumInts(array); // sum of array elements
        System.out.printf("Array sum: %d", sum);
    }

    /** returns sum of all elements in given integer array **/
    public static Integer sumInts(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num; // increment total sum by current number
        }
        return sum;
    }

}
