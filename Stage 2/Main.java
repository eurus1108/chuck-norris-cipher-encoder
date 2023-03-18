import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input String:");
        String stringInput = scanner.nextLine();
        System.out.println();

        System.out.println("The result:");
        for (int i = 0; i < stringInput.length(); i++) {
            char letter = stringInput.charAt(i);
            String binary = String.format("%7s", Integer.toBinaryString(letter)).replace(" ", "0");
            System.out.println(String.format("%c = %s", letter, binary));
        }
    }
}