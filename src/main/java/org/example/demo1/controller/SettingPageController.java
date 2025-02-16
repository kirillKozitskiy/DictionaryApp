package org.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.demo1.model.JavaFxApp;
import org.example.demo1.repository.DictionaryRepository;
import org.example.demo1.service.DictionaryService;

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
    private void handleConfirmAdding() throws IOException {
        String key = getTheWordTextField.getText();
        String translation = getTheTranslationTextField.getText();
        if(!key.isEmpty() && !translation.isEmpty()) {
            wordPattern = Pattern.compile("[a-zA-Zа-яА-Я]+");

            if(wordPattern.matcher(key).matches() && wordPattern.matcher(translation).matches()) {
                dictionaryService.addWordAndTranslation(key, translation);
                dictionaryService.writeDictionaryMapToFile(DictionaryRepository.getFilePath());
                enterTranslationLabel.setText("Word was successfully added");
                enterWordLabel.setVisible(false);
            }
            else{
                enterWordLabel.setVisible(false);
                enterTranslationLabel.setText("Something went wrong");
            }
        }
        else {
            enterWordLabel.setVisible(false);
            enterTranslationLabel.setText("Something went wrong");
        }
    }

    @FXML
    private void handleGoToFirstPage() throws IOException {
        JavaFxApp.showDictionaryPage();
    }



}
