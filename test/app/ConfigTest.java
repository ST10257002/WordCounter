
package app;

import org.junit.jupiter.api.*;

/**
 * JUnit testing class.
 * 
 * @author 1matt
 */

public class ConfigTest {
    
    @BeforeEach
    public void setUp() {
        
    }
    
    // -- Tests

    @Test
    public void testGetProperty_File() 
      throws Exception {
        
        //
    }

    @Test
    public void testGetProperty_Filename() 
      throws Exception {
        
        //
        org.junit.jupiter.api.Assertions.assertTrue(Config.getProperty("config.properties", "testKey").equals("success"));
    }

    @Test
    public void testSetProperty_File() 
      throws Exception {
        
        //
    }

    @Test
    public void testSetProperty_Filename() 
      throws Exception {
        
        //
    }
}
