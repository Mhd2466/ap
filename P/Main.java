package ap.P;
import java.io.*;
import java.time.LocalDate;
import java.util.*;






public class Main {
    public static void main(String[] args) {
        Library library = new Library("University Library");
        LibraryStorage.loadLibrary(library); // Load data from file if available
        Menu menu = new Menu(library);
        menu.start();
        LibraryStorage.saveLibrary(library); // Save data to file before exiting
    }
}







class Book implements Serializable {
    String title;
    String author;
    int year;
    int pages;
    int borrowCount = 0;

    public Book(String title, String author, int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    public String toString() {
        return title + " by " + author + " (" + year + ", " + pages + " pages)";
    }
}






class Student implements Serializable {
    String name;
    String family;
    String studentId;
    String field;
    LocalDate joinDate;

    public Student(String name, String family, String studentId, String field, LocalDate joinDate) {
        this.name = name;
        this.family = family;
        this.studentId = studentId;
        this.field = field;
        this.joinDate = joinDate;
    }

    public String toString() {
        return name + " " + family + " - " + studentId + " - " + field;
    }
}







class Librarian implements Serializable {
    String name;
    String family;
    String id;

    public Librarian(String name, String family, String id) {
        this.name = name;
        this.family = family;
        this.id = id;
    }

    public String toString() {
        return name + " " + family + " (ID: " + id + ")";
    }
}









class Manager implements Serializable {
    String name;
    String family;
    String degree;

    public Manager(String name, String family, String degree) {
        this.name = name;
        this.family = family;
        this.degree = degree;
    }
}














class Loan implements Serializable {
    Book book;
    Student student;
    Librarian giver;
    LocalDate borrowDate;
    LocalDate dueDate;
    LocalDate returnDate;
    Librarian receiver;

    public Loan(Book book, Student student, Librarian giver, LocalDate borrowDate, LocalDate dueDate) {
        this.book = book;
        this.student = student;
        this.giver = giver;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public boolean isLate() {
        return returnDate != null && returnDate.isAfter(dueDate);
    }

    public boolean isReturned() {
        return returnDate != null;
    }
}










class Library implements Serializable {
    String name;
    List<Book> books = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Librarian> librarians = new ArrayList<>();
    List<Loan> loans = new ArrayList<>();
    Manager manager;

    public Library(String name) {
        this.name = name;
        manager = new Manager("Main", "Manager", "Master's Degree");
        librarians.add(new Librarian("Ali", "Rezaei", "L1"));
        librarians.add(new Librarian("Mina", "Karimi", "L2"));
    }

    public Librarian getRandomLibrarian() {
        Random rand = new Random();
        return librarians.get(rand.nextInt(librarians.size()));
    }
}











class LibraryStorage {
    static final String FILE_NAME = "library_data.ser";

    // Save the current state of the library to a file
    public static void saveLibrary(Library lib) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lib);
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Load library data from a file if it exists
    public static void loadLibrary(Library lib) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Library loaded = (Library) ois.readObject();
            lib.books = loaded.books;
            lib.students = loaded.students;
            lib.librarians = loaded.librarians;
            lib.loans = loaded.loans;
            lib.manager = loaded.manager;
        } catch (Exception e) {
            System.out.println("No saved data found.");
        }
    }
}










class Menu {
    Scanner sc = new Scanner(System.in);
    Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void start() {
        System.out.println("Please select your user type:");
        System.out.println("1. Student\n2. Manager");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) studentMenu();
        else managerMenu();
    }

    private void studentMenu() {
        System.out.println("Have you already registered? (y/n)");
        String answer = sc.nextLine();
        Student student = null;
        if (answer.equalsIgnoreCase("n")) {
            System.out.print("First name: ");
            String name = sc.nextLine();
            System.out.print("Last name: ");
            String family = sc.nextLine();
            System.out.print("Student ID: ");
            String id = sc.nextLine();
            System.out.print("Field of study: ");
            String field = sc.nextLine();
            student = new Student(name, family, id, field, LocalDate.now());
            library.students.add(student);
        } else {
            System.out.print("Enter your student ID: ");
            String id = sc.nextLine();
            for (Student s : library.students) {
                if (s.studentId.equals(id)) student = s;
            }
            if (student == null) {
                System.out.println("No student found with this ID.");
                return;
            }
        }

        System.out.println("1. Search Book\n2. Borrow Book\n3. Return Book");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice == 1) {
            System.out.print("Enter book title: ");
            String title = sc.nextLine();
            for (Book b : library.books) {
                if (b.title.contains(title)) System.out.println(b);
            }
        } else if (choice == 2) {
            System.out.print("Enter book title to borrow: ");
            String title = sc.nextLine();
            for (Book b : library.books) {
                if (b.title.contains(title)) {
                    Librarian lib = library.getRandomLibrarian();
                    Loan loan = new Loan(b, student, lib, LocalDate.now(), LocalDate.now().plusDays(14));
                    library.loans.add(loan);
                    b.borrowCount++;
                    System.out.println("Book borrowed by: " + lib);
                    return;
                }
            }
        } else if (choice == 3) {
            for (Loan l : library.loans) {
                if (l.student == student && !l.isReturned()) {
                    l.returnDate = LocalDate.now();
                    l.receiver = library.getRandomLibrarian();
                    System.out.println("Book returned to: " + l.receiver);
                    return;
                }
            }
            System.out.println("No borrowed books found to return.");
        }
    }

    private void managerMenu() {
        System.out.println("1. Add Book\n2. Overdue Report\n3. Librarian Activity Report\n4. Top 10 Borrowed Books");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice == 1) {
            System.out.print("Title: "); String t = sc.nextLine();
            System.out.print("Author: "); String a = sc.nextLine();
            System.out.print("Year: "); int y = sc.nextInt();
            System.out.print("Pages: "); int p = sc.nextInt(); sc.nextLine();
            library.books.add(new Book(t, a, y, p));
            System.out.println("Book added successfully.");
        } else if (choice == 2) {
            for (Loan l : library.loans) {
                if (l.isLate()) {
                    System.out.println(l.book + " - borrowed by " + l.student + " was returned late.");
                }
            }
        } else if (choice == 3) {
            Map<String, Integer> counts = new HashMap<>();
            for (Loan l : library.loans) {
                counts.put(l.giver.id, counts.getOrDefault(l.giver.id, 0) + 1);
                if (l.receiver != null)
                    counts.put(l.receiver.id, counts.getOrDefault(l.receiver.id, 0) + 1);
            }
            for (Librarian lib : library.librarians) {
                System.out.println(lib + ": " + counts.getOrDefault(lib.id, 0) + " operations");
            }
        } else if (choice == 4) {
            library.books.sort((b1, b2) -> b2.borrowCount - b1.borrowCount);
            for (int i = 0; i < Math.min(10, library.books.size()); i++) {
                System.out.println(library.books.get(i) + " - Borrowed: " + library.books.get(i).borrowCount + " times");
            }
        }
    }
}