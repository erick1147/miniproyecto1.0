package com.example.microproyects.controller;

import com.example.microproyects.model.WordGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Clase controladora para la vista del juego.
 * Maneja la lógica del juego, incluyendo la generación de palabras,
 * la validación de palabras, el cronómetro y el sistema de vidas.
 *
 * @author Erick Obando
 * @version 1.0
 * @see com.example.microproyects.model.WordGenerator
 */
public class GameController {

    /**
     * Etiqueta para mostrar la palabra aleatoria.
     */
    @FXML
    private Label wordLabel;

    /**
     * Campo de texto para la entrada del usuario.
     */
    @FXML
    private TextField inputField;

    /**
     * Botón para validar la palabra.
     */
    @FXML
    private Button validateButton;

    /**
     * Etiqueta para mostrar mensajes al usuario.
     */
    @FXML
    private Label messageLabel;

    /**
     * Etiqueta para mostrar el nivel actual del juego.
     */
    @FXML
    private Label levelLabel;

    /**
     * Etiqueta para mostrar el tiempo restante en el cronómetro.
     */
    @FXML
    private Label timeLabel;

    /**
     * Imagen para mostrar el número de vidas restantes.
     */
    @FXML
    private ImageView livesImageView;

    /**
     * Nivel actual del juego.
     */
    private int level = 1;

    /**
     * Contador de palabras correctas ingresadas por el usuario.
     */
    private int correctWordCount = 0;

    /**
     * Generador de palabras aleatorias.
     */
    WordGenerator wordGenerator;

    /**
     * Número de vidas restantes del jugador.
     */
    private int lives = 4;

    /**
     * Inicializa la vista del juego.
     * Configura la imagen inicial de las vidas, genera la primera palabra,
     * inicializa la etiqueta del nivel y comienza el cronómetro.
     */
    public void initialize() {
        startTimer();
        messageLabel.setText("");
        livesImageView.setImage(new Image(getClass().getResourceAsStream("/soles/sol_100%.png")));
        wordGenerator = new WordGenerator();
        wordLabel.setText(wordGenerator.generateWords());
        levelLabel.setText("Nivel: " + level);
    }

    /**
     * Actualiza la imagen de las vidas según el número de vidas restantes.
     */
    private void updateLivesImage() {
        switch (lives) {
            case 3:
                livesImageView.setImage(new Image(getClass().getResourceAsStream("/soles/sol_75%.png")));
                break;
            case 2:
                livesImageView.setImage(new Image(getClass().getResourceAsStream("/soles/sol_50%.png")));
                break;
            case 1:
                livesImageView.setImage(new Image(getClass().getResourceAsStream("/soles/sol_25%.png")));
                break;
            case 0:
                livesImageView.setImage(new Image(getClass().getResourceAsStream("/soles/sol_0%.png")));
                checkGameOver();
                break;
        }
    }

    /**
     * Verifica si el juego ha terminado (vidas = 0) y muestra un mensaje de "Perdiste".
     * Si el juego no ha terminado, reinicia el cronómetro.
     */
    private void checkGameOver() {
        if (lives == 0) {
            timeline.stop();
            inputField.setDisable(true);
            validateButton.setDisable(true);
            messageLabel.setText("¡Perdiste!");
            timeLabel.setText("");
        } else {
            startTimer();
        }
    }

    /**
     * Maneja el evento de tecla presionada en el campo de entrada.
     * Si la tecla presionada es "Enter", llama al método validateWord().
     *
     * @param event El evento de teclado.
     */
    @FXML
    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            validateWord();
        }
    }

    /**
     * Inicia o reinicia el cronómetro.
     */
    private int initialTimeGo = 20;
    private int remainingTime;
    private Timeline timeline;

    private void startTimer() {
        remainingTime = initialTimeGo;

        if (timeline != null) {
            timeline.stop();
        }
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            remainingTime--;
            timeLabel.setText("Tiempo restante: " + remainingTime + " segundos");

            if (remainingTime == 0) {
                timeOut();
            }
        }));
        timeline.setCycleCount(initialTimeGo);
        timeline.play();
    }

    /**
     * Maneja el evento de tiempo agotado.
     * Llama a validateWord(), checkGameOver(), updateLivesImage(),
     * muestra un mensaje de tiempo agotado, limpia el campo de entrada
     * y genera una nueva palabra.
     */
    private void timeOut() {
        validateWord();

        messageLabel.setText("¡Tiempo agotado!");
        checkGameOver();
        updateLivesImage();
        inputField.clear();
        wordLabel.setText(wordGenerator.generateWords());
    }

    /**
     * Valida la palabra ingresada por el usuario.
     * Si la palabra es correcta, incrementa el contador de palabras correctas,
     * actualiza el nivel si es necesario, genera una nueva palabra,
     * limpia el campo de entrada, muestra un mensaje de éxito y reinicia el cronómetro.
     * Si la palabra es incorrecta, disminuye las vidas, actualiza la imagen de las vidas,
     * muestra un mensaje de error, verifica el fin del juego y limpia el campo de entrada.
     */
    @FXML
    private void validateWord() {
        String userInput = inputField.getText();
        String correctWord = wordLabel.getText();

        if (userInput.equals(correctWord)) {
            correctWordCount++;
            if (correctWordCount % 5 == 0) {
                level++;
                levelLabel.setText("Level: " + level);
                initialTimeGo -= 2;
                if (initialTimeGo < 1) {
                    initialTimeGo = 1;
                }
            }
            wordLabel.setText(wordGenerator.generateWords());
            inputField.clear();
            messageLabel.setText("");
            startTimer();
        } else {
            lives--;
            updateLivesImage();
            messageLabel.setText("INCORRECT");
            checkGameOver();
            inputField.clear();
        }
    }
}
