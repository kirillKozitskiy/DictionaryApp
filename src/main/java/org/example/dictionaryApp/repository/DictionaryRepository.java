package org.example.dictionaryApp.repository;

public class DictionaryRepository {

    private static final String FILE_PATH = "src/main/java/org/example/dictionaryApp/repository/Dictionary.txt";

    public static String getFilePath(){
        return FILE_PATH;
    }

}
