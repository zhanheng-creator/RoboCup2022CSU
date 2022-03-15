package rescuecore2.log;

import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;

/**
   A class for writing the kernel log to a file.
 */
public class FileLogWriter extends StreamLogWriter {
    /**
       Create a file log writer and open it for writing.
       @param name The name of the file to write to.
       @throws IOException If the log file cannot be opened.
       @throws LogException If the log cannot be written.
    */
    public FileLogWriter(String name) throws IOException, LogException {
        this(new File(name));
    }

    /**
       Create a file log writer and open it for writing.
       @param file The file to write to.
       @throws IOException If the log file cannot be opened.
       @throws LogException If the log cannot be written.
    */
    public FileLogWriter(File file) throws IOException, LogException {
        super(new BufferedOutputStream(new FileOutputStream(file)));
    }
}
