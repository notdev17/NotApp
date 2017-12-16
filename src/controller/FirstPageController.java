package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URI;

public class FirstPageController {

    private MasterController masterController;

    @FXML
    public void getStartedButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

    @FXML
    public void websiteButtonClicked(ActionEvent event)
    {
        try{
            URI uri = new URI("http://notdev.us");
            java.awt.Desktop.getDesktop().browse(uri);
        } catch (Exception ex)
        { System.out.println(ex);}


    }

    public void setMasterController(MasterController mc) {
        masterController = mc;
    }

}
