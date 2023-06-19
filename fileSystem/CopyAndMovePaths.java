package org.example.fileSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class CopyAndMovePaths {
    private static final Logger logger=Logger.getLogger(CopyAndMovePaths.class.getName());

    public static void main(String[] args){
        String sourceDirectory="C:\\Users\\dragos.cosmin\\Documents\\Examples\\joe";
        String destDirectory="C:\\Users\\dragos.cosmin\\Documents\\Examples\\backup";
        Path source=Paths.get(sourceDirectory);
        Path dest=Paths.get(destDirectory);
//        Path source=Path.of("C:\\Users\\dragos.cosmin\\Documents\\Examples\\joe");

//        Path backup=Path.of("C:\\Users\\dragos.cosmin\\Documents\\Examples\\backup");
        Path archive=Path.of("C:\\Users\\dragos.cosmin\\Documents\\Examples\\archive");



        if (Files.notExists(dest)){
            try {
                Files.createDirectories(dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try(Stream<Path> pathStream=Files.walk(source)) {
            pathStream
                    .forEach(file->{
                        Path destination= Paths.get(destDirectory,file.toString().substring(sourceDirectory.length()));

                        try {
                            Files.copy(file,destination,StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            logger.log(Level.SEVERE,"Unable to copy",e);
                        }


                    });
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Error walking files"+e.getMessage());
        }

//        if (Files.notExists(archive)){
//            Files.createDirectories(archive);
//        }

        try {
            Files.move(dest,archive,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Unable to move",e);
        }

    }
}
