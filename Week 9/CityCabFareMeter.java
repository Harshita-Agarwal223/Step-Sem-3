import java.util.*;

abstract class Cab {
    abstract double calculateFare(double km);
}

class Mini extends Cab {
    double calculateFare(double km) {
        double fare = km * 10;

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

class Sedan extends Cab {
    double calculateFare(double km) {
        double fare = km * 14;

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

class SUV extends Cab {
    double calculateFare(double km) {
        double fare = km * 18;

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            if (type.equals("MINI") && time.equals("NIGHT")) {
                System.out.println("MINI: night service not available");
                continue;
            }

            Cab c;

            if (type.equals("MINI")) {
                c = new Mini();
            } else if (type.equals("SEDAN")) {
                c = new Sedan();
            } else {
                c = new SUV();
            }

            double fare = c.calculateFare(km);

            if (time.equals("NIGHT")) {
                fare = fare + fare * 0.20;
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f", total);
    }
}