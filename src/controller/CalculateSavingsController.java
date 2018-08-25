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

/**
    Controller for the Calculate savings page.
 */
public class CalculateSavingsController {

    //Table view to hold the relevant output values
    @FXML
    private TableView<Appliance> calculationsTableView;

    //Columns to be used in the table view
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

    /**
     * Initializes table view columns.
     */
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

    /**
     * Event listener for the back button.
     * On event, return to Compare Page.
     */
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

    /**
     * Closes the window (program) on 'event'
     */
    @FXML
    public void doneButtonClicked(ActionEvent event) {
        //get the window from the action event
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //close the window
        window.close();
    }

    /**
     * Goes to the User Page scene on button clicked.
     */
    @FXML
    public void userProfileButtonClicked() throws IOException{
        masterController.getUserPage();
    }

    /**
     * If selectedAppliances (stored in masterController) is not empty, uses selectedAppliances to populate table view
     */
    void setMasterController(MasterController mc) {
        masterController = mc;
        if (masterController.getSelectedAppliances().size() > 0) {
            calculationsTableView.getItems().addAll(masterController.getSelectedAppliances());
        }
    }

    /**
     * Adds selected appliance to the favoriteAppliances list.
     * Post: a new appliance will be added to the user's favorite's list, and user will be taken to the User Page.
     */
    @FXML
    public void addToFavButtonClicked() throws IOException {
        //If an appliance is selected
        if(calculationsTableView.getSelectionModel().getSelectedItem() != null) {
            //add selected appliance to user favorites
            masterController.getFavoriteAppliances().add(calculationsTableView.getSelectionModel().getSelectedItem());
            //go to user page
            masterController.getUserPage();
            //populate user page with viewable list of favorites
            calculationsTableView.setItems(FXCollections.observableArrayList(masterController.getFavoriteAppliances()));
        }
    }

    /**
     * Updates the calculations page with valid 'cost per year' values.
     */
    @FXML
    public void updateButtonClicked() throws IOException
    {
        //If user input is not empty
        if (calcPriceInput.getCharacters().length() != 0)
        {
            //And if input is a double greater than 0
            if (Double.parseDouble(calcPriceInput.getCharacters().toString()) > 0.0)
            {
                //Multiply estimated energy by user input for each item, and store product in the relevant
                //appliance objects (in order to display value in table view)
                for (int i = 0; i < calculationsTableView.getItems().size(); i++)
                {
                    calculationsTableView.getItems().get(i).setPrice(Double.parseDouble(calcPriceInput.getCharacters().toString()));
                }
                masterController.getCalculationsPage();
            }
        }
    }
}
