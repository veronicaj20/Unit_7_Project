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

        // choice 2
        else if (choice == 2) {
            PackageSimulator sim = new PackageSimulator();
            sim.getSimulationInfo();
        }

        // choice 3
        else if (choice == 3) {
            System.out.println("How the package costs are calculated:");
            System.out.println("~");
            System.out.println("- There is a base cost of $3.75 for every package.");
            System.out.println("- For every tenth of a pound, 5 cents are added.");
            System.out.println("- Then, find the county codes of your origin and destination zip codes, which are the first three numbers.");
            System.out.println("- Subtract the destination county code from the origin, and divide that by 100.");
            System.out.println("- Add that to your total.");
            System.out.println();

            System.out.println("- But you must account for if the package is oversized.");
            System.out.println("- Packages that are more than 40 pounds will be charged 10 cents every additional pound.");
            System.out.println("- If its dimensions exceed a total of 36 inches, every additional inch will also cost 10 cents.");
            System.out.println("- Adding all those numbers with your total gives you the final cost.");
        }

        // choice 4
        else if (choice == 4) {
            System.exit(0);
        }






    }
}