import java.util.Scanner;

//SP25-BCS-151
public class Main{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        HTMLValidator v=new HTMLValidator();
        ValidationHistory h=new ValidationHistory();

        System.out.println();

        int choice=0;

        // ye bar bar chaly ga choices select kryn gy hm
        while (choice != 3) {
            System.out.println();
            System.out.println("1.validate HTML string");
            System.out.println("2.show history");
            System.out.println("3.exit");
            System.out.print("choice:");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter HTML: ");
                String input = sc.nextLine().trim();
                String result = v.validate(input);
                System.out.println("Result: " + result);
                h.addrecord(input, result);

            }
            else if (choice == 2) {
                h.display();

            }
            else if (choice == 3) {
                System.out.println("exit");

            }
            else {
                System.out.println("invalid choice.");
            }
        }
        sc.close();
    }
}
