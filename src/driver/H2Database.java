package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H2Database {

    private Connection conn;
    private ResultSet result;

    public H2Database() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/NotAppDB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sql(String st) {
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void command(String st) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResult() {
        return result;
    }

    public void closeConnection() throws Exception {
        conn.close();
    }

    public void clear() {
        command("DROP ALL OBJECTS");
    }

    public void selectCsvFile(String f) {
        command("CREATE TABLE CSV AS SELECT * FROM CSVREAD('" + f + ".csv');");
    }

}
