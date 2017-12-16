package controller;

import appliance.Appliance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created by Daylen on 12/11/2017
 */
public class CompareAppliancesController {

    @FXML
    ButtonBar myCalculateBox;

    private MasterController masterController;
    @FXML
    private TableView<Appliance> myCompareTableView;

    //columns in the table view
    @FXML
    private TableColumn<Appliance, String> brandColumn;
    @FXML
    private TableColumn<Appliance, String> modelColumn;
    @FXML
    private TableColumn<Appliance, String> energyColumn;
    @FXML
    private TableColumn<Appliance, String> typeColumn;

    /**
     * Author: Daylen on 12/11/2017
     * Initializes the columns in the table view
     */
    @FXML
    private void initialize() {
        //set up the columns in the table
        typeColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("applianceType"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));
        if (masterController == null)
        {
            myCalculateBox.setDisable(true);
        }
    }

    /**
     * Author: Daylen on 12/11/2017
     * When the back button is clicked (event), displays the first page screen
     */
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getFirstPage();
    }

    /**
     * Author: Daylen on 12/11/2017
     * When the create(add) appliance button is clicked (event), displays the search appliances page.
     */
    @FXML
    public void createApplianceButtonClicked(ActionEvent event) throws IOException {
        masterController.getSearchPage();
    }

    /**
     * Author: Daylen on 12/14/2017
     * Enables the 'Calculate Savings' button when at least one appliances has been selected
     */
    void setMasterController(MasterController mc) {
        masterController = mc;
        if (masterController.getSelectedAppliances().size() > 0) {
            myCompareTableView.getItems().addAll(masterController.getSelectedAppliances());
            myCalculateBox.setDisable(false);
        }
    }

    /**
     * Author: Daylen on 12/14/2017
     * On event, displays the calculate savings page from the fxml file
     */
    @FXML
    public void calcSavingsButtonClicked(ActionEvent event) throws IOException {
        masterController.getCalculationsPage();
    }

    /**
     * Author: Daylen on 12/14/2017
     * When the remove button is clicked, if an appliance is currently selected, appliance is removed from the table view
     */
    @FXML
    public void removeButtonClicked() {
        masterController.getSelectedAppliances().remove(myCompareTableView.getSelectionModel().getSelectedItem());
        myCompareTableView.setItems(observableArrayList(masterController.getSelectedAppliances()));
        //If the final appliance in the table is removed, disables the 'Calculate Savings' button
        if (masterController.getSelectedAppliances().size() == 0)
        {
            myCalculateBox.setDisable(true);
        }
    }

    /**
     * Author: Daylen on 12/15/2017
     * When the add to favorites button is selected, adds the selected appliance to user favorites.
     */
    @FXML
    public void addToFavButtonClicked() throws IOException {
        //If an appliance is not selected, do nothing.
        if(myCompareTableView.getSelectionModel().getSelectedItem() != null) {
            masterController.getFavoriteAppliances().add(myCompareTableView.getSelectionModel().getSelectedItem());
            masterController.getUserPage();
        }
    }
}
