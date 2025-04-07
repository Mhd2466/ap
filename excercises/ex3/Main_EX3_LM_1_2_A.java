package ap.excercises.ex3;



    

import java.util.*;
import java.io.*;

class Book implements Serializable {
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
    public void setAuthor(String author) { this.author = author; }
    public void setPages(int pages) { this.pages = pages; }
    public void setYear(int year) { this.year = year; }

    public void displayInfo() {
        System.out.println("Book: " + title + " | Author: " + author + " | Pages: " + pages + " | Year: " + year);
    }
}

class Student implements Serializable {
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
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setMajor(String major) { this.major = major; }

    public void displayInfo() {
        System.out.println("Student: " + firstName + " " + lastName + " | ID: " + studentId + " | Major: " + major);
    }
}

public class Main_EX3_LM_1_2_A {
    static Scanner scanner = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 8) {
            showMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            while (choice != 8) {
                showMenu();
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
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
                    saveBooksToFile();
                    saveStudentsToFile();
                } else if (choice == 8) {
                    System.out.println("Exiting...");
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }
                
            }
    public static void showMenu() {
        System.out.println("\n===== Library Menu =====");
        System.out.println("1. Add Book");
        System.out.println("2. Add Student");
        System.out.println("3. Edit Student");
        System.out.println("4. Edit Book");
        System.out.println("5. Display All Books");
        System.out.println("6. Display All Students");
        System.out.println("7. Save Data to Files");
        System.out.println("8. Exit");
        System.out.print("Your choice: ");
    }

    public static void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Pages: ");
        int pages = Integer.parseInt(scanner.nextLine());
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        books.add(new Book(title, author, pages, year));
        System.out.println("Book added.");
    }

    public static void addStudent() {
        System.out.print("First name: ");
        String first = scanner.nextLine();
        System.out.print("Last name: ");
        String last = scanner.nextLine();
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Major: ");
        String major = scanner.nextLine();

        students.add(new Student(first, last, id, major));
        System.out.println("Student added.");
    }

    public static void editBook() {
        System.out.print("Enter title to edit: ");
        String title = scanner.nextLine();

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.print("New Author: ");
                b.setAuthor(scanner.nextLine());
                System.out.print("New Pages: ");
                b.setPages(Integer.parseInt(scanner.nextLine()));
                System.out.print("New Year: ");
                b.setYear(Integer.parseInt(scanner.nextLine()));
                System.out.println("Book updated.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void editStudent() {
        System.out.print("Enter first name to edit: ");
        String name = scanner.nextLine();

        for (Student s : students) {
            if (s.getFirstName().equalsIgnoreCase(name)) {
                System.out.print("New Last Name: ");
                s.setLastName(scanner.nextLine());
                System.out.print("New Student ID: ");
                s.setStudentId(scanner.nextLine());
                System.out.print("New Major: ");
                s.setMajor(scanner.nextLine());
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void displayAllBooks() {
        if (books.isEmpty()) System.out.println("No books available.");
        else books.forEach(Book::displayInfo);
    }

    public static void displayAllStudents() {
        if (students.isEmpty()) System.out.println("No students available.");
        else students.forEach(Student::displayInfo);
    }

    public static void saveBooksToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            out.writeObject(new ArrayList<>(books.subList(0, Math.min(4, books.size()))));
            System.out.println("Books saved.");
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public static void saveStudentsToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(new ArrayList<>(students.subList(0, Math.min(3, students.size()))));
            System.out.println("Students saved.");
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
}