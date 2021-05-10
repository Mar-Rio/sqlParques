package Borrar;

import Insertar.*;
import Datos.Gestion;
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

public class BorrarController implements Initializable {

    private boolean conexion;
    private Parques parque;
    @FXML
    private TextField idParque;
    private TextField nombre;
    private TextField extension;
    private TextField idComunidad;
    @FXML
    private Label textoConexion;
    @FXML
    private Button borrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//     InicioController.getBasededatos()        
    }

    private void alerta(String title, String contenido) {
        Alert dialogoAlerta = new Alert(Alert.AlertType.WARNING);
        dialogoAlerta.setTitle(title);
        dialogoAlerta.setContentText(contenido);
        dialogoAlerta.showAndWait();
    }

    @FXML
    private void borradoParque(ActionEvent event) {
        parque = new Parques();
        parque.setId(idParque.getText());
        InicioController.getBasededatos().getConn();
        try {
            if (InicioController.getBasededatos().borrarParque(parque)) {
                alerta("Exito", "Parque " + idParque + " ha sido eliminado.");
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/ElegirAccion/ElegirAccion.fxml"));
                    Parent root = loader.load();
                    Stage escenarioVentana = (Stage) borrar.getScene().getWindow();
                    escenarioVentana.setTitle("Elegir");
                    escenarioVentana.setScene(new Scene(root));

                } catch (IOException ex) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setContentText("ERROR " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            alerta("ERROR", ex.getMessage());
        }
    }
}
