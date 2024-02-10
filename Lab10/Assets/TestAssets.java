import java.util.ArrayList;
import java.util.Scanner;

public class TestAssets {

    ArrayList<Asset> assets = new ArrayList<Asset>();
    ArrayList<ElectronicAppliance> electronicAppliances = new ArrayList<ElectronicAppliance>();
    ArrayList<Automobile> automobiles = new ArrayList<Automobile>();
    ArrayList<Furniture> furniture = new ArrayList<Furniture>();
    ArrayList<CompactDisk> compactDisks = new ArrayList<CompactDisk>();
    Scanner sc = new Scanner(System.in);

    public void addAsset() {
        System.out.println("1. Electronic Appliance\n2. Automobile\n3. Furniture\n4. Compact Disk");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter serial number: ");
        String serialNumber = sc.nextLine();
        if (choice == 1) {
            System.out.print("Enter brand: ");
            String brand = sc.nextLine();
            System.out.print("Enter model: ");
            String model = sc.nextLine();
            System.out.print("Enter price: ");
            String voltage = sc.nextLine();
            System.out.print("Enter frequency: ");
            String frequency = sc.nextLine();
            assets.add(new ElectronicAppliance(name, serialNumber, brand, model, voltage, frequency));
            electronicAppliances.add(new ElectronicAppliance(name, serialNumber, brand, model, voltage, frequency));
        } else if (choice == 2) {
            System.out.print("Enter make: ");
            String make = sc.nextLine();
            System.out.print("Enter model: ");
            String model = sc.nextLine();
            System.out.print("Enter year: ");
            int year = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter mileage: ");
            double mileage = sc.nextDouble();
            sc.nextLine();
            assets.add(new Automobile(name, serialNumber, make, model, year, mileage));
            automobiles.add(new Automobile(name, serialNumber, make, model, year, mileage));
        } else if (choice == 3) {
            System.out.print("Enter material: ");
            String material = sc.nextLine();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            assets.add(new Furniture(name, serialNumber, material, price));
            furniture.add(new Furniture(name, serialNumber, material, price));
        } else if (choice == 4) {
            System.out.print("Enter artist: ");
            String artist = sc.nextLine();
            System.out.print("Enter number of tracks: ");
            int numberOfTracks = sc.nextInt();
            sc.nextLine();
            assets.add(new CompactDisk(name, serialNumber, artist, numberOfTracks));
            compactDisks.add(new CompactDisk(name, serialNumber, artist, numberOfTracks));
        }
    }

    public void modifyAsset() {
        System.out.print("Enter serial number: ");
        String serialNumber = sc.nextLine();
        for (Asset asset : assets) {
            if (asset.getSerialNumber().equals(serialNumber)) {
                if (asset instanceof ElectronicAppliance) {
                    System.out.print("Enter brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter model: ");
                    String model = sc.nextLine();
                    System.out.print("Enter voltage: ");
                    String volt = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Enter Frequecny: ");
                    String frequency = sc.nextLine();
                    sc.nextLine();
                    ((ElectronicAppliance) asset).setBrand(brand);
                    ((ElectronicAppliance) asset).setModel(model);
                    ((ElectronicAppliance) asset).setVoltage(volt);
                    ((ElectronicAppliance) asset).setFrequency(frequency);
                } else if (asset instanceof Automobile) {
                    System.out.print("Enter make: ");
                    String make = sc.nextLine();
                    System.out.print("Enter model: ");
                    String model = sc.nextLine();
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter mileage: ");
                    double mileage = sc.nextDouble();
                    sc.nextLine();
                    ((Automobile) asset).setMake(make);
                    ((Automobile) asset).setModel(model);
                    ((Automobile) asset).setYear(year);
                    ((Automobile) asset).setMileage(mileage);
                } else if (asset instanceof Furniture) {
                    System.out.print("Enter material: ");
                    String material = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    ((Furniture) asset).setMaterial(material);
                    ((Furniture) asset).setPrice(price);
                } else if (asset instanceof CompactDisk) {
                    System.out.print("Enter artist: ");
                    String artist = sc.nextLine();
                    System.out.print("Enter number of tracks: ");
                    int numberOfTracks = sc.nextInt();
                    ((CompactDisk) asset).setArtist(artist);
                    ((CompactDisk) asset).setNumberOfTracks(numberOfTracks);
                }
            }
        }
    }

    public void deleteAsset() {
        System.out.print("Enter serial number: ");
        String serialNumber = sc.nextLine();
        for (Asset asset : assets) {
            if (asset.getSerialNumber().equals(serialNumber)) {
                assets.remove(asset);
                if (asset instanceof ElectronicAppliance) {
                    electronicAppliances.remove(asset);
                } else if (asset instanceof Automobile) {
                    automobiles.remove(asset);
                } else if (asset instanceof Furniture) {
                    furniture.remove(asset);
                } else if (asset instanceof CompactDisk) {
                    compactDisks.remove(asset);
                }
            }
        }
    }

    public void listAssets() {
        System.out.println("1. Electronic Appliance\n2. Automobile\n3. Furniture\n4. Compact Disk");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            for (ElectronicAppliance electronicAppliance : electronicAppliances) {
                System.out.println(electronicAppliance);
            }
        } else if (choice == 2) {
            for (Automobile automobile : automobiles) {
                System.out.println(automobile);
            }
        } else if (choice == 3) {
            for (Furniture furniture : furniture) {
                System.out.println(furniture);
            }
        } else if (choice == 4) {
            for (CompactDisk compactDisk : compactDisks) {
                System.out.println(compactDisk);
            }
        }
    }

    public void searchAsset() {
        System.out.print("Enter serial number: ");
        String serialNumber = sc.nextLine();
        for (Asset asset : assets) {
            if (asset.getSerialNumber().equals(serialNumber)) {
                System.out.println(asset);
            }
        }
    }


    public static void main(String[] args) {
        TestAssets testAssets = new TestAssets();
        while (true) {
            System.out.println("1. Add asset\n2. Modify asset\n3. Delete asset\n4. List assets\n5. Search asset\n6. Exit");
            System.out.print("Enter choice: ");
            int choice = testAssets.sc.nextInt();
            testAssets.sc.nextLine();
            if (choice == 1) {
                testAssets.addAsset();
            } else if (choice == 2) {
                testAssets.modifyAsset();
            } else if (choice == 3) {
                testAssets.deleteAsset();
            } else if (choice == 4) {
                testAssets.listAssets();
            } else if (choice == 5) {
                testAssets.searchAsset();
            } else if (choice == 6) {
                break;
            }
        }
    }




}
