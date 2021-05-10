package Vista;

import Vista.*;
import Datos.Gestion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InicioController implements Initializable {

    private boolean conexion;
    private static Gestion basededatos;

    @FXML
    private Label textoConexion;
    @FXML
    private TextField bdd;
    @FXML
    private TextField user;
    @FXML
    private Button boton;
    @FXML
    private TextField pwd;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public static Gestion getBasededatos() {
        return basededatos;
    }

    @FXML
    private void conectar(ActionEvent event) throws SQLException {
        basededatos = new Gestion();
        basededatos.setDb(bdd.getText());
        basededatos.setUser(user.getText());
        basededatos.setPwd(pwd.getText());
        conexion = false;
        while (!conexion) {
            if (basededatos.conectar()) {
                conexion = true;
                Parent root = cargarOtraEscena("/ElegirAccion/ElegirAccion.fxml");
                Node nodoQueHaGeneradoEvento = (Node) event.getSource();
                Stage ventana = (Stage) nodoQueHaGeneradoEvento.getScene().getWindow();
                ventana.setTitle("Elija las acciones a realizar:");
                ventana.setScene(new Scene(root));
            } else {
                alerta("Datos erroneos", "Prueba otra vez");
                bdd.clear();
                user.clear();
                pwd.clear();
            }
        }
    }

    private Parent cargarOtraEscena(String rutaFXML) {
        FXMLLoader loader;
        Parent root = null;
        try {
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(rutaFXML));
            root = loader.load();
        } catch (IOException ex) {
            alerta("Error", ex.getMessage());
        }
        return root;
    }

    private void alerta(String title, String contenido) {
        Alert dialogoAlerta = new Alert(Alert.AlertType.WARNING);
        dialogoAlerta.setTitle(title);
        dialogoAlerta.setContentText(contenido);
        dialogoAlerta.showAndWait();
    }

}
