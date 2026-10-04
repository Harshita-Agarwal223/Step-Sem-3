import java.util.*;

abstract class Student {
    abstract double calculateFee();
}

class DayScholar extends Student {
    double calculateFee() {
        return 40000 + 12000;
    }
}

class Hosteller extends Student {
    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {
    double calculateFee() {
        return 20000 + 12000;
    }
}

class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s;

            if (type.equals("DAY_SCHOLAR")) {
                s = new DayScholar();
            } else if (type.equals("HOSTELLER")) {
                s = new Hosteller();
            } else {
                s = new Scholar();
            }

            double fee = s.calculateFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f", total);
    }
}