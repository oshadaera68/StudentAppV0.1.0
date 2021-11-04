package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class DashboardFormController {

    public JFXButton btnStudent;
    public AnchorPane rootContext;

    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/StudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.setTitle("New Student Form | StudentApp v0.1.0");
    }
}