import java.util.Scanner;

public class Student {
    private static final int STUDENT_ID_OFFSET = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = getInput("Enter the number of students: ", scanner);
        int numSubjects = getInput("Enter the number of subjects: ", scanner);

        int[][] grades = getStudentGrades(numStudents, numSubjects, scanner);

        double[] studentAverages = calculateAverages(grades, true);
        double[] subjectAverages = calculateAverages(grades, false);

        int highestAverageStudentIndex = findHighestAverageIndex(studentAverages);
        int highestAverageSubjectIndex = findHighestAverageIndex(subjectAverages);

        int searchStudentId = getInput("Enter the student ID to search: ", scanner);
        int searchStudentIndex = findStudentIndex(searchStudentId, numStudents);

        displayStudentGrades(grades, numStudents, numSubjects);
        displayAverages("Average Grade for Each Student:", studentAverages, numStudents);
        displayAverages("Average Grade for Each Subject:", subjectAverages, numSubjects);
        displayHighestAverage("Student with the Highest Average Grade:", highestAverageStudentIndex);
        displayHighestAverage("Subject with the Highest Average Grade:", highestAverageSubjectIndex);

        displaySearchResult(searchStudentIndex, searchStudentId);

        scanner.close();
    }

    private static int getInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }

    private static int[][] getStudentGrades(int numStudents, int numSubjects, Scanner scanner) {
        int[][] grades = new int[numStudents][numSubjects];

        for (int studentIndex = 0; studentIndex < numStudents; studentIndex++) {
            System.out.println("Enter the grades for student " + (studentIndex + STUDENT_ID_OFFSET) + ":");
            for (int subjectIndex = 0; subjectIndex < numSubjects; subjectIndex++) {
                System.out.print("Enter the grade for subject " + (subjectIndex + 1) + ": ");
                grades[studentIndex][subjectIndex] = scanner.nextInt();
            }
        }
        return grades;
    }

    private static double[] calculateAverages(int[][] grades, boolean isStudent) {
        int numItems = isStudent ? grades.length : grades[0].length;
        double[] averages = new double[numItems];

        for (int i = 0; i < numItems; i++) {
            int sum = 0;
            for (int j = 0; j < (isStudent ? grades[i].length : grades.length); j++) {
                sum += isStudent ? grades[i][j] : grades[j][i];
            }
            averages[i] = (double) sum / (isStudent ? grades[i].length : grades.length);
        }
        return averages;
    }

    private static int findHighestAverageIndex(double[] averages) {
        int highestAverageIndex = 0;
        for (int i = 1; i < averages.length; i++) {
            if (averages[i] > averages[highestAverageIndex]) {
                highestAverageIndex = i;
            }
        }
        return highestAverageIndex;
    }

    private static int findStudentIndex(int searchStudentId, int numStudents) {
        for (int i = 0; i < numStudents; i++) {
            if (searchStudentId == (i + STUDENT_ID_OFFSET)) {
                return i;
            }
        }
        return -1;
    }

    private static void displayStudentGrades(int[][] grades, int numStudents, int numSubjects) {
        System.out.println("Student Grades:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student " + (i + STUDENT_ID_OFFSET) + ": ");
            for (int j = 0; j < numSubjects; j++) {
                System.out.print(grades[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void displayAverages(String message, double[] averages, int numItems) {
        System.out.println(message);
        for (int i = 0; i < numItems; i++) {
            System.out.println((message.contains("Student") ? "Student " : "Subject ") + (i + STUDENT_ID_OFFSET) + ": " + averages[i]);
        }
    }

    private static void displayHighestAverage(String message, int highestAverageIndex) {
        System.out.println(message + " " + (highestAverageIndex + STUDENT_ID_OFFSET));
    }

    private static void displaySearchResult(int searchStudentIndex, int searchStudentId) {
        if (searchStudentIndex != -1) {
            System.out.println("Student " + (searchStudentIndex + STUDENT_ID_OFFSET) + " found with ID " + searchStudentId);
        } else {
            System.out.println("Student with ID " + searchStudentId + " not found");
        }
    }
}
