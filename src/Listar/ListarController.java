package Listar;

import Insertar.*;
import Datos.Gestion;
import Modelo.Comunidad;
import Modelo.Parques;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import Vista.InicioController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListarController implements Initializable {

    private boolean conexion;
    private Comunidad comunidad;

    @FXML
    private Label textoConexion;
    @FXML
    private TextField campoComunidad;
    @FXML
    private Button botonUltimo;
    @FXML
    private TextField nombreComunidad;
    @FXML
    private Label numeroComunidades;
    @FXML
    private Button botonAvanzar;
    @FXML
    private Button botonRetroceder;
    @FXML
    private Button botonPrimero;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textoConexion.setVisible(true);
        InicioController.getBasededatos();       
    }

    private void alerta(String title, String contenido) {
        Alert dialogoAlerta = new Alert(Alert.AlertType.WARNING);
        dialogoAlerta.setTitle(title);
        dialogoAlerta.setContentText(contenido);
        dialogoAlerta.showAndWait();
    }

    @FXML
    private void aUltimo(ActionEvent event) {
    }

    @FXML
    private void avanzar(ActionEvent event) {
    }

    @FXML
    private void retroceder(ActionEvent event) {
    }

    @FXML
    private void aPrimero(ActionEvent event) {
    }
}
