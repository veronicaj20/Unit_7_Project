import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("---------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1. Calculate the cost of one package");
        System.out.println("2. Simulate packages");
        System.out.println("3. How package costs are calculated");
        System.out.println("4. Exit");
        System.out.print("Input: ");
        int choice = Integer.parseInt(s.nextLine());
        System.out.println("---------------------------------");

        // choice 1
        if (choice == 1) {
            System.out.print("Enter the zip code of the origin package: ");
            String originChosen = s.nextLine();

            System.out.print("Enter the zip code of the destination package: ");
            String desChosen = s.nextLine();

            System.out.print("Enter the weight of the package: ");
            double weightChosen = Double.parseDouble(s.nextLine());

            System.out.print("Enter the height of the package: ");
            double heightChosen = Double.parseDouble(s.nextLine());

            System.out.print("Enter the length of the package: ");
            double lengthChosen = Double.parseDouble(s.nextLine());

            System.out.print("Enter the width of the package: ");
            double widthChosen = Double.parseDouble(s.nextLine());

            double cost = PostageCalculator.calculatePostage(originChosen, desChosen, weightChosen, widthChosen, lengthChosen, heightChosen);
            System.out.println("Cost: $" + cost);
        }






    }
}