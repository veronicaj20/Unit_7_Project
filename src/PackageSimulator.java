import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PackageSimulator {
    private ArrayList<Package> packages;
    private ArrayList<String> zipCodes;

    public PackageSimulator() {
        this.packages = new ArrayList<>();
        this.zipCodes = new ArrayList<>();
        readZipCodeFile("src/us_zip_codes");
    }

    // to read the file
    private void readZipCodeFile(String file) {
        File zipFile = new File(file);
        try (Scanner s = new Scanner(zipFile)) {
            while (s.hasNextLine()) {
                String zipCode = s.nextLine().trim();
                zipCodes.add(zipCode);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("No file available." + e.getMessage());
        }
    }

    public void generatePackages(int num) {
        for (int i = 0; i < num; i++) {
            // generate random origin and destination zip codes
            Collections.shuffle(zipCodes);
            String origin = zipCodes.get(0);
            String destination = zipCodes.get(1);

            // generate random dimensions and weight
            double weight = (Math.random() * 69) + 0.1;
            double length = (Math.random() * 38) + 2;
            double width = (Math.random() * 38) + 2;
            double height = (Math.random() * 38) + 2;

            // set addresses
            Address originAddress = new Address("123", "Random Street", "Apt 3C", "City", "State", origin);
            Address desAddress = new Address("123", "Random Street", "Apt 3C", "City", "State", destination);

            Package p = new Package(originAddress, desAddress, weight, width, length, height);
            packages.add(p);
        }
    }

    public double generateTotalCost() {
        double cost = 0.0;
        for (Package p : packages) {
            cost += PostageCalculator.calculatePostage(p);
        }
        return cost;
    }

    public void resetSimulation() {
        for (int i = packages.size() - 1; i >= 0; i--) {
            packages.remove(i);
        }
    }

    public void getSimulationInfo() {
        Scanner s = new Scanner(System.in);
        System.out.print("How many packages would you like to simulate? ");
        int numPackages = Integer.parseInt(s.nextLine());
        System.out.println("Randomly generated package info: ");

        generatePackages(numPackages);
        for (Package p : packages) {
            System.out.println("Package " + (packages.indexOf(p) + 1) + ": __________________________________________" );
            System.out.println("Origin address: " + p.getOrigin());
            System.out.println("Destination address: " + p.getDestination());
            System.out.println("Weight: " + p.getWeight());
            System.out.println("Height: " + p.getHeight());
            System.out.println("Length: " + p.getLength());
            System.out.println("Width: " + p.getWidth());
            System.out.println("Cost: $" + PostageCalculator.calculatePostage(p));
        }

        System.out.println();
        System.out.println("__________________________________________");
        System.out.println("Total cost of all packages: $" + generateTotalCost());
    }
}
