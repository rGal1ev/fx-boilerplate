package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

// Only used to switch from StartView to ContainerView

public class WindowManager {
    public static void change(Node node, String path, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(WindowManager.class.getResource(path));
        Stage rootStage = (Stage) node.getScene().getWindow();

        try {
            BorderPane view = fxmlLoader.load();
            Scene scene = new Scene(view);

            rootStage.setScene(scene);
            rootStage.centerOnScreen();

            rootStage.setResizable(true);
            rootStage.setTitle(title);

        } catch (IOException ignored) {}
    }
}
