package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.ContainerView;

import java.io.IOException;

public class WindowManager {
    public static void change(Node node, String path, String title, Object data) {
        FXMLLoader fxmlLoader = new FXMLLoader(WindowManager.class.getResource(path));
        Stage rootStage = (Stage) node.getScene().getWindow();

        try {
            Scene scene = new Scene(fxmlLoader.load());
            ContainerView containerView = fxmlLoader.getController();
            containerView.init(data);

            rootStage.setScene(scene);
            rootStage.setTitle(title);

        } catch (IOException ignored) {}
    }
}
