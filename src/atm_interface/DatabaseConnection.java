package atm_interface;

import java.sql.*;
public class DatabaseConnection {
    Connection c;
    Statement s;
    public DatabaseConnection(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bank_management_system", "root", "12345");
            s = c.createStatement();
        }
        catch (Exception e){
            System.out.println("An error occurred: " + e);
        }
    }
}
