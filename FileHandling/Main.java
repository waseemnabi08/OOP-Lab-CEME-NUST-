import java.util.Scanner;

public class Main {

    public void displayMenu() {
        System.out.println("1. Update Stock");
        System.out.println("2. Record Sale");
        System.out.println("3. Generate Stock Report");
        System.out.println("4. Generate Sales Report");
        System.out.println("5. Save and Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Item item = new Item(1, "Item 1", 10, 100);
        Item item2 = new Item(2, "Item 2", 20, 200);
        Item item3 = new Item(3, "Item 3", 30, 300);
        inventory.addItem(item);
        inventory.addItem(item2);
        inventory.addItem(item3);
        Main main = new Main();
        int choice;

        try {
            inventory.readFromFile();
        } catch (Exception e) {
            System.out.println("Error reading from file.");
        }

        try {
            while(true) {
                main.displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        inventory.updateStock();
                        break;
                    case 2:
                        inventory.recordSale();
                        break;
                    case 3:
                        inventory.generateStockReport();
                        break;
                    case 4:
                        inventory.generateSalesReport();
                        break;
                    case 5:
                        inventory.writeToFile();
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } 
        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            scanner.close();
        }
    }
}
