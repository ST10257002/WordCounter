
package app;

// ST10257002 (MP)

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

public class Factor {
    
    private static final Properties property = new Properties();
    
    /**
     * Creates a table model for the JTable component.
     * 
     * @param s string
     * @return DefaultTableModel(gridData, gridHeader)
     */
    
    public static DefaultTableModel getTable(String s) {
        int timeFormat = 0;
        try {
            timeFormat = Integer.parseInt(Config.getProperty(App.configFile, "timeFormat"));
        } catch (IOException ex) {
            Logger.getLogger(Factor.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Generate the table model
        String[] gridHeader = {"Type", "Value"};
        Object[][] gridData = {
            {"Length", getTotal(s)},
            {"Word Total", getWords(s)},
            {"Word Unique", getWordsUnique(s)},
            {"Characters", getCharacters(s)},
            {"Letters", getLetters(s)},
            {"UpperCase", getLettersUpper(s)},
            {"LowerCase", getLettersLower(s)},
            {"Numbers", getDigits(s)},
            {"Symbols", getSymbols(s)},
            {"Spaces", getSpaces(s)},
            {"Paragraphs", getParagraphs(s)},
            {"Pages", getPageCounts(s)},
            {"Lines", 0},
            {"Sentences", getSentences(s)},
            {"Avg. Word (chars)", 0},
            {"Sentence Logest", 0},
            {"Sentence Shortest", 0},
            {"Time to read", calculateTime(s, 200, timeFormat)},
            {"Time to speak", calculateTime(s, 150, timeFormat)},
            {"Time to write", calculateTime(s, 40, timeFormat)}
        };
        return new DefaultTableModel(gridData, gridHeader);
    }
    
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
