class Staff {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Staff(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new Staff("Divya", 65000);
        new Staff("Arjun", 30000);
        new Staff("Priya", 40000);

        Staff.printCompanyInfo();
    }
}
