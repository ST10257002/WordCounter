
package app;

import java.nio.file.*;
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
        Config.directory = Paths.get(
                ""
        );
        org.junit.jupiter.api.Assertions.assertEquals(
                true
                , ""
                , ""
        );
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
