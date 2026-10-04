import java.util.*;

abstract class Parcel {
    abstract double calculateCharge(double weight);

    abstract double calculateInsurance(double value);
}

class Standard extends Parcel {
    double calculateCharge(double weight) {
        return 40 + 10 * weight;
    }

    double calculateInsurance(double value) {
        return 0;
    }
}

class Express extends Parcel {
    double calculateCharge(double weight) {
        return 80 + 15 * weight;
    }

    double calculateInsurance(double value) {
        return value * 0.02;
    }
}

class Fragile extends Parcel {
    double calculateCharge(double weight) {
        return 40 + 10 * weight + 50;
    }

    double calculateInsurance(double value) {
        return value * 0.02;
    }
}

class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel p;

            if (type.equals("STANDARD")) {
                p = new Standard();
            } else if (type.equals("EXPRESS")) {
                p = new Express();
            } else {
                p = new Fragile();
            }

            double charge = p.calculateCharge(weight);
            double insurance = p.calculateInsurance(value);
            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f", grandTotal);
    }
}