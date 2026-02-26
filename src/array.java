import java.util.Scanner;

public class array {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers?");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++)
        {
            System.out.println("Enter Number:");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("You erntered:");

        for (int i = 0; i < size; i++){
            System.out.println(numbers[i]);
        }
        scanner.close();
    }
}
