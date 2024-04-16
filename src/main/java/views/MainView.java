package views;

import javafx.fxml.FXML;
import models.User;
import util.State;

public class MainView {
    @FXML
    private void initialize() {
        System.out.println((User) State.get("user"));
    }
}
