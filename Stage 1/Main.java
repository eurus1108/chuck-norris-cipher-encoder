import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");
        String stringInput = scanner.nextLine();

        for (int i = 0; i < stringInput.length(); i++) {
            System.out.print(stringInput.charAt(i) + " ");
        }
    }
}