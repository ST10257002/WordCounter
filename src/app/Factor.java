
package app;

// ST10257002 (MP)

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

public class Factor {
    
    public DefaultTableModel getTable(String s) {
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
            {"Symbols", },
            {"Spaces", getSpaces(s)},
            {"Paragraphs", getParagraphs(s)},
            {"Pages", getPageCounts(s)},
            {"Lines", 0},
            {"Sentences", getSentences(s)},
            {"Avg. Word (chars)", 0},
            {"Sentence Logest", 0},
            {"Sentence Shortest", 0},
            {"Time to read", calculateTime(s, 200)},
            {"Time to speak", calculateTime(s, 150)},
            {"Time to write", calculateTime(s, 40)}
        };
        return new DefaultTableModel(gridData, gridHeader);
    }
    
    public int getTotal(String text) {
        return text.length();
    }
    
    public int getWords(String text) {
        return (
            text.trim().isEmpty() 
                ? 0 
                : text.trim().split("\\s+").length    
        );
    }
    
    public int getWordsUnique(String text) {
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
    
    public int getCharacters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                count++;
            }
        }
        return count;
    }
    
    public int getSpaces(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                count++;
            }
        }
        return count;
    }
    
    public int getSymbols(String text) {
        Symbol s = new Symbol();
        int[] symbols = s.define();
        int count = 0;
        for (char c : text.toCharArray()) {
            int v = (int) c;
            if (Arrays.binarySearch(symbols, v) >= 0) {
                count++;
            }
        }
        return count;
    }
    
    public int getLetters(String text) {
        return text.replaceAll("[^A-Za-z]", "").length();
    }
    
    public int getLettersUpper(String text) {
        return text.replaceAll("[^A-Z]", "").length();
    }
    
    public int getLettersLower(String text) {
        return text.replaceAll("[^a-z]", "").length();
    }
    
    public int getDigits(String text) {
        return text.replaceAll("[^0-9]", "").length();
    }
    
    public int getParagraphs(String text) {
        String[] paragraphs = text.split("\n\n|\r\n\r\n");
        if (!text.isBlank()) {
            return paragraphs.length;
        }
        return 0;
    }
    
    public int getPageCounts(String text) {
        return ((int) Math.floor(getWords(text) / 250));
    }
    
    public int getSentences(String text) {
        String[] paragraphs = text.split("[.?!]");
        if (!text.isBlank()) {
            return paragraphs.length;
        }
        return 0;
    }
    
    public String calculateTime(String text, int speed) {
        double word = Double.valueOf(getWords(text));
        double time = word / speed;
        int minutes = (int) Math.floor(word / 200);
        int seconds = (int) Math.floor(((time - Math.floor(time)) * 0.60) * 100);
        return (minutes + "m " + seconds + "s");
    }

}
