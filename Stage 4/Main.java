import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input encoded string:");
        String encryptedMesssage = scanner.nextLine();

        System.out.println();
        decrypt(encryptedMesssage);
    }

    public static void decrypt(String encryption) {
        String binary = "";
        String[] parts = encryption.split(" ");
        char currentChar;

        for (int i = 0; i < parts.length; i += 2) {
            if (parts[i].equals("00")) {
                currentChar = '0';
            } else {
                currentChar = '1';
            }

            for (int j = 0; j < parts[i + 1].length(); j++) {
                binary += currentChar;
            }
        }

        String message = "";

        final int NUMBER_OF_BYTES = binary.length() / 7;
        String[] bytes = new String[NUMBER_OF_BYTES];
        int[] asciiArray = new int[NUMBER_OF_BYTES];

        int j = 0;

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = "";
            while (j < i * 7 + 7) {
                bytes[i] += binary.charAt(j);
                j++;
            }
            asciiArray[i] = Integer.parseInt(bytes[i], 2);
            message += (char) asciiArray[i];
        }

        System.out.println("Result: ");
        System.out.println(message);
    }
}