package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URI;

/**
 * Created By Devon on 12/12/2017
 */
public class FirstPageController {

    private MasterController masterController;

    /**
     * Author: Devon on 12/12/2017
     * On 'event', go to Compare Appliances screen
     */
    @FXML
    public void getStartedButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

    /**
     * Author: Devon on 12/15/2017
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
     * Author: Devon on 12/15/2017
     */
    public void setMasterController(MasterController mc) {
        masterController = mc;
    }

}
