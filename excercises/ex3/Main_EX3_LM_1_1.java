package ap.excercises.ex3;
import java.util.*;

class Book {
    private String title;
    private String author;
    private int pages;
    private int year;

    public Book(String title, String author, int pages, int year) {
        this.title = title;
        this.author = author;
        this.pages = pages;


        this.year = year;



    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPages(int pages) { this.pages = pages; }
    public void setYear(int year) { this.year = year; }

    public void displayInfo() {
        System.out.println("Book: " + title + " | Author: " + author + " | Pages: " + pages + " | Year: " + year);
    }
}

class Student {
    private String firstName;
    private String lastName;

    private String studentId;
    private String major;

    public Student(String firstName, String lastName, String studentId, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.major = major;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setMajor(String major) { this.major = major; }

    public void displayInfo() {
        System.out.println("Student: " + firstName + " " + lastName + " | Student ID: " + studentId + " | Major: " + major);
    }
}

public class Main_EX3_LM_1_1 {
    static Scanner scanner = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Predefined data
        books.add(new Book("Java Programming", "James Gosling", 450, 1995));
        books.add(new Book("Data Structures", "Mark Weiss", 600, 2002));

        students.add(new Student("Ali", "Ahmadi", "14001234", "Computer Engineering"));
        students.add(new Student("Sara", "Moradi", "14005678", "Electrical Engineering"));

        int choice = 0;
        while (choice != 7) {
            showMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {
                addBook();
            } else if (choice == 2) {
                addStudent();
            } else if (choice == 3) {
                editStudent();
            } else if (choice == 4) {
                editBook();
            } else if (choice == 5) {
                displayAllBooks();
            } else if (choice == 6) {
                displayAllStudents();
            } else if (choice == 7) {
                System.out.println("Exiting... Goodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n===== University Library Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. Add Student");
        System.out.println("3. Edit Student Information (by First Name)");
        System.out.println("4. Edit Book Information (by Title)");
        System.out.println("5. Display All Books");
        System.out.println("6. Display All Students");
        System.out.println("7. Exit");
        System.out.print("Select an option: ");
    }

    public static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter number of pages: ");
        int pages = scanner.nextInt();
        System.out.print("Enter year of publication: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 

        books.add(new Book(title, author, pages, year));
        System.out.println("Book added successfully!");
    }

    public static void addStudent() {
        System.out.print("enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter major: ");
        String major = scanner.nextLine();

        students.add(new Student(firstName, lastName, studentId, major));
        System.out.println("Student added successfully!");
    }

    public static void editStudent() {
        System.out.print("Enter first name of the student to edit: ");
        String name = scanner.nextLine();

        for (Student s : students) {
            if (s.getFirstName().equalsIgnoreCase(name)) {
                System.out.print("Enter new last name: ");
                s.setLastName(scanner.nextLine());
                System.out.print("Enter new student ID: ");
                s.setStudentId(scanner.nextLine());
                System.out.print("Enter new major: ");
                s.setMajor(scanner.nextLine());
                System.out.println("Student information updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void editBook() {
        System.out.print("enter the title of the book to edit: ");
        String title = scanner.nextLine();

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.print("Enter new author: ");
                b.setAuthor(scanner.nextLine());
                System.out.print("Enter new number of pages: ");
                b.setPages(scanner.nextInt());
                System.out.print("Enter new year of publication: ");
                b.setYear(scanner.nextInt());
                scanner.nextLine();
                System.out.println("book information updated.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void displayAllBooks() {
        System.out.println("\n--- List of Books ---");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                b.displayInfo();
            }
        }
    }

    public static void displayAllStudents() {
        System.out.println("\n--- list of Students ---");
        if (students.isEmpty()) {
            System.out.println("no students registered.");
        } else {
            for (Student s : students) {
                s.displayInfo();
            }
        }
    }
}