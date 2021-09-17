package database.createTable;

import java.sql.*;

public class DataBaseManagement {

    private Connection con;

    public DataBaseManagement() throws SQLException {
        this.con = DriverManager.getConnection("jdbc:oracle:thin:@myhost:1521:xe","username","password");
    }

    public void addMessage(int clientId,String message){
        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection("jdbc:oracle:thin:@myhost:1521:xe","username","password");
            Statement stm = con.createStatement();
            String commandStr = "Insert into tableClient"+clientId+" values ("+ clientId +", '" + message +"');";
            System.out.println(commandStr);
            stm.executeUpdate(commandStr);
            System.out.println("Message added");
            stm.close();
        }catch (Exception e){
            System.out.println("add message error");
        }
    }

    public void getMessage(int clientId){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@myhost:1521:xe","username","password");
            Statement stm = con.createStatement();
            String commandStr = "select * from tableClient"+clientId;
            ResultSet result = stm.executeQuery(commandStr);
            stm.close();
            while(result.next()) {
                String id_name = result.getString("id");
                String string_name = result.getString("string_name");
                System.out.println(id_name + " -> " + string_name);

            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
