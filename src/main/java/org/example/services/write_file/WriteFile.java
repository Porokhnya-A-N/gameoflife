package org.example.services.write_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;
public class WriteFile {
public void writeToFile(String path ,List<String> list){
    try(BufferedWriter buffer = new BufferedWriter(new FileWriter(path));){
        buffer.write(list.stream().collect(Collectors.joining("\n")));
        buffer.flush();
    }
    catch(Exception e){
        e.getStackTrace();
    }
}
}
