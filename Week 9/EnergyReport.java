import java.util.*;

abstract class Appliance {
    abstract double getPower();

    abstract boolean saverAvailable();
}

class Fridge extends Appliance {
    double getPower() {
        return 150;
    }

    boolean saverAvailable() {
        return false;
    }
}

class AC extends Appliance {
    double getPower() {
        return 1500;
    }

    boolean saverAvailable() {
        return true;
    }
}

class TV extends Appliance {
    double getPower() {
        return 100;
    }

    boolean saverAvailable() {
        return false;
    }
}

class Washer extends Appliance {
    double getPower() {
        return 500;
    }

    boolean saverAvailable() {
        return true;
    }
}

class EnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] data = line.split(" ");

            String type = data[0];
            double hours = Double.parseDouble(data[1]);

            boolean saver = false;

            if (data.length == 3) {
                saver = true;
            }

            Appliance a;

            if (type.equals("FRIDGE")) {
                a = new Fridge();
            } else if (type.equals("AC")) {
                a = new AC();
            } else if (type.equals("TV")) {
                a = new TV();
            } else {
                a = new Washer();
            }

            if (saver && !a.saverAvailable()) {
                System.out.println(type + ": saver mode not supported");
            } else {
                double units = a.getPower() * hours / 1000;

                if (saver) {
                    units = units * 0.75;
                }

                double cost = units * 8;

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
                );

                totalCost += cost;
            }
        }

        System.out.printf("Total Cost: %.2f", totalCost);
    }
}