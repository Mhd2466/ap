package ap.excercises.ex4;

public class E3_12 {
    public static void main(String[] args) {
        Employee harry = new Employee("Hacker, Harry", 50000);

        // Test getName and getSalary
        System.out.println("Name: " + harry.getName()); // Should print "Hacker, Harry"
        System.out.println("Salary: " + harry.getSalary()); // Should print 50000.0

        // Give Harry a 10% raise
        harry.raiseSalary(10);

        // Test new salary
        System.out.println("New Salary after 10% raise: " + harry.getSalary()); // Should print 55000.0
    }
//the class
    public class Employee {
        private String name;
        private double salary;
    
        public Employee(String employeeName, double currentSalary) {
            name = employeeName;
            salary = currentSalary;
        }
    
        public String getName() {
            return name;
        }
    
        public double getSalary() {
            return salary;
        }
    
        public void raiseSalary(double byPercent) {
            salary = salary + salary * byPercent / 100;
        }
    }
    
}

