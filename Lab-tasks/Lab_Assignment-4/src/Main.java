
//SP25-BCS-151

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // User se array size lena
        System.out.print("Enter Size of Hash Table:");
        int size = input.nextInt();
        input.nextLine();
        HashTable table = new HashTable(size);

        int choice;

        do {
            System.out.println();
            System.out.println("Hash table menu select one");
            System.out.println();
            System.out.println("1. Insert");
            System.out.println("2. search");
            System.out.println("3. delete");
            System.out.println("4. display");
            System.out.println("5. exit");

            System.out.print("Enter Choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Key:");
                    String key = input.nextLine();
                    System.out.print("Enter Value:");
                    String value = input.nextLine();
                    table.insert(key, value);
                    break;

                case 2:
                    System.out.print("Enter Key to Search: ");
                    String searchKey = input.nextLine();
                    table.search(searchKey);
                    break;

                case 3:
                    System.out.print("Enter Key to Delete: ");
                    String deleteKey = input.nextLine();
                    table.delete(deleteKey);
                    break;

                case 4:
                    table.display();
                    break;

                case 5:
                    System.out.println("End");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
        input.close();
    }
}