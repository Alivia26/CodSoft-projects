import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = scanner.nextInt();

        int[] marks = new int[numOfSubjects];
        int total = 0;

        System.out.println("Enter the marks obtained in each subject:");
        for (int i = 0; i < numOfSubjects; i++) {
            marks[i] = scanner.nextInt();
            total += marks[i];
        }

        float avgPercentage = (float) total / numOfSubjects;

        System.out.println("Total marks: " + total);
        System.out.println("Average percentage: " + avgPercentage + "%");

        if (avgPercentage >= 80) {
            System.out.println("Grade: A");
        } else if (avgPercentage >= 60) {
            System.out.println("Grade: B");
        } else if (avgPercentage >= 40) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: D");
        }
    }
}