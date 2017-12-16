package controller;

import appliance.Appliance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CompareAppliancesController {

    @FXML
    ButtonBar myCalculateBox;

    @FXML
    private VBox sliderVBox;
    private MasterController masterController;
    @FXML
    private TableView<Appliance> myTableView;
    //columns in the table view
    @FXML
    private TableColumn<Appliance, String> brandColumn;
    @FXML
    private TableColumn<Appliance, String> modelColumn;
    @FXML
    private TableColumn<Appliance, String> energyColumn;

    @FXML
    private void initialize() {
        //set up the columns in the table
        //priceColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("price"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));
        if (masterController == null) {
            myCalculateBox.setDisable(true);
        } else {
            System.out.println(myTableView.getItems());
            if (masterController.getSelectedAppliances().size() > 0) {

                myCalculateBox.setDisable(false);
            }
        }
    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getFirstPage();
    }

    @FXML
    public void createApplianceButtonClicked(ActionEvent event) throws IOException {
        masterController.getSearchPage();
    }

    void setMasterController(MasterController mc) {
        masterController = mc;
        if (masterController.getSelectedAppliances().size() > 0) {
            myTableView.getItems().addAll(masterController.getSelectedAppliances());
            System.out.println(masterController.getSelectedAppliances());
            myCalculateBox.setDisable(false);
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
