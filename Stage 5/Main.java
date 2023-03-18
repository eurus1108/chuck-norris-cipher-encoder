import java.util.Scanner;

/**
 * Main
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static final String ERROR_MESSAGE = "Encoded string is not valid.";

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        System.out.println("Please input operation (encode/decode/exit):");
        String operation = scanner.nextLine();

        switch (operation) {
            case "encode":
                encode();
                break;
            case "decode":
                decode();
                break;
            case "exit":
                System.out.println("Bye!");
                System.exit(0);
                break;
            default:
                System.out.printf("There is no '%s' operation%n", operation);
                System.out.println();
                run();
                break;
        }
    }

    private static void encode() {
        System.out.println("Input string:");
        String message = scanner.nextLine();

        if (message.contains("0")) {
            System.out.println(ERROR_MESSAGE);
            System.out.println();
            run();
        }

        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            binary.append(
                    String.format("%7s", Integer.toBinaryString(message.charAt(i)))
                            .replace(" ", "0"));
        }

        StringBuilder encodedMessage = new StringBuilder();
        char currentBit;
        int i = 0;

        while (i < binary.length()) {
            if (binary.charAt(i) == '0') {
                encodedMessage.append("00 ");
                currentBit = '0';
            } else {
                encodedMessage.append("0 ");
                currentBit = '1';
            }

            while (binary.charAt(i) == currentBit) {
                encodedMessage.append("0");
                i++;

                if (i == binary.length()) {
                    break;
                }
            }

            if (i < binary.length()) {
                encodedMessage.append(" ");
            }
        }

        System.out.println("Encoded string:");
        System.out.println(encodedMessage);
        System.out.println();
        run();
    }

    private static void decode() {
        System.out.println("Input encoded string:");
        String encodedMessage = scanner.nextLine();

        StringBuilder binary = new StringBuilder();
        String[] parts = encodedMessage.split(" ");
        char currentBit;

        if (parts.length % 2 != 0) {
            System.out.println(ERROR_MESSAGE);
            System.out.println();
            run();
        }

        for (String blocks : parts) {
            if (blocks.matches("[a-zA-Z1-9]+") && blocks.contains("0")) {
                System.out.println(ERROR_MESSAGE);
                System.out.println();
                run();
            }
        }

        for (int i = 0; i < parts.length; i += 2) {
            if (parts[i].equals("00")) {
                currentBit = '0';
            } else {
                currentBit = '1';
            }

            if (parts[i].length() > 2) {
                System.out.println(ERROR_MESSAGE);
                System.out.println();
                run();
            }

            StringBuilder nextIndex = new StringBuilder();

            try {
                nextIndex.append(parts[i + 1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
                System.out.println(ERROR_MESSAGE);
                System.out.println();
                run();
            }

            for (int j = 0; j < nextIndex.length(); j++) {
                binary.append(currentBit);
            }

        }

        if (binary.length() % 7 != 0) {
            System.out.println(ERROR_MESSAGE);
            System.out.println();
            run();
        }

        StringBuilder message = new StringBuilder();

        final int NUMBER_OF_BYTES = binary.length() / 7;
        String[] bytesArray = new String[NUMBER_OF_BYTES];
        int[] asciiArray = new int[NUMBER_OF_BYTES];

        int j = 0;

        for (int i = 0; i < bytesArray.length; i++) {
            bytesArray[i] = "";
            while (j < i * 7 + 7) {
                bytesArray[i] += binary.charAt(j);
                j++;
            }
            asciiArray[i] = Integer.parseInt(bytesArray[i], 2);
            message.append((char) asciiArray[i]);
        }

        System.out.println("Decoded string:");
        System.out.println(message);
        System.out.println();
        run();
    }
}