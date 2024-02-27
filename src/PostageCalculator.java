public class PostageCalculator {

    // method to calculate oversized packages
    public static double calculateSizeCost(double width, double length, double height) {
        double size = width + length + height;
        if (size > 36) {
            return (size - 36) * 0.1;
        }
        else {
            return 0;
        }
    }

    // method to calculate overweight packages
    public static double calculateWeightCost(double weight) {
        double additionalWeight = weight - 40;
        if (additionalWeight > 0) {
            return (additionalWeight * 10) * 0.1;
        }
        else {
            return weight * 10 * 0.05;
        }
    }

    public static double calculatePostage(String originZip, String destinationZip, double weight, double width, double length, double height) {
        double base = 3.75;
        // getting county codes
        int originCC = Integer.parseInt(originZip.substring(0,3));
        int destinationCC = Integer.parseInt(destinationZip.substring(0,3));
        double diffCC = Math.abs(originCC - destinationCC) / 100.0;

        double sizeCost = calculateSizeCost(width, length, height);
        double weightCost = calculateWeightCost(weight);

        double total = base + diffCC + sizeCost + weightCost;
        return Math.round(total * 100.0) / 100.0;
    }

    public static double calculatePostage(Address origin, Address destination, double weight, double width, double length, double height) {
        return calculatePostage(origin.getZip(), destination.getZip(), weight, width, length, height);
    }

    public static double calculatePostage(Package p) {
        return calculatePostage(p.getOrigin(), p.getDestination(), p.getWeight(), p.getWidth(), p.getLength(), p.getHeight());
    }
}
