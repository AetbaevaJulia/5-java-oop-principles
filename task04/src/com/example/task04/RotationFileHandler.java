package com.example.task04;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.FileOutputStream;

public class RotationFileHandler {
    private final String Path;
    private final ChronoUnit CU;
    public RotationFileHandler(String path, ChronoUnit cu){
        Path = path;
        CU = cu;
    }

    public void log(String message){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");
        String timeStamp = LocalDateTime.now().truncatedTo(CU).format(formatter);
        File file = new File(Path + timeStamp + ".txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)) {
            fileOutputStream.write(message.getBytes());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
