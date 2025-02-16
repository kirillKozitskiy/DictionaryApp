package org.example.dictionaryApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.example.dictionaryApp.model.JavaFxApp;
import org.example.dictionaryApp.repository.DictionaryRepository;
import org.example.dictionaryApp.service.DictionaryService;

import java.io.IOException;
import java.util.regex.Pattern;

public class DictionaryPageController {

    private DictionaryService dictionaryService;
    private Pattern wordPattern;

    @FXML
    private Label displayTranslationLabel;

    @FXML
    private TextField displayTranslationTextField;

    @FXML
    private Label inputWordToTranslateLabel;

    @FXML
    private TextField wordToTranslateTextField;

    @FXML
    public void initialize() {
        dictionaryService = new DictionaryService();
    }

    @FXML void handleEnterPressed(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            handlePressToTranslate();
        }
    }

    @FXML
    private void handlePressToTranslate() throws IOException {
        wordPattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
        if(wordPattern.matcher(wordToTranslateTextField.getText()).matches()) {
            String tempTranslation = dictionaryService.getTranslationFromDictionary(DictionaryRepository.getFilePath(), wordToTranslateTextField.getText());
            displayTranslationTextField.setText(tempTranslation);
            displayTranslationLabel.setVisible(true);
            inputWordToTranslateLabel.setText("Word");

        }
        else {
            displayTranslationLabel.setVisible(false);
            inputWordToTranslateLabel.setText("Something went wrong");
        }
    }

    @FXML
    private void handleNextPage() throws IOException {
        JavaFxApp.showSecondPage();
    }

}
