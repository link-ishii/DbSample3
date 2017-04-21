package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbAccess {

    private Connection connect;
    private Statement state;
    private String driver, connectURL, id, pass;

    public DbAccess() {
        connectURL = "jdbc:mysql://133.130.100.142:3306/linkdb";
        driver = "com.mysql.jdbc.Driver";
        id = "linkroad";
        pass = "Akira1203!";
    }

    public synchronized void ConnectOpen() throws Exception {
        Class.forName(driver);
        connect = DriverManager.getConnection(connectURL, id ,pass);
        state = connect.createStatement();
    }

    public ResultSet ExeQuery(String s) throws Exception {
      return state.executeQuery(s);
    }

    public synchronized void ConnectClose() throws Exception {
        if (state != null)
            state.close();

        if (connect != null)
          connect.close();
    }
}
