package views;

import app.Configuration;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import util.WindowManager;

public class StartView {
    @FXML private VBox loginContainer;
    @FXML private VBox regContainer;

    @FXML private Label showRegistration;
    @FXML private Button register;

    @FXML private Button showLogin;
    @FXML private Button login;

    private final BooleanProperty isRegistering = new SimpleBooleanProperty(false);

    @FXML
    private void initialize() {
        handleProperties();
        handleEvents();
    }

    private void handleProperties() {
        regContainer.managedProperty().bind(isRegistering);
        regContainer.visibleProperty().bind(isRegistering);

        loginContainer.managedProperty().bind(isRegistering.not());
        loginContainer.visibleProperty().bind(isRegistering.not());
    }
    private void handleEvents() {
        showRegistration.setOnMouseClicked(event -> {
            isRegistering.set(true);
        });

        showLogin.setOnMouseClicked(event -> {
            isRegistering.set(false);
        });

        register.setOnMouseClicked(event -> {
            userAuth();
            WindowManager.change(register, "/views/container-view.fxml", Configuration.WindowTitle.main, "Some data");
        });

        login.setOnMouseClicked(event -> {
            userAuth();
            WindowManager.change(register, "/views/container-view.fxml", Configuration.WindowTitle.main, "Some data");
        });
    }

    private void userAuth() {}
}