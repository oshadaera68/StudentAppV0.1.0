package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Student;
import views.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class StudentFormController {
    static ArrayList<Student> students = new ArrayList();
    public AnchorPane studentFormContext;
    public JFXButton btnHome;
    public JFXButton btnNewStudent;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public TableView<StudentTM> tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colOperator;
    public JFXTextField txtSearch;
    public JFXButton btnSaveAndUpdate;

    public void initialize() {
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colOperator.setCellValueFactory(new PropertyValueFactory<>("button"));

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            for (Student s : students) {
                if (s.getId().contains(newValue) || s.getContact().contains(newValue) || s.getAddress().contains(newValue) || s.getName().contains(newValue)) {
                    tblStudent.getItems().stream().sorted();

                }
            }
        });

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            loadStudentsData(newValue);
        });

    }

    private void loadStudentsData(StudentTM newValue) {
        txtId.setText(newValue.getId());
        txtName.setText(newValue.getName());
        txtContact.setText(newValue.getContact());
        txtAddress.setText(newValue.getAddress());
    }


    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) studentFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.setTitle("Student App v0.1.0 | MINDARTLK Creations");
        window.setFullScreen(false);
    }

    public void newStudentOnAction(ActionEvent actionEvent) {
        txtId.clear();
        txtName.clear();
        txtContact.clear();
        txtAddress.clear();
    }

    private boolean isExists(Student student) {
        for (Student student1 : students) {
            if (student1.getId().equalsIgnoreCase(student.getId())) {
                return true;
            }
        }
        return false;
    }

    public void saveAndUpdateOnAction(ActionEvent actionEvent) {

        if (btnSaveAndUpdate.getText().equalsIgnoreCase("Save")) {
            Student student = new Student(txtId.getText(), txtName.getText(), txtContact.getText(), txtAddress.getText());
            if (isExists(student)) {
                new Alert(Alert.AlertType.WARNING, "Already exists").showAndWait();
            } else {
                if (students.add(student)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.OK).showAndWait();
                    loadAllStudents();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).showAndWait();
                }
            }
        } else {

        }
    }

    private void loadAllStudents() {
        ObservableList<StudentTM> list = FXCollections.observableArrayList();
        for (Student temp : students) {
            Button button = new Button("Delete");
            list.add(new StudentTM(temp.getId(), temp.getName(), temp.getContact(), temp.getAddress(), button));
            button.setOnAction(event -> {

                ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "are you sure whether you want to delete this student?", yes, no);
                alert.setTitle("Confirmation");
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.orElse(no) == yes) {
                    students.remove(temp);
                    loadAllStudents();
                } else {
                }
            });
        }
        tblStudent.setItems(list);
    }

    public void moveToName(ActionEvent actionEvent) {
        txtName.requestFocus();
    }
}