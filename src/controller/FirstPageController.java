package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URI;



// Introductory/Landing page controller
public class FirstPageController {

    private MasterController masterController;

    /**
     * On 'event', go to Compare Appliances screen
     */
    @FXML
    public void getStartedButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

    /**
     * On 'event', go to group website
     */
    @FXML
    public void websiteButtonClicked(ActionEvent event)
    {
        try{
            URI uri = new URI("http://notdev.us"); 
            java.awt.Desktop.getDesktop().browse(uri);
        } catch (Exception ex)
        { System.out.println(ex);}


    }

    /**
     * Enables use in master controller class
     */
    public void setMasterController(MasterController mc) {
        masterController = mc;
    }

}
