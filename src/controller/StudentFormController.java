package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StudentFormController {
    public AnchorPane studentFormContext;
    public JFXButton btnHome;
    public JFXButton btnNewStudent;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXButton btnSave;
    public TableView tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colOperator;

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) studentFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.setTitle("Student App v0.1.0 | MINDARTLK Creations");
    }

    public void newStudentOnAction(ActionEvent actionEvent) {

    }

    public void saveAndUpdateOnAction(ActionEvent actionEvent) {

    }
}
