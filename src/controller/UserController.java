package controller;

import appliance.Appliance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class UserController {

    @FXML
    ButtonBar myCalculateBox;
    private MasterController masterController;
    @FXML
    private TableView<Appliance> favTableView;
    //columns in the table view
    @FXML
    private TableColumn<Appliance, String> userBrandColumn;
    @FXML
    private TableColumn<Appliance, String> userModelColumn;
    @FXML
    private TableColumn<Appliance, String> UserEnergyColumn;

    @FXML
    private void initialize() {
        //set up the columns in the table
        //priceColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("price"));
        //userBrandColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        //userModelColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        //UserEnergyColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));

        if (masterController == null) {

        }
    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getCalculationsPage();
    }

    void setMasterController(MasterController mc) {
        masterController = mc;
        if (masterController.getSelectedAppliances().size() > 0) {
            //favTableView.getItems().addAll(masterController.getSelectedAppliances());
            //myCalculateBox.setDisable(false);
        }
    }

    /**
     * By Daylen
     * Displays the calculate savings page from the fxml file
     *
     * @param event, sent when the button is clicked
     * @throws IOException
     */
    @FXML
    public void calcSavingsButtonClicked(ActionEvent event) throws IOException {
        masterController.getCalculationsPage();
    }
}
