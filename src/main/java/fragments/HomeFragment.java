package fragments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.FragmentManager;

public class HomeFragment {
    @FXML private Button changeFragment;
    @FXML private TextField field;

    @FXML
    private void initialize() {
        // Change fragment to SecondFragment

        changeFragment.setOnMouseClicked(event -> {
            FragmentManager.change("second");
        });

        // Handle state

        String fieldState = (String) FragmentManager.getState().get("field");
        field.setText(fieldState);

        field.textProperty().addListener((options, oldValue, newValue) -> {
            FragmentManager.getState().put("field", newValue);
        });
    }
}
