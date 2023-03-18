import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");
        String message = scanner.nextLine();

        String binary = "";
        for (int i = 0; i < message.length(); i++) {
            int letter = message.charAt(i);
            binary += String.format("%7s", Integer.toBinaryString(letter)).replace(" ", "0");
        }

        System.out.println();
        System.out.println("Result: ");

        int index = 0;
        char currentChar;
        String cipher = "";

        while (index < binary.length()) {
            if (binary.charAt(index) == '0') {
                cipher += "00 ";
                currentChar = '0';
            } else {
                cipher += "0 ";
                currentChar = '1';
            }

            while (binary.charAt(index) == currentChar) {
                cipher += "0";
                index++;

                if (index == binary.length()) {
                    break;
                }
            }

            if (index < binary.length()) {
                cipher += " ";
            }
        }

        System.out.println(cipher);
    }
}