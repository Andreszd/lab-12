package com.lan12.translator.services;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TranslateService {

    private BufferedReader getFile(String path) throws IOException {
        return Files.newBufferedReader(Paths.get(path));
    }

    private ArrayList<String> getArrayContent(String path) throws IOException {
        BufferedReader reader = getFile(path);
        ArrayList<String> paragraphs = new ArrayList<>();
        String currentLine = reader.readLine();

        while(currentLine != null){
            paragraphs.add(currentLine);
            currentLine = reader.readLine();
        }
        reader.close();
        return paragraphs;
    }

    public String getTextContent(String path) throws IOException {
        BufferedReader reader = getFile(path);
        String currentLine = reader.readLine();
        String contentFile = "";

        while(currentLine != null){
            contentFile += currentLine+"\n";
            currentLine = reader.readLine();
        }
        reader.close();
        return contentFile;
    }

    public String getInverseTextInverseFile(String path) throws IOException {
        BufferedReader reader = getFile(path);
        String currentLine = reader.readLine();
        String contentFile = "";

        while(currentLine != null){
            StringBuilder strb = new StringBuilder(currentLine);
            currentLine = strb.reverse().toString();
            contentFile += currentLine+"\n";
            currentLine = reader.readLine();
        }
        reader.close();
        return contentFile;
    }

    public void getMoreRepeatedOcurrences(String path) throws IOException {
        ArrayList<String> fileContent = getArrayContent(path);
        List<String> words;
        for (String paragraph : fileContent) {
            words = Arrays.asList(paragraph.split(" "));
            System.out.println(words);
            break;
        }
        System.out.println(fileContent.size());
    }

    public int counterAmountLineSpaces(String path) throws IOException {
        ArrayList<String> fileContent = getArrayContent(path);
        int counter = 0;

        for (String line: fileContent) {
            if (line.length() == 0) {
                counter++;
            }
        }
        return counter;
    }
}