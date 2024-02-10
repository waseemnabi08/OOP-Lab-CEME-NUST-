
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TodoList {
    private static final String FILE_PATH = "/Users/wasee/Downloads/71526248-main/OOP-Lab/FileHandling/todo_list.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add New Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Display Pending Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    markTaskAsCompleted();
                    break;
                case 3:
                    displayPendingTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addNewTask() {
        try {
            File file = new File(FILE_PATH);
            FileWriter writer = new FileWriter(file, true);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter task description: ");
            String taskDescription = scanner.nextLine();

            int taskId = getTaskId();
            String taskStatus = "Incomplete";

            writer.write(taskId + "," + taskDescription + "," + taskStatus + "\n");
            writer.close();

            System.out.println("Task added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the task.");
        }
    }

    private static int getTaskId() {
        int taskId = 1;

        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length > 0) {
                    int id = Integer.parseInt(parts[0]);
                    if (id >= taskId) {
                        taskId = id + 1;
                    }
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while getting the task ID.");
        }

        return taskId;
    }

    private static void markTaskAsCompleted() {
        try {
            File file = new File(FILE_PATH);
            File tempFile = new File(FILE_PATH + ".tmp");
            FileWriter writer = new FileWriter(tempFile);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter task ID: ");
            int taskId = scanner.nextInt();

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length > 0) {
                    int id = Integer.parseInt(parts[0]);
                    String description = parts[1];
                    String status = parts[2];

                    if (id == taskId) {
                        status = "Complete";
                    }

                    writer.write(id + "," + description + "," + status + "\n");
                }
            }

            writer.close();
            fileScanner.close();

            if (file.delete()) {
                tempFile.renameTo(file);
                System.out.println("Task marked as completed successfully.");
            } else {
                System.out.println("An error occurred while marking the task as completed.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while marking the task as completed.");
        }
    }

    private static void displayPendingTasks() {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            System.out.println("Pending Tasks:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length > 0) {
                    int id = Integer.parseInt(parts[0]);
                    String description = parts[1];
                    String status = parts[2];

                    if (status.equals("Incomplete")) {
                        System.out.println(id + ": " + description);
                    }
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while displaying the pending tasks.");
        }
    }
}
