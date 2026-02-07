import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static Logger instance;          //  single instance
    private PrintWriter writer;
    private String fileName = "log.txt";

    // Private constructor so direct instantiation phit dr gho krr kwl py dl
    private Logger() {
        openWriter(fileName);
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Opens writer for the given file
    private void openWriter(String fileName) {
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
        } catch (IOException e) {
            System.err.println("Failed to open log file: " + fileName);
            e.printStackTrace();
        }
    }

    // Change the log file
    public synchronized void setFileName(String newFileName) {
        close(); // Close current file first
        this.fileName = newFileName;
        openWriter(this.fileName);
    }

    // Write message to the log file
    public synchronized void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush(); //dr ka yae pe ma pe ensure dr
        }
    }

    // Close the logger
    public synchronized void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}
