package org.example.fileSystem;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemExamples {
    public static void main(String[] args) {
        FileSystem fs= FileSystems.getDefault();
        fs.getFileStores().forEach(s->System.out.println(s.type()+" "+s.name()));
        fs.getRootDirectories().forEach(System.out::println);
        String separator= fs.getSeparator();
        System.out.println(separator);

        fs.getFileStores().forEach(s->{
            try {
                System.out.println(s.name()+" "+s.getTotalSpace()+" "+s.getUnallocatedSpace()+" "+s.getUsableSpace());
            } catch (IOException e) {
                System.out.println(e);
            }
        });
        Path current = Path.of("C:\\Users\\dragos.cosmin\\IdeaProjects\\workspace\\spring\\spring_security_in_action_source_code\\ExercisesOCA");
        System.out.println(current);

        System.out.println();
    }
}
