package controller;

import appliance.Appliance;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculateSavingsController {

    @FXML
    private TableView<Appliance> calculationsTableView;

    //columns in the table view
    @FXML
    private TableColumn<Appliance, String> calcModelCol;
    @FXML
    private TableColumn<Appliance, String> calcBrandCol;
    @FXML
    private TableColumn<Appliance, String> calcEnergyCol;
    @FXML
    private TableColumn<Appliance, String> calcTypeCol;
    @FXML
    private TableColumn<Appliance, Double> calcPriceCol;
    @FXML
    private TableColumn<Appliance, Double> calcResultCol;
    @FXML
    private TextField calcPriceInput;

    private MasterController masterController;

    @FXML
    private void initialize()
    {
        //set up the columns in the table
        calcTypeCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("applianceType"));
        calcModelCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        calcBrandCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        calcEnergyCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));
        calcPriceCol.setCellValueFactory(new PropertyValueFactory<Appliance, Double>("price"));
        calcResultCol.setCellValueFactory(new PropertyValueFactory<Appliance, Double>("result"));

    }
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

    /**
     * closes the window when the done button that is clicked
     * By: Daylen
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void doneButtonClicked(ActionEvent event) {
        //get the window from the action event
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //close the window
        window.close();
    }

    @FXML
    public void userProfileButtonClicked() throws IOException{
        masterController.getUserPage();
    }

    void setMasterController(MasterController mc) {
        masterController = mc;
        if (masterController.getSelectedAppliances().size() > 0) {
            calculationsTableView.getItems().addAll(masterController.getSelectedAppliances());
        }
    }

    @FXML
    public void addToFavButtonClicked() throws IOException {
        if(calculationsTableView.getSelectionModel().getSelectedItem() != null) {
            masterController.getFavoriteAppliances().add(calculationsTableView.getSelectionModel().getSelectedItem());
            masterController.getUserPage();
            calculationsTableView.setItems(FXCollections.observableArrayList(masterController.getFavoriteAppliances()));
        }
    }
    @FXML
    public void updateButtonClicked() throws IOException
    {
        if (calcPriceInput.getCharacters().length() != 0)
        {
            if (Double.parseDouble(calcPriceInput.getCharacters().toString()) > 0.0)
            {
                calculationsTableView.getSelectionModel().getSelectedItem().setPrice(Double.parseDouble(calcPriceInput.getCharacters().toString()));
                masterController.getCalculationsPage();
            }
        }
    }
}
