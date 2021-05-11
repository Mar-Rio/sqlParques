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
    private int indice;
    private Gestion gestion;

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
        gestion = new Gestion();
        try {
            gestion.listarComunidades();
        } catch (SQLException ex) {
           alerta("Error", ex.getMessage());
        }
        Comunidad mostrada = gestion.getComunidades().get(0);
        campoComunidad.setText(String.valueOf(mostrada.getId()));
        nombreComunidad.setText(mostrada.getComunidad());
        indice = mostrada.getId();
        
        
    }

    private void alerta(String title, String contenido) {
        Alert dialogoAlerta = new Alert(Alert.AlertType.WARNING);
        dialogoAlerta.setTitle(title);
        dialogoAlerta.setContentText(contenido);
        dialogoAlerta.showAndWait();
    }

    @FXML
    private void aUltimo(ActionEvent event) {
         try {
            gestion.listarComunidades();
        } catch (SQLException ex) {
           alerta("Error", ex.getMessage());
        }
         int tamanyo = gestion.getComunidades().size();
         campoComunidad.setText(String.valueOf(gestion.getComunidades().get(tamanyo - 1).getId()));
         nombreComunidad.setText(gestion.getComunidades().get(tamanyo - 1).getComunidad());
         indice = tamanyo - 1;
    }     
       
    
    @FXML
    private void avanzar(ActionEvent event) {
         try {
            gestion.listarComunidades();
        } catch (SQLException ex) {
           alerta("Error", ex.getMessage());
        }
         campoComunidad.setText(String.valueOf(gestion.getComunidades().get(++indice).getId()));
         nombreComunidad.setText(gestion.getComunidades().get(++indice).getComunidad());
         indice++;
    }
       
       
    
    @FXML
    private void retroceder(ActionEvent event) {
     try {
            gestion.listarComunidades();
        } catch (SQLException ex) {
           alerta("Error", ex.getMessage());
        }
         campoComunidad.setText(String.valueOf(gestion.getComunidades().get(indice - 1).getId()));
         nombreComunidad.setText(gestion.getComunidades().get(indice - 1).getComunidad());
         indice--;
    }

    @FXML
    private void aPrimero(ActionEvent event) {
         try {
            gestion.listarComunidades();
        } catch (SQLException ex) {
           alerta("Error", ex.getMessage());
        }
         campoComunidad.setText(String.valueOf(gestion.getComunidades().get(0).getId()));
         nombreComunidad.setText(gestion.getComunidades().get(0).getComunidad());
         indice = 0;
    }
}
