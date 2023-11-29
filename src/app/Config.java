
package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * Class to handle interactions with configuration files.
 * 
 * @author matthew-pieterse
 */

public class Config {
    
    // Directory containing all application configuration files
    // C:\Users\Username\AppData\Roaming\WordCounter
    
    static final Path directory = Paths.get(
            System.getProperty("user.home"),
            "AppData",
            "Roaming",
            "WordCounter"
    );
    
    /**
     * Update the local configuration file with the packaged template.
     * 
     * @throws java.io.IOException
     */
    
    public static void initConfigs() 
      throws IOException {
        
        String configFolder = "src/app/config/";
        ArrayList<Path> configFiles = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(configFolder), "*.properties")) {
            for (Path entry : stream) {
                configFiles.add(entry);
            }
        }

        for (Path path : configFiles) {
            Path filePath = directory.resolve(path.getFileName());
            if (!Files.exists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.copy(path, filePath);
            }
        }
    }
    
    /**
     * Returns the value of a property in the passed file.
     * 
     * @param config
     * @param key
     * @return value
     * @throws IOException 
     */
    
    public static String getProperty(File config, String key)
      throws IOException {
        
        Properties property = new Properties();
        
        try (InputStream stream = new FileInputStream(config)) {
            property.load(stream);
        }
        return property.getProperty(key);
    }
    
    /**
     * Returns the value of a property in the specified file within the configurations folder.
     * 
     * @param filename
     * @param key
     * @return value
     * @throws IOException 
     */
    
    public static String getProperty(String filename, String key)
      throws IOException {
        
        Properties property = new Properties();
        Path path = directory.resolve(filename);
        
        try (InputStream stream = Files.newInputStream(path)) {
            property.load(stream);
        }
        return property.getProperty(key);
    }
    
    /**
     * Sets the value of a property in the passed file.
     * 
     * @param config
     * @param key
     * @param value
     * @throws IOException 
     */
    
    public static void setProperty(File config, String key, String value)
      throws IOException {
        
        Properties property = new Properties();
        
        // The try-with-lease blocks are separated to avoid data loss
        
        try (InputStream inputStream = new FileInputStream(config)) {
            property.load(inputStream);
        }

        try (OutputStream outputStream = new FileOutputStream(config)) {
            property.setProperty(key, value);
            property.store(outputStream, null);
        }
    }
    
    /**
     * Sets the value of a property in the specified file within the configurations folder.
     * 
     * @param filename
     * @param key
     * @param value
     * @throws IOException 
     */
    
    public static void setProperty(String filename, String key, String value)
      throws IOException {
        
        Properties property = new Properties();
        Path path = directory.resolve(filename);
        
        // The try-with-lease blocks are separated to avoid data loss
        
        try (InputStream inputStream = Files.newInputStream(path)) {
            property.load(inputStream);
        }

        try (OutputStream outputStream = Files.newOutputStream(path)) {
            property.setProperty(key, value);
            property.store(outputStream, null);
        }
    }
    
    /**
     * Gets the number of files in a directory.
     * 
     * @param directory
     * @return Long c
     * @throws IOException 
     */
    
    public static long getDirectoryLength(Path directory) 
      throws IOException {
        try (Stream<Path> files = Files.list(directory)) {
            return files.count();
        }      
    }
}
