package org.example.dictionaryApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.dictionaryApp.model.JavaFxApp;
import org.example.dictionaryApp.repository.DictionaryRepository;
import org.example.dictionaryApp.service.DictionaryService;

import java.io.IOException;
import java.util.regex.Pattern;

public class SettingPageController {

    private DictionaryService dictionaryService;
    private Pattern wordPattern;

    @FXML
    private Label enterWordLabel;
    @FXML
    private TextField getTheWordTextField;

    @FXML
    private Label enterTranslationLabel;
    @FXML
    private TextField getTheTranslationTextField;

    @FXML
    public void initialize() {
        dictionaryService = new DictionaryService();
    }

    @FXML
    protected void handleConfirmAdding() throws IOException {
        String word = getTheWordTextField.getText();
        String translation = getTheTranslationTextField.getText();

        if(!word.isEmpty() && !translation.isEmpty()) {
            wordPattern = Pattern.compile("[a-zA-Zа-яА-Я]+");

            if(wordPattern.matcher(word).matches() && wordPattern.matcher(translation).matches())
            {
                dictionaryService.addWordAndTranslation(word, translation);
                dictionaryService.writeDictionaryMapToFile(DictionaryRepository.getFilePath());

                enterTranslationLabel.setText("Word successfully added");
                enterWordLabel.setVisible(false);
            }
            else{
                enterWordLabel.setVisible(false);
                enterTranslationLabel.setText("Word has not been added");
            }
        }
        else {
            enterWordLabel.setVisible(false);
            enterTranslationLabel.setText("Fill in all fields");
        }
    }

    @FXML
    protected void handleGoToFirstPage() throws IOException {
        JavaFxApp.showDictionaryPage();
    }



}
