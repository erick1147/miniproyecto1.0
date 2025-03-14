package com.example.microproyects.controller;
/**
 * Le damos import a todo lo necesario para declarar nuesttros containers dentro de nuestra clase controladora.
 */
import com.example.microproyects.model.WordGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;




public class GameController {
    /**
     * aqui tenemos los containers declarados con el mismo id que le dimos en el scene builder.
     */
    @FXML
    private Label wordLabel; // Label para mostrar la palabra aleatoria

    @FXML
    private TextField inputField; // Campo de texto para la entrada del usuario

    @FXML
    private Button validateButton; // Botón para validar la palabra

    @FXML
    private Label messageLabel; // Label para mostrar mensajes

    @FXML
    private Label levelLabel; // Label para mostrar el nivel actual

    @FXML
    private Label timeLabel;  //Label para mostrar el tiempo restante


    WordGenerator wordGenerator;// Creamos una instancia de la clase generadora de palabras

    /**
     * este metodo representa el incio del juego, cuando recien genera la primera palabra
     */
    public void initialize() {
        wordGenerator = new WordGenerator();
        wordLabel.setText(wordGenerator.generateWords());
    }

    @FXML
    private void validateWord() {
        String userInput = inputField.getText();
        String correctWord = wordLabel.getText();

        if (userInput.equals(correctWord)) {
            wordLabel.setText(wordGenerator.generateWords());
            inputField.clear();
            messageLabel.setText("");
        } else {
            messageLabel.setText("INCORRECT");
            inputField.clear();
        }
    }
}
