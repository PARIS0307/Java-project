import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        char choice;

        do {
            System.out.println("Enter Student name:");
            String name = scanner.nextLine();
            students.add(name);

            System.out.println("Add another?(y/n):");
            choice = scanner.nextLine().charAt(0);
        }while (choice == 'y');

        System.out.println("Student List: ");
        for(String student : students){
            System.out.println(student);
        }
        scanner.close();
    }
}
