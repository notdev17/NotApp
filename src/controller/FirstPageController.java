package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class FirstPageController {

    private MasterController masterController;

    @FXML
    public void getStartedButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

    @FXML
    public void tutorialButtonClicked(ActionEvent event) {


    }

    public void setMasterController(MasterController mc) {
        masterController = mc;
    }

}
