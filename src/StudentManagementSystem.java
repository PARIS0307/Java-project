import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Student {

    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId(){
        return id;
    }

    public String toString() {
        return id + "," + name + "," + age;
    }

    public static Student fromString(String line){
        String[] parts = line.split(",");
        return new Student(
                Integer.parseInt(parts[0]),
                parts[1],
                Integer.parseInt(parts[2])
        );
    }
}
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String Filename = "students.txt";

    public static void main(String[] args) {
        loadFromFile();
        while (true){
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Save & Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    savetoFile();
                    System.out.println("Data saved");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void addStudent(){
        try {
            System.out.println("Enter Id");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Age");
            int age = scanner.nextInt();
            scanner.nextLine();
            students.add(new Student(id, name, age));
            System.out.println("Successfully add student");
        } catch (Exception e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private static void viewStudents(){
        if(students.isEmpty()){
            System.out.println("No students found");
            return;
        }
        for(Student s:students){
            System.out.println(s);
        }
    }

    private static void searchStudent(){
        System.out.println("Enter Id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        for(Student s:students){
            if(s.getId() == id) {
                System.out.println("Founds:" + s);
                return;
            }
        }
        System.out.println("Not Found");
    }

    private static void deleteStudent(){
        System.out.println("Enter Id to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        students.removeIf(s -> s.getId() == id);
        System.out.println("If existed, student removes");
    }

    private static void savetoFile(){
        try(FileWriter writer = new FileWriter(Filename)) {
            for (Student s:students){
                writer.write(s.toString() + "/n");
            }
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    private static void loadFromFile(){
        File file = new File(Filename);
        if(!file.exists()) return;

        try(Scanner filescanner = new Scanner(Filename)) {
            while (filescanner.hasNextLine()){
                students.add(Student.fromString(filescanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println("Error loading file");
        }
    }
}
