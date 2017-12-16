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

    /**
     * @author Michelle
     * For getting back to tutorial page..
     */
    @FXML
    public void tutorialButtonClicked(ActionEvent event) throws IOException{
        Parent tutorialParent = FXMLLoader.load(getClass().getResource("../fxml/Tutorial.fxml"));
        Scene tutorialScene = new Scene(tutorialParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tutorialScene);

        window.show();
    }

    public void setMasterController(MasterController mc) {
        masterController = mc;
    }

}
