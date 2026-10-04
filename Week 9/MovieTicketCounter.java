import java.util.*;

abstract class Ticket {
    abstract double calculateAmount(int count);
}

class Regular extends Ticket {
    double calculateAmount(int count) {
        return count * 150 + 20;
    }
}

class Premium extends Ticket {
    double calculateAmount(int count) {
        return count * 250 + 20;
    }
}

class Recliner extends Ticket {
    double calculateAmount(int count) {
        return count * 400 + 20;
    }
}

class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            Ticket t;

            if (type.equals("REGULAR")) {
                t = new Regular();
            } else if (type.equals("PREMIUM")) {
                t = new Premium();
            } else {
                t = new Recliner();
            }

            double amount = t.calculateAmount(count);

            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f", total);
    }
}