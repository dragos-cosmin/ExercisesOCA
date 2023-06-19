package org.example.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author dragos.cosmin
 **/
public class ReadStringFromFiles {
    public static void main(String[] args) throws IOException {
        Path p= Files.writeString(Files.createTempFile("data",".txt"),"data to be added in the file");
        System.out.println(p);
        String value=Files.readString(p);
        System.out.println(value);
    }
}
