
package app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import app.definitions.*;

public class Parse {
    
    final static String CONFIG_FILE = "config.properties";
    
    // ---
    
    public static int getSize(String text) {
        return text.length();
    }
    
    public static int getWords(String text) {
        String condensed = text.trim();
        return condensed.isBlank() ? 0 : condensed.split("\\s+").length;
    }
    
    public static int getWordsUnique(String text) {
        String[] wordArray = text.split("\\s+");
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordArray));
        return wordSet.size();
    }
    
    public static int getCharacters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                continue;
            }
            ++count;
        }
        return count;
    }
    
    public static int getSymbols(String text) {
        Set<Integer> symbolHash = new HashSet<>();
        for (int charCode : Symbol.define()) {
            symbolHash.add(charCode);
        }
        int count = 0;
        for (char c : text.toCharArray()) {
            int charCode = (int) c;
            if (symbolHash.contains(charCode)) {
                ++count;
            }
        }
        return count;
    }
    
    public static int getSpaces(String text) {
        return text.length() - text.replaceAll("\\s", "").length();
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
    
    public static int getSentences(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                count++;
            }
        }
        return count;
    }
    
    public static int getParagraphs(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '\n' || c == '\r') {
                ++count;
            }
        }
        return count;
    }
    
    public static int getPages(String text) {
        return ((int) Math.floor(getWords(text) / 400));
    }
}
