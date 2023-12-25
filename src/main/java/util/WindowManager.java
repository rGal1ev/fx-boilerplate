package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.ContainerView;

import java.io.IOException;

public class WindowManager {
    public static void change(Node node, String path, String title, Object data) {
        FXMLLoader fxmlLoader = new FXMLLoader(WindowManager.class.getResource(path));
        Stage rootStage = (Stage) node.getScene().getWindow();

        try {
            BorderPane view = fxmlLoader.load();
            Scene scene = new Scene(view);
            ContainerView containerView = fxmlLoader.getController();
            containerView.init(data);

            rootStage.setScene(scene);
            rootStage.centerOnScreen();

            rootStage.setResizable(true);
            rootStage.setTitle(title);

        } catch (IOException ignored) {}
    }
}
