package org.example.fileSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchiveEx {
    private static final Logger logger = Logger.getLogger(CreateZipArchiveEx.class.getName());

    public static void main(String[] args) {
        //create zip archive

        Path source = Path.of("C:\\Users\\dragos.cosmin\\Documents\\Examples\\joe");

        Path zip = Path.of("C:\\Users\\dragos.cosmin\\Documents\\Examples\\" + source.getName(source.getNameCount() - 1) + ".zip");
        try {
            Files.createFile(zip);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error creating zip file" + e.getMessage());
        }
        try (ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(zip));
             Stream<Path> pathStream = Files.walk(source)) {
            out.setLevel(Deflater.DEFAULT_COMPRESSION);
            pathStream.filter(p -> !Files.isDirectory(p))
                    .forEach(p -> {

                        ZipEntry zipEntry = new ZipEntry(source.relativize(p).toString());
                        try {
                            out.putNextEntry(zipEntry);
                            out.write(Files.readAllBytes(p));
                            out.closeEntry();
                        } catch (Exception e) {
                            logger.log(Level.SEVERE, "Error creating zip entry", e);
                        }
                    });
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error creating zip archive", e);
        }
    }
}
