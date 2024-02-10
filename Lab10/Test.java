import java.util.ArrayList;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<Pet>();
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        ArrayList<Cat> cats = new ArrayList<Cat>();
        Scanner sc = new Scanner(System.in);
        String name, type;
        while (true) {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            if (name.equals("STOP")) break;
            System.out.print("Enter type (c for cat, d for dog): ");
            type = sc.nextLine();
            if (type.equals("c")) {
                System.out.print("Enter color: ");
                String color = sc.nextLine();
                pets.add(new Cat(name, color));
            } else if (type.equals("d")) {
                System.out.print("Enter weight: ");
                double weight = sc.nextDouble();
                pets.add(new Dog(name, weight));
                dogs.add(new Dog(name, weight));
            }
            sc.nextLine();
        }
        //calculate average, min and max weight of dogs
        double sum = 0, min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        for (Dog dog : dogs) {
            sum += dog.getWeight();
            if (dog.getWeight() < min) min = dog.getWeight();
            if (dog.getWeight() > max) max = dog.getWeight();
        }

        //print all pets
        for (Pet pet : pets) {
            System.out.println(pet);
        }

        //print average, min and max weight of dogs
        System.out.println("Average weight of dogs: " + sum / dogs.size());
        System.out.println("Min weight of dogs: " + min);
        System.out.println("Max weight of dogs: " + max);

        while (true) {
            System.out.println("1. Add cat\n 2. Add dog\n 3. Remove cat\n 4. remove dog\n 5. exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Enter name: ");
                name = sc.nextLine();
                System.out.print("Enter color: ");
                String color = sc.nextLine();
                pets.add(new Cat(name, color));
            } else if (choice == 2) {
                System.out.print("Enter name: ");
                name = sc.nextLine();
                System.out.print("Enter weight: ");
                double weight = sc.nextDouble();
                pets.add(new Dog(name, weight));
                dogs.add(new Dog(name, weight));
            } else if (choice == 3) {
                System.out.print("Enter name: ");
                name = sc.nextLine();
                for (int i = 0; i < pets.size(); i++) {
                    if (pets.get(i).getName().equals(name)) {
                        pets.remove(i);
                        break;
                    }
                }
            } else if (choice == 4) {
                System.out.print("Enter name: ");
                name = sc.nextLine();
                for (int i = 0; i < pets.size(); i++) {
                    if (pets.get(i).getName().equals(name)) {
                        pets.remove(i);
                        break;
                    }
                }
                for (int i = 0; i < dogs.size(); i++) {
                    if (dogs.get(i).getName().equals(name)) {
                        dogs.remove(i);
                        break;
                    }
                }
            } else if (choice == 5) {
                break;
            }
        }
        sc.close();
    }
}
