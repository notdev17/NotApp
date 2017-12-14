

package controller;

import javafx.fxml.FXML;

/**
 * Created by Tim on 12/14/2017.
 */
public class MasterController {
    @FXML FirstPageController firstPageController;
    @FXML CompareAppliancesController compareAppliancesController;
    @FXML SearchApplianceController searchApplianceController;



    @FXML
    public void initialize() {
        firstPageController.setMasterController(this);
        compareAppliancesController.setMasterController(this);
        searchApplianceController.setMasterController(this);
    }


}
