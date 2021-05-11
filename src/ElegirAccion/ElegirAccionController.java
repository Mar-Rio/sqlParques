/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElegirAccion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML ElegirAccionController class
 *
 * @author cosca
 */
public class ElegirAccionController implements Initializable {

    @FXML
    private Button borrar;
    @FXML
    private Label textoConexion;
    @FXML
    private Button insert;
    @FXML
    private Button botonComunidad;
    @FXML
    private Label textoConexion1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void irBorrar(ActionEvent event) {
        Parent root = cargarOtraEscena("/Borrar/Borrar.fxml");
        Node nodoQueHaGeneradoEvento = (Node) event.getSource();
        Stage ventana = (Stage) nodoQueHaGeneradoEvento.getScene().getWindow();
        ventana.setTitle("Borrado");
        ventana.setScene(new Scene(root));
    }

    @FXML
    private void irInsertar(ActionEvent event) {
        Parent root = cargarOtraEscena("/Insertar/Insertar.fxml");
        Node nodoQueHaGeneradoEvento = (Node) event.getSource();
        Stage ventana = (Stage) nodoQueHaGeneradoEvento.getScene().getWindow();
        ventana.setTitle("Insertar");
        ventana.setScene(new Scene(root));
    }

    private Parent cargarOtraEscena(String rutaFXML) {
        FXMLLoader loader;
        Parent root = null;
        try {
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(rutaFXML));
            root = loader.load(); 
        } catch (IOException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("ERROR " + ex.getMessage());
            alerta.showAndWait();
        }
        return root;
    }

    @FXML
    private void verComunidades(ActionEvent event) {
          Parent root = cargarOtraEscena("/Listar/Listar.fxml");
        Node nodoQueHaGeneradoEvento = (Node) event.getSource();
        Stage ventana = (Stage) nodoQueHaGeneradoEvento.getScene().getWindow();
        ventana.setTitle("Comunidades");
        ventana.setScene(new Scene(root));
    }
}
