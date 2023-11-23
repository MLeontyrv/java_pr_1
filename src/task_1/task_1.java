package task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.*;
import java.lang.String;

public class task_1 {
    private static final Map<String, Character> alphabet = loadAlphabet();

    public static void main(String[] args) throws FileNotFoundException {
        String message = readInput();
        String decodedMessage = decodeMessage(message);
        System.out.println(decodedMessage);
    }

    private static String readInput() throws FileNotFoundException {
        System.out.println("Введите зашифрованное сообщение:");
        return new Scanner(System.in).nextLine();
    }

    private static Map<String, Character> loadAlphabet() throws FileNotFoundException {
        Map<String, Character> alphabet = new HashMap<>();
        File file = new File("D:\\Projects\\IdeaProjects\\alphabet.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            alphabet.put(parts[0], parts[1].charAt(0));
        }
        return alphabet;
    }

    private static String decodeMessage(String message) {
        String[] words = message.split("\n");
        StringBuilder decodedMessage = new StringBuilder();
        for (String word : words) {
            char[] letters = word.toCharArray();
            for (char letter : letters) {
                decodedMessage.append(alphabet.get(String.valueOf(letter)));
            }
            decodedMessage.append(" ");
        }
        return decodedMessage.toString();
    }
}