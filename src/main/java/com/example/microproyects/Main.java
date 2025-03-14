package com.example.microproyects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal que inicia la aplicación JavaFX.
 * Carga la vista del juego desde el archivo FXML y muestra la ventana principal.
 *
 * @author Erick Obando
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Inicia la aplicación JavaFX.
     * Carga la vista del juego desde el archivo "game_view.fxml" y muestra la ventana principal.
     *
     * @param primaryStage El escenario principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/game_view.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        primaryStage.setTitle("MicroProyects");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Método principal que inicia la aplicación JavaFX.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
