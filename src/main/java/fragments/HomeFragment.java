package fragments;

import javafx.fxml.FXML;
import models.User;
import util.*;

public class HomeFragment {
    @FXML
    private void initialize() {
        // Retrieving User from state
        User user = (User) StateManager.get("user");

        // Can change fragment within the fragment by FragmentManager.change("name")
        // Can access root container by FragmentManager.getContainerViewController()
    }
}
