
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
    
    public static DefaultTableModel getTable(String text) {
        return getTable(text, 0);
    }
    
    public static DefaultTableModel getTable(String text, int mode) {
        switch (mode) {
            default -> {
                return new DefaultTableModel();
            }
            case (0) -> {
                return getTable_DEF(text);
            }
            case (2) -> {
                return getTable_ADV(text);
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
    public static DefaultTableModel getTable_DEF(String text) {
        
        int timeFormat = 0;
        try {
            timeFormat = Integer.parseInt(Config.getProperty(CONFIG_FILE, "timeFormat"));
        } catch (IOException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String[] gridHeader = {"Type", "Value"};
        Object[][] gridData = {
            {"Length", Factor.getTotal(text)},
            {"Word Total", Factor.getWords(text)},
            {"Word Unique", Factor.getWordsUnique(text)},
            {"Characters", Factor.getCharacters(text)},
            {"Letters", Factor.getLetters(text)},
            {"UpperCase", Factor.getLettersUpper(text)},
            {"LowerCase", Factor.getLettersLower(text)},
            {"Numbers", Factor.getDigits(text)},
            {"Symbols", Factor.getSymbols(text)},
            {"Spaces", Factor.getSpaces(text)},
            {"Paragraphs", Factor.getParagraphs(text)},
            {"Pages", Factor.getPageCounts(text)},
            {"Lines", 0},
            {"Sentences", Factor.getSentences(text)},
            {"Avg. Word (chars)", 0},
            {"Sentence Logest", 0},
            {"Sentence Shortest", 0},
            {"Time to read", Factor.calculateTime(text, 200, timeFormat)},
            {"Time to speak", Factor.calculateTime(text, 150, timeFormat)},
            {"Time to write", Factor.calculateTime(text, 40, timeFormat)}
        };
        
        return new DefaultTableModel();
    }
    
    /**
     * Table model containing the statistics of words.
     * 
     * @param text
     * @return 
     */
    public static DefaultTableModel getTable_ADV(String text) {
        
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

}
