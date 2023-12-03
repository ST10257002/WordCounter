
package app;

import app.definitions.*;
import java.util.Arrays;

/**
 * Class to handle calculations.
 * 
 * @author matt-pieterse
 */

public class Factor {
    
    static final String CONFIG_FILE = "config.properties";
    
    public static int getTotal(String text) {
        return text.length();
    }
    
    public static int getWords(String text) {
        return (
            text.trim().isEmpty() 
                ? 0 
                : text.trim().split("\\s+").length    
        );
    }
    
    public static int getWordsUnique(String text) {
        String[] array = text.split("\\s+");
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].trim().isEmpty()) {
                if (i == 0 || !array[i].equalsIgnoreCase(array[i - 1])) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static int getCharacters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                count++;
            }
        }
        return count;
    }
    
    public static int getSpaces(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                count++;
            }
        }
        return count;
    }
    
    public static int getSymbols(String text) {
        int[] symbols = Symbol.define();
        int count = 0;
        for (char c : text.toCharArray()) {
            int v = (int) c;
            if (Arrays.binarySearch(symbols, v) >= 0) {
                count++;
            }
        }
        return count;
    }
    
    public static int getLetters(String text) {
        return text.replaceAll("[^A-Za-z]", "").length();
    }
    
    public static int getLettersUpper(String text) {
        return text.replaceAll("[^A-Z]", "").length();
    }
    
    public static int getLettersLower(String text) {
        return text.replaceAll("[^a-z]", "").length();
    }
    
    public static int getDigits(String text) {
        return text.replaceAll("[^0-9]", "").length();
    }
    
    public static int getParagraphs(String text) {
        String[] paragraphs = text.split("\n\n|\r\n\r\n");
        if (!text.isBlank()) {
            return paragraphs.length;
        }
        return 0;
    }
    
    public static int getPageCounts(String text) {
        return ((int) Math.floor(getWords(text) / 250));
    }
    
    public static int getSentences(String text) {
        String[] paragraphs = text.split("[.?!]");
        if (!text.isBlank()) {
            return paragraphs.length;
        }
        return 0;
    }
    
    /**
     * Calculates time taken for a human to perform an action.
     * 
     * @param text String()
     * @param speed words per second
     * @param style formatting (0-2)
     * @return The minutes and seconds as a string.
     */
    
    public static String calculateTime(String text, int speed, int style) {
        switch (style) {
            default -> {
                double word = Double.valueOf(getWords(text));
                double time = word / speed;
                int minutes = (int) Math.floor(word / 200);
                int seconds = (int) Math.floor(((time - Math.floor(time)) * 0.60) * 100);
                return (minutes + "m " + seconds + "s");
            }
            case (1) -> {
                double word = Double.valueOf(getWords(text));
                double timeInSeconds = word / speed;
                int hours = (int) (timeInSeconds / 3600);
                int minutes = (int) ((timeInSeconds % 3600) / 60);
                int seconds = (int) (timeInSeconds % 60);
                return String.format("%02d:%02d:%02d", hours, minutes, seconds);
            }
            case (2) -> {
                double word = Double.valueOf(getWords(text));
                double timeInHours = word / (speed * 3600); // Convert speed to words per hour
                return String.format("%.1fh", timeInHours);
            }
        }
    }

}
