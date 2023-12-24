package views;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import util.FragmentManager;

import java.util.HashMap;
import java.util.Map;

public class ContainerView {
    @FXML private VBox container;

    private Map<String, Object> state = new HashMap<>();

    public void init(Object startData) {
        // To work with fragments go to "/app/Configuration"

        // Can set initial value to state
        state.put("start_data", startData);

        FragmentManager.injectFields(container, this, state);

        // Change fragment to HomeFragment
        FragmentManager.change("home");
    }
}
