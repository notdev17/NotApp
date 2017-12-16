package controller;

import appliance.Appliance;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

/**
 * Created by
 */
public class UserController {

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

    @FXML
    private void initialize() {
        //set up the columns in the table
        //priceColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("price"));
        favBrandCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        favModelCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        favEnergyCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));
        favTypeCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("applianceType"));

        if (masterController == null)
        {
            favRemoveButton.setDisable(true);
        }
    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

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
