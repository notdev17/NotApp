package driver;

import appliance.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Tim on 12/7/2017.
 * Allows the use of locally stored CSVs to be used as a database.
 */
public class H2Database {

    private Connection conn;
    private ResultSet result;
    //Holds all read inputs as the appropriate Appliance sub-type
    private ArrayList<Appliance> appliances;
    //Used to ensure proper CSV files and proper Appliance sub-types are used on calls throughout the program
    private String currentAppliance;

    /**
     * Author: Tim on 12/7/2017
     * Instantiates the connection between program and H2 database.
     */
    public H2Database() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/NotAppDB");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // database commands
        clear();
        parseCsvFiles();

        appliances = new ArrayList<Appliance>();
    }

    /**
     * Author: Tim on 12/7/2017
     * Used to select a DB table based on input 'str'
     * Pre: str is a valid input [airconditioner, refrigerator, washingmachine, dryer, freezer, aircleaner, dishwasher]
     * Post: Will successfully send a valid SQL query to H2 DBMS.
     */
    public void selectTable(String str) {
        currentAppliance = str;

        String query = generateSelectQuery(str);
        sql(query);
    }


    /**
     * Author: Tim on 12/7/2017
     * Used to populate 'appliance' with valid Appliance sub-types
     * Returns a list of Appliance sub-types
     */
    public ArrayList<Appliance> getAppliances() {
        try {
            while (result.next()) {
                String m = result.getString("model"),
                        b = result.getString("brand");
                double e = result.getDouble("energy");

                /*DEVON (edited 12/9/2017)
                  Added new else branches for additional appliance types
                 */
                if (currentAppliance.equals("airconditioner")) {
                    appliances.add(new AirConditioner(m, b, e));
                } else if (currentAppliance.equals("refrigerator")) {
                    appliances.add(new Refrigerator(m, b, e));
                } else if (currentAppliance.equals("washingmachine")) {
                    appliances.add(new WashingMachine(m, b, e));
                } else if (currentAppliance.equals("dryer")) {
                    appliances.add(new Dryer(m, b, e));
                } else if (currentAppliance.equals("freezer")) {
                    appliances.add(new Freezer(m, b, e));
                } else if (currentAppliance.equals("aircleaner")) {
                    appliances.add(new AirCleaner(m, b, e));
                } else if (currentAppliance.equals("dishwasher")) {
                    appliances.add(new Dishwasher(m, b, e));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return appliances;
    }

    /**
     * Author: Tim on 12/7/2017
     * For SQL statements
     *
     * @param str
     */
    public void sql(String str) {
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Author: Tim on 12/7/2017
     * For DBMS commands
     *
     * @param str
     */
    public void command(String str) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Author: Tim on 12/7/2017
     * Closes DB connection
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Author: Tim on 12/7/2017
     * Clears all query-generated tables from DB
     */
    private void clear() {
        command("DROP ALL OBJECTS");
    }

    /*Edited By Devon, 12/12/2017
      updated file paths to match new CSV files
     */
    private void parseCsvFiles() {
        command("CREATE TABLE AIR_CONDITIONER AS SELECT * FROM CSVREAD('./database/ESC_Room_Air_Conditioners.csv');");
        command("CREATE TABLE AIR_CLEANER AS SELECT * FROM CSVREAD('./database/ESC_Room_Air_Cleaners.csv');");
        command("CREATE TABLE WASHING_MACHINE AS SELECT * FROM CSVREAD('./database/ESC_Residential_Clothes_Washers.csv');");
        command("CREATE TABLE DRYING_MACHINE AS SELECT * FROM CSVREAD('./database/ESC_Residential_Clothes_Dryers.csv');");
        command("CREATE TABLE REFRIGERATOR AS SELECT * FROM CSVREAD('./database/ESC_Residential_Refrigerators.csv');");
        command("CREATE TABLE FREEZER AS SELECT * FROM CSVREAD('./database/ESC_Residential_Freezers.csv');");
        command("CREATE TABLE DISHWASHER AS SELECT * FROM CSVREAD('./database/ESC_Residential_Dishwashers.csv');");
    }

    /**
     * Author: Devon 12/7/2017
     * Generates an SQL query based on input s, where s is a valid appliance type.
     * Pre: s is a valid string (see cases below)
     * Post: generates and returns a valid SQL query as a String
     */
    private String generateSelectQuery(String s) {
        String query = "";

        /*Edited By Devon, 12/12/2017
          Updated query attribute names to match new CSV database files
          Added new switch cases for additional database files
         */
        switch (s) {
            case "airconditioner":
                query = "SELECT Model_Number AS model," +
                        "Brand_Name AS brand," +
                        "Combined_Energy_Efficiency_Ratio AS energy" +
                        " FROM AIR_CONDITIONER";
                break;
            case "washingmachine":
                query = "SELECT Model_Number AS model," +
                        "Brand_Name AS brand," +
                        "Estimated_Annual_Energy_Use AS energy" +
                        " FROM WASHING_MACHINE";
                break;
            case "refrigerator":
                query = "SELECT Model_Number AS model," +
                        "Brand_Name AS brand," +
                        "Estimated_Annual_Energy_Use AS energy" +
                        " FROM REFRIGERATOR";
                break;
            case "dishwasher":
                query = "SELECT Model_Number AS model," +
                        "Brand_Name AS brand," +
                        "Estimated_Annual_Energy_Use AS energy" +
                        " FROM DISHWASHER";
                break;
            case "aircleaner":
                query = "SELECT Model_Number AS model," +
                        "Brand_Name AS brand," +
                        "Total_Energy_Consumption_Watts AS energy" +
                        " FROM Air_Cleaner";
                break;
            case "dryer":
                query = "SELECT Model_Number AS model," +
                        "Brand_Name AS brand," +
                        "Estimated_Annual_Energy_Use AS energy" +
                        " FROM DRYING_MACHINE";
                break;
            case "freezer":
                query = "SELECT Model_Number AS model," +
                        "Brand_Name AS brand," +
                        "Estimated_Annual_Energy_Use AS energy" +
                        " FROM FREEZER";
                break;
        }

        return query;
    }

}