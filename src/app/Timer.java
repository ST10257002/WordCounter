
package app;

public class Timer {
    
    // --- Constructors
    
    public static String calcTime(String text, int speed) {
        return calcTime(text, speed, 0);
    }
    
    public static String calcTime(String text, int speed, int mode) {
        switch (mode) {
            default -> {
                return null;
            }
            case (0) -> {
                return calcTime_DEF(text, speed);
            }
            case (1) -> { 
                return calcTime_HMS(text, speed);
            }
            case (2) -> {
                return calcTime_HRS(text, speed);
            }
        }
    }
    
    // --- Calculation methods
    
    private static String calcTime_DEF(String text, int speed) {
        int wordCount = Parse.getWords(text);
        double time = (wordCount / speed);
        int minutes = (int) Math.floor(time / 60);
        int seconds = (int) Math.floor((time - Math.floor(time) * 60) * 100);
        return (minutes + "m " + seconds + "s");
    }
    
    private static String calcTime_HMS(String text, int speed) {
        int wordCount = Parse.getWords(text);
        double time = (wordCount / (double) speed);
        int hours = (int) Math.floor((time / 3600));
        int minutes = (int) Math.floor((time % 3600) / 60);
        int seconds = (int) Math.floor((time % 60) * 100 / 100);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    private static String calcTime_HRS(String text, int speed) {
        int wordCount = Parse.getWords(text);
        double time = (wordCount / (double) speed);
        time = Math.round(time * 10.0) / 10.0;
        return String.format("%.1fh", time);
    }
}
