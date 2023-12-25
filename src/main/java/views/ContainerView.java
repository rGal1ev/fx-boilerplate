package views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import util.FragmentManager;

public class ContainerView {
    @FXML private VBox container;

    @FXML private Button home;
    @FXML private Button second;

    public void init(Object startData) {
        FragmentManager.injectFields(container, this);
        handleEvents();

        // Change fragment to HomeFragment
        FragmentManager.change("home");
    }

    private void handleEvents() {
        home.setOnMouseClicked(event -> {
            FragmentManager.change("home");
        });

        second.setOnMouseClicked(event -> {
            FragmentManager.change("second");
        });
    }
}
