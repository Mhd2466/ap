package ap.excercises.ex3;

class Book { // i just cleaned the code with AI , it was too messy :)
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

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setMajor(String major) { this.major = major; }

    public void displayInfo() {
        System.out.println("Student: " + firstName + " " + lastName + " | Student ID: " + studentId + " | Major: " + major);
    }
}

public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {

        Book book1 = new Book("Java Programming", "James Gosling", 450, 1995);
        Book book2 = new Book("Data Structures", "Mark Weiss", 600, 2002);

        Student student1 = new Student("Ali", "Ahmadi", "14001234", "Computer Engineering");
        Student student2 = new Student("Sara", "Moradi", "14005678", "Electrical Engineering");
        
        // displaying information
        book1.displayInfo();
        book2.displayInfo();
        student1.displayInfo();
        student2.displayInfo();
    }
}
