
package app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1matt
 */
public class ParserTest {
    
    String caseA = "I'm sure this string will be sure 2-day yes sure!!";
    String caseB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String caseC = "0123456789";

    @Test
    public void testGetSize() {
        assertEquals(50, Parser.getSize(caseA));
        assertEquals(52, Parser.getSize(caseB));
        assertEquals(10, Parser.getSize(caseC));
    }

    @Test
    public void testGetWords() {
        assertEquals(10, Parser.getWords(caseA));
        assertEquals(1, Parser.getWords(caseB));
        assertEquals(1, Parser.getWords(caseC));
    }

    @Test
    public void testGetWordsUnique() {
        assertEquals(8, Parser.getWordsUnique(caseA)); // Issue #8
        assertEquals(1, Parser.getWordsUnique(caseB));
        assertEquals(1, Parser.getWordsUnique(caseC));
    }

    @Test
    public void testGetCharacters() {
        assertEquals(50, Parser.getCharacters(caseA));
        assertEquals(52, Parser.getCharacters(caseB));
        assertEquals(10, Parser.getCharacters(caseB));
    }

    @Test
    public void testGetSymbols() {
        assertEquals(4, Parser.getSymbols(caseA));
    }

    @Test
    public void testGetSpaces() {
        assertEquals(9, Parser.getSpaces(caseA));
    }

    @Test
    public void testGetLetters() {
        assertEquals(52, Parser.getLetters(caseB));
        assertEquals(0, Parser.getLetters(caseC));
    }

    @Test
    public void testGetLettersUpper() {
        assertEquals(26, Parser.getLettersUpper(caseB));
        assertEquals(0, Parser.getLettersUpper(caseC));
    }

    @Test
    public void testGetLettersLower() {
        assertEquals(26, Parser.getLettersLower(caseB));
        assertEquals(0, Parser.getLettersLower(caseC));
    }

    @Test
    public void testGetDigits() {
        assertEquals(1, Parser.getDigits(caseA));
        assertEquals(0, Parser.getDigits(caseB));
        assertEquals(10, Parser.getDigits(caseC));
    }

    @Test
    public void testGetSentences() {
        assertEquals(1, Parser.getSentences(caseA)); // Issue #1
        assertEquals(1, Parser.getSentences(caseB));
        assertEquals(1, Parser.getSentences(caseC));
    }

    @Test
    public void testGetParagraphs() {
    }

    @Test
    public void testGetPages() {
    }
    
}
