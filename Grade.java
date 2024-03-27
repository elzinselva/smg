import java.util.Scanner;

public class Grade{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Student information
        System.out.println("Enter student name: ");
        String sName = scanner.nextLine();

        System.out.println("Enter department: ");
        String dep = scanner.nextLine();

        

        int totSubjects;
        do {
            System.out.println("Enter the total number of subjects: ");
            totSubjects = scanner.nextInt();
            if (totSubjects <= 0) {
                System.out.println("Please enter a valid number of subjects.");
            }
        } while (totSubjects <= 0);

        int[] subjectMarks = new int[totSubjects];
        int totMarks = 0;

        for (int i = 0; i < totSubjects; i++) {
            System.out.println("Enter marks for Subject " + (i + 1) +"(out of 100)"+ ": ");
            subjectMarks[i] = scanner.nextInt();
            totMarks += subjectMarks[i];
        }

        // Calculation: Total Marks
        double avgPercentage = (double) totMarks / totSubjects;

        // Grade Calculation
        char grade;
        if (avgPercentage >= 90) {
            grade = 'O';
        } else if (avgPercentage >= 80) {
            grade = 'A';
        } else if (avgPercentage >= 70) {
            grade = 'B';
        } else if (avgPercentage >= 60) {
            grade = 'C';
        } else {
            grade = 'D';
        }
  // Display results
        System.out.println("----- Results -----");
        System.out.println("Student Name: " + sName);
        System.out.println("Department: " + dep);
        System.out.println("Total Marks: " + totMarks);
        System.out.println("Average Percentage: " + avgPercentage);
        System.out.println("Grade: " + grade);

        // Close the scanner
        scanner.close();
    }
}