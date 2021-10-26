package controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

public class DashboardFormController {
    public AnchorPane rootContext;
    public ImageView imgStudent;
    public Label lblMenu;
    public Label lblDescription;
    public ImageView imgTeacher;
    public ImageView imgLogOff;

    public void playMouseExitAnimation(MouseEvent mouseEvent) {
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
    }

    public void navigate(MouseEvent mouseEvent) {
    }

    public void exitOnAction(MouseEvent mouseEvent) {
        ButtonType buttonType = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonType1 = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Did you exit the system?", buttonType, buttonType1);
        alert.setTitle("Confirmation");
        Optional<ButtonType> close = alert.showAndWait();
        if (close.orElse(buttonType1) == buttonType) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void aboutUsOnAction(MouseEvent mouseEvent) {
    }
}
