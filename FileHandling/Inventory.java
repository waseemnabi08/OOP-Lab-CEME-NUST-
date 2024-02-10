import java.io.*;
import java.util.*;


public class Inventory {
    List<Item> items = new ArrayList<Item>();
    double totalRevenue;

    public Inventory() {
        totalRevenue = 0;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void readFromFile() {
        try {
            File file = new File("inventory.dat");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                int stockQty = Integer.parseInt(tokens[2]);
                double costPerUnit = Double.parseDouble(tokens[3]);
                Item item = new Item(id, name, stockQty, costPerUnit);
                items.add(item);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("inventory.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Item item : items) {
                objectOut.writeObject(item);
            }
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void updateStock() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter item identification number: ");
            int itemId = scanner.nextInt();

            System.out.print("Enter quantity of stock to be added or removed: ");
            int quantity = scanner.nextInt();

            for (Item item : items) {
                if (item.getId() == itemId) {
                    int updatedStockQty = item.getStockQty() + quantity;
                    item.setStockQty(updatedStockQty);
                    break;
                }
            }

            writeToFile();
            scanner.close();

            System.out.println("Stock updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recordSale() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter item identification number: ");
            int itemId = scanner.nextInt();

            System.out.print("Enter quantity of stock sold: ");
            int quantity = scanner.nextInt();

            for (Item item : items) {
                if (item.getId() == itemId) {
                    int updatedStockQty = item.getStockQty() - quantity;
                    item.setStockQty(updatedStockQty);
                    totalRevenue += quantity * item.getCostPerUnit();
                    break;
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateStockReport() {
        System.out.println("Stock Report");
        System.out.println("============");
        for (Item item : items) {
            System.out.println(item);
            System.out.println();
        }
    }

    public void generateSalesReport() {
        System.out.println("Sales Report");
        System.out.println("============");
        System.out.println("Total Revenue: " + totalRevenue);
    }
}
