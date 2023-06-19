package org.example.fileSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class DeletePaths {
    private static final Logger logger=Logger.getLogger(DeletePaths.class.getName());
    public static void main(String[] args){
        Path folderToDelete=Path.of("C:\\Users\\dragos.cosmin\\Documents\\Examples\\backup");
        try (Stream<Path> pathStream=Files.walk(folderToDelete)){
            pathStream
                    .sorted(Comparator.reverseOrder())
                    .forEach(path->{
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            logger.log(Level.SEVERE,"Error deleting file"+e.getMessage());
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
