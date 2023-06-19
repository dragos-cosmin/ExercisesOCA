package org.example.fileSystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ExtractZipArchive {
    private static final Logger logger = Logger.getLogger(ExtractZipArchive.class.getName());

    public static void main(String[] args) throws IOException {
        String zipFilename="joe.zip";
        String destFolder=zipFilename.substring(0,zipFilename.indexOf('.'));
        Path zip = Path.of("C:\\Users\\dragos.cosmin\\Documents\\Examples\\"+zipFilename);
        Path target=Path.of("C:\\Users\\dragos.cosmin\\Documents\\Examples\\"+destFolder);


        if (Files.notExists(target)){
            Files.createDirectories(target);
        }

        try (ZipInputStream in=new ZipInputStream(Files.newInputStream(zip))){
            ZipEntry entry;
            while ((entry=in.getNextEntry()) !=null){
                Path p= Paths.get(target.toString(), entry.getName());

                Files.createDirectories(p.getParent());

                if (entry.isDirectory()){
                    Files.createDirectories(p);
                } else {
                    Files.copy(in,p, StandardCopyOption.REPLACE_EXISTING);
                }
                in.closeEntry();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Error extracting zip",e);
        }

    }
}
