package org.example.demo1.service;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class DictionaryService {

    private Map<String, String> dictionary;

    private String word;
    private String wordTranslation;

    public DictionaryService() {
        dictionary = new TreeMap<String, String>();
    }

    public void addWordAndTranslation(String word, String translation) {
        dictionary.put(word, translation);
    }

    public String getTranslationFromDictionary(String fileName, String word) {
        String lowercaseWord = word.toLowerCase();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                if(words[0].equalsIgnoreCase(lowercaseWord)) {
                    return words[1];
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return "Null";
    }

    public void writeDictionaryMapToFile(String fileName) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue());
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }




}
