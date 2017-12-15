

package controller;

import appliance.Appliance;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Tim on 12/14/2017.
 */
public class MasterController
{
    private ArrayList<Appliance> myApplianceList;

    private FXMLLoader myLoader;

    private Stage myStage;

    private Parent myParent;

    public MasterController(Stage stage)
    {
        myApplianceList = new ArrayList<>();
        myLoader = new FXMLLoader();
        myStage = stage;
        try
        {
            getFirstPage();
        } catch(Exception ex)
        {
            System.out.println(ex);
        }

    }

    void getFirstPage() throws IOException
    {
        myParent = myLoader.load(getClass().getResource("../fxml/FirstPage.fxml").openStream());
        ((FirstPageController)myLoader.getController()).setMasterController(this);
        myStage.setScene(new Scene(myParent));
        myStage.show();
        myLoader = new FXMLLoader();
    }

    void getComparePage() throws IOException
    {
        myParent = myLoader.load(getClass().getResource("../fxml/CompareAppliances.fxml").openStream());
        ((CompareAppliancesController)myLoader.getController()).setMasterController(this);
        myStage.setScene(new Scene(myParent));
        myStage.show();
        myLoader = new FXMLLoader();
    }

    void getSearchPage() throws IOException
    {
        myParent = myLoader.load(getClass().getResource("../fxml/SearchAppliance.fxml").openStream());
        ((SearchApplianceController)myLoader.getController()).setMasterController(this);
        myStage.setScene(new Scene(myParent));
        myStage.show();
        myLoader = new FXMLLoader();
    }

    void getCalculationsPage() throws IOException
    {
        myParent = myLoader.load(getClass().getResource("../fxml/CalculateSavings.fxml").openStream());
        ((CalculateSavingsController)myLoader.getController()).setMasterController(this);
        myStage.setScene(new Scene(myParent));
        myStage.show();
        myLoader = new FXMLLoader();
    }

    public ArrayList<Appliance> getSelectedAppliances()
    {
        return myApplianceList;
    }



}
