import java.util.Scanner;
class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your name: ");
        String input = scanner.nextLine();
       System.out.println("Hello " + input);
       System.out.print("Your age: ");
       System.out.println("Age: " + scanner.nextInt());
       scanner.close();
    }
}
