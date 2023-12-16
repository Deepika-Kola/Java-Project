import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class FeeManagementSystem {
    Map<Integer, Double> feeRecords;

    public FeeManagementSystem() {
        feeRecords = new HashMap<>();
    }

    public void addStudent(Student student, double initialFee) {
        feeRecords.put(student.id, initialFee);
    }

    public void makePayment(Student student, double amount) {
        if (feeRecords.containsKey(student.id)) {
            double currentBalance = feeRecords.get(student.id);
            feeRecords.put(student.id, currentBalance - amount);
            System.out.println("Payment successful. Remaining balance: $" + feeRecords.get(student.id));
        } else {
            System.out.println("Student not found in the records.");
        }
    }

    public void displayBalance(Student student) {
        if (feeRecords.containsKey(student.id)) {
            System.out.println("Student: " + student.name);
            System.out.println("Current balance: $" + feeRecords.get(student.id));
        } else {
            System.out.println("Student not found in the records.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the fee management system
        FeeManagementSystem feeManagementSystem = new FeeManagementSystem();

        // Add some sample students
        feeManagementSystem.addStudent(new Student("John Doe", 101), 1000);
        feeManagementSystem.addStudent(new Student("Jane Smith", 102), 1500);

        // User interaction loop
        while (true) {
            System.out.println("\n1. Make Payment");
            System.out.println("2. Display Balance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter payment amount: $");
                    double paymentAmount = scanner.nextDouble();
                    feeManagementSystem.makePayment(new Student("", studentId), paymentAmount);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    feeManagementSystem.displayBalance(new Student("", id));
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
