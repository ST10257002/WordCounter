
package app;

// ST10257002 (MP)

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Table {
    
    static final String CONFIG_FILE = "config.properties";
    
    // --- Constructors
    
    /**
     * Creates a table model for the JTable component.
     * <p>
     * <i>Overloaded method uses default mode.</i>
     * 
     * @param text
     * @return 
     */
    public static DefaultTableModel getTable(String text) {
        return getTable(text, 0);
    }
    
    /**
     * Creates a table model for the JTable component.
     * 
     * @param text
     * @param mode
     * @return 
     */
    public static DefaultTableModel getTable(String text, int mode) {
        switch (mode) {
            default -> {
                return new DefaultTableModel();
            }
            case (0) -> {
                return getTable_DEF(text);
            }
            case (1) -> {
                return getTable_WDS(text);
            }
            case (2) -> {
                return getTable_LET(text);
            }
        }
    }
    
    // --- Table formatters

    /**
     * Table model containing default statistics.
     * 
     * @param text
     * @return 
     */
    private static DefaultTableModel getTable_DEF(String text) {
        
        int timeFormat = 0;
        try {
            timeFormat = Integer.parseInt(Config.getProperty(CONFIG_FILE, "timeFormat"));
        } catch (IOException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String[] gridHeader = {"Type", "Value"};
        Object[][] gridData = {
            {"Length", Delve.getSize(text)},
            {"Word Total", Delve.getWords(text)},
            {"Word Unique", Delve.getWordsUnique(text)},
            {"Characters", Delve.getCharacters(text)},
            {"Letters", Delve.getLetters(text)},
            {"UpperCase", Delve.getLettersUpper(text)},
            {"LowerCase", Delve.getLettersLower(text)},
            {"Numbers", Delve.getDigits(text)},
            {"Symbols", Delve.getSymbols(text)},
            {"Spaces", Delve.getSpaces(text)},
            {"Paragraphs", Delve.getParagraphs(text)},
            {"Pages", Delve.getPages(text)},
            {"Lines", 0},
            {"Sentences", Delve.getSentences(text)},
            {"Avg. Word (chars)", 0},
            {"Sentence Logest", 0},
            {"Sentence Shortest", 0},
            {"Time to read", Timer.calcTime(text, 200, timeFormat)},
            {"Time to speak", Timer.calcTime(text, 150, timeFormat)},
            {"Time to write", Timer.calcTime(text, 40, timeFormat)}
        };
        
        return new DefaultTableModel(gridData, gridHeader);
    }
    
    /**
     * Table model containing the statistics of words.
     * 
     * @param text
     * @return 
     */
    private static DefaultTableModel getTable_WDS(String text) {
        
        Map<String, Integer> wordHash = new HashMap<>();
        String[] wordList = text.split("\\s+");

        for (String word : wordList) {
            String wordLowerCase = word.toLowerCase();
            if (wordHash.containsKey(wordLowerCase)) {
                int countIncremented = wordHash.get(wordLowerCase) + 1;
                wordHash.put(wordLowerCase, countIncremented);
            } else {
                wordHash.put(wordLowerCase, 1);
            }
        }
        
        String[] gridHeader = {"Word", "Frequency"};
        Object[][] gridData = new Object[wordHash.size()][2];
        
        int row = 0;
        for (Map.Entry<String, Integer> entry : wordHash.entrySet()) {
            gridData[row][0] = entry.getKey();
            gridData[row][1] = entry.getValue();
            ++row;
        }
        
        return new DefaultTableModel(gridData, gridHeader);
    }

    private static DefaultTableModel getTable_LET(String text) {
        
        Map<String, Integer> letterHash = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                String letterLowerCase = String.valueOf(c).toLowerCase();
                if (letterHash.containsKey(letterLowerCase)) {
                    int countIncremented = letterHash.get(letterLowerCase) + 1;
                    letterHash.put(letterLowerCase, countIncremented);
                } else {
                    letterHash.put(letterLowerCase, 1);
                }
            }
        }
        
        String[] gridHeader = {"Letter", "Frequency"};
        Object[][] gridData = new Object[letterHash.size()][2];
        
        int row = 0;
        for (Map.Entry<String, Integer> entry : letterHash.entrySet()) {
            gridData[row][0] = entry.getKey();
            gridData[row][1] = entry.getValue();
            ++row;
        }
        
        return new DefaultTableModel(gridData, gridHeader);
    }
}
