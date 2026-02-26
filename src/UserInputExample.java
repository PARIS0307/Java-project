import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continueChoice;
        do {
            System.out.println("Enter first number");
            double num1 = scanner.nextDouble();

            System.out.println("Enter second number");
            double num2 = scanner.nextDouble();

            System.out.println("Choose operation(+,-,*,/):");
            char operator = scanner.next().charAt(0);

            double result = 0;
            if (operator == '+'){
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 != 0){
                    result = num1 / num2;
                }else {
                    System.out.println("Cannot divide by zero");
                }
            }else {
                System.out.println("Invalid operator");
                return;
            }
            System.out.println("Result: " +result);
            System.out.println("Do you want to continue? (y/n):");
            continueChoice = scanner.next().charAt(0);
        }while (continueChoice == 'y'|| continueChoice == 'Y' );
        scanner.close();
    }
}
