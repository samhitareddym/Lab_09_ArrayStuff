import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner instance
        Random rnd = new Random();
        int[] dataPoints = new int[100];
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;  // generates values from 1 to 100
        }
        for (int i = 0; i < dataPoints.length; i++) {
            if (i == dataPoints.length - 1) {
                System.out.print(dataPoints[i]);
            } else {
                System.out.print(dataPoints[i] + " | ");
            }
        }
        System.out.println();
        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }
        double average = sum / (double) dataPoints.length;
        System.out.println("The sum of the dataPoints array is: " + sum);
        System.out.println("The average of the dataPoints array is: " + average);

        // Part 2: Linear Scan (Search)
        // Task 5: Prompt the user for a value between 1 and 100
        int userValue = SafeInput.getRangedInt(scanner, "Enter a value between 1 and 100: ", 1, 100);

        // Task 6: Count how many times the user's value is found in dataPoints
        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue) {
                count++; // Increment count if value matches user input
            }
        }
        System.out.println("The value " + userValue + " was found " + count + " times in the array.");
        //Task 7: Find the first position of the user's value
        int position = -1; // Initialize position as -1 (not found)
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                position = i; // Store the index of the first occurrence
                break; // Exit loop once found
            }
        }
        if (position != -1) {
            System.out.println("The value " + userValue + " was found at array index " + position + ".");
        } else {
            System.out.println("The value " + userValue + " was not found in the array.");
        }
        // Task 8: Find minimum and maximum values in dataPoints
        int min = dataPoints[0];
        int max = dataPoints[0];

        for (int value : dataPoints) {
            if (value < min) {
                min = value; // Update min
            }
            if (value > max) {
                max = value; // Update max
            }
        }
        System.out.println("The minimum value in the array is: " + min);
        System.out.println("The maximum value in the array is: " + max);

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }
    // Task 9: Create a static method to calculate the average
    public static double getAverage(int[] values) {
        if (values.length == 0) {
            return 0; // Return 0 if the array is empty to avoid division by zero
        }
        int sum = 0;
        for (int value : values) {
            sum += value; // Calculate the sum of the elements
        }
        return (double) sum / values.length; // Return the average as a double
    }
}
