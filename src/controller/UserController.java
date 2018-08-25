package controller;

import appliance.Appliance;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

/**
 * Controller used for the user page
 */
public class UserController {


    @FXML
    ButtonBar myCalculateBox;
    private MasterController masterController;


    @FXML
    private TableView<Appliance> favTableView;
    
    //columns in the table view
    @FXML
    private TableColumn<Appliance, String> favBrandCol;
    @FXML
    private TableColumn<Appliance, String> favModelCol;
    @FXML
    private TableColumn<Appliance, String> favEnergyCol;
    @FXML
    private TableColumn<Appliance, String> favTypeCol;
    @FXML
    private Button favRemoveButton;


    // Initializes the tables for the page
    @FXML
    private void initialize() {
        // Setup Col values for table
        favBrandCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        favModelCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        favEnergyCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));
        favTypeCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("applianceType"));

        if (masterController == null)
        {
            favRemoveButton.setDisable(true);
        }
    }

    // action for the back button being pressed
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

    /**     
     * If the user has favorited appliances this populates the user page with them.
     */
    void setMasterController(MasterController mc) {
        masterController = mc;
        if (masterController.getFavoriteAppliances().size() > 0)
        {
            favTableView.setItems(FXCollections.observableArrayList(masterController.getFavoriteAppliances()));
            favRemoveButton.setDisable(false);
        }
        else
        {
            favRemoveButton.setDisable(true);
        }
    }

    /**
     * Displays the calculate savings page from the fxml file when the user clicks the 'Calculate Savings' button.
     */
    @FXML
    public void calcSavingsButtonClicked(ActionEvent event) throws IOException {
        masterController.getCalculationsPage();
    }

    /**
     * Removes selected appliance from table view and user favorites list on button clicked event
     */
    @FXML
    void removeFromFavButtonClicked() {
        //remove the selected item from the favorites list in the master controller
        masterController.getFavoriteAppliances().remove(favTableView.getSelectionModel().getSelectedItem());

        //refresh the table view
        favTableView.setItems(FXCollections.observableArrayList(masterController.getFavoriteAppliances()));
        if (favTableView.getSelectionModel().getSelectedItems().isEmpty())
        {
            favRemoveButton.setDisable(true);
        }
    }
}
