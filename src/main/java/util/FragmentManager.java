package util;

import app.App;
import app.Configuration;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import views.ContainerView;

import java.io.IOException;
import java.util.Map;

public class FragmentManager {
    private static VBox container;
    private static ContainerView containerViewController;
    private static Map<String, Object> state;

    public static void injectFields(VBox injectableContainer, ContainerView injectableController, Map<String, Object> injectableState) {
        container = injectableContainer;
        containerViewController = injectableController;
        state = injectableState;
    }

    public static void change(String name) {
        container.getChildren().clear();

        String fragmentPath =  Configuration.Fragments.fragments.get(name);
        loadFragment(fragmentPath);
    }

    public static Map<String, Object> getState() {
        return state;
    }

    private static void loadFragment(String path) {
        FXMLLoader fragmentLoader = new FXMLLoader(App.class.getResource(path));

        try {
            container.getChildren().add(fragmentLoader.load());

        } catch (IOException ignored) {}
    }
}
