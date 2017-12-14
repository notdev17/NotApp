

package controller;

import appliance.Appliance;
import javafx.fxml.FXML;

/**
 * Created by Tim on 12/14/2017.
 */
public class MasterController {
    @FXML FirstPageController firstPageController;
    @FXML CompareAppliancesController compareAppliancesController;
    @FXML SearchApplianceController searchApplianceController;

    @FXML
    private void initialize() {
        firstPageController.setMasterController(this);
        compareAppliancesController.setMasterController(this);
        searchApplianceController.setMasterController(this);
    }

    public void addSelected(Appliance a) {
        //compareAppliancesController.addSelectedAppliance(a);
        System.out.println("adding success");
    }
}
