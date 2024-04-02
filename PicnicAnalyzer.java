import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PicnicAnalyzer {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            
            int wordCount = 0;
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            System.out.println("Количество слов в файле: " + wordCount);
            
            
            scanner = new Scanner(inputFile);

            String longestWord = "";
            while (scanner.hasNext()) {
                String currentWord = scanner.next();
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
            }
            System.out.println("Самое длинное слово в файле: " + longestWord);

            
            scanner = new Scanner(inputFile);

            
            Map<String, Integer> wordFrequency = new HashMap<>();
            while (scanner.hasNext()) {
                String currentWord = scanner.next();
                wordFrequency.put(currentWord, wordFrequency.getOrDefault(currentWord, 0) + 1);
            }
            System.out.println("Частота слов:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
