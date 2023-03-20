package org.example.services.read_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    public List<String> readTheFile(String path){
        try(Stream<String> stream= new BufferedReader(new FileReader(path)).lines();){
            return stream.collect(Collectors.toList());
        }
        catch(Exception e){
            e.getStackTrace();
        }
        return null;
    }
}
