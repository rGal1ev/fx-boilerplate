package fragments;

import javafx.fxml.FXML;
import models.User;
import util.*;

public class SecondFragment {
    @FXML
    private void initialize() {
        // Retrieving User from state
        User user = (User) StateManager.get("user");
    }
}
