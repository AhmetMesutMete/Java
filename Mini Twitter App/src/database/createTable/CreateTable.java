package database.createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {

		String commandStr = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@myhost:1521:xe", "username", "password");
			Statement stm = con.createStatement();
			commandStr = "create table tableClient1(message_id number, string_message varchar2(45))";
			stm.executeUpdate(commandStr);

			commandStr = "create table tableClient2(message_id number, string_message varchar2(45))";
			stm.executeUpdate(commandStr);

			commandStr = "create table tableClient3(message_id number, string_message varchar2(45))";
			stm.executeUpdate(commandStr);

			commandStr = "create table tableClient4(message_id number, string_message varchar2(45))";
			stm.executeUpdate(commandStr);

			commandStr = "create table tableClient5(message_id number, string_message varchar2(45))";
			stm.executeUpdate(commandStr);

			stm.close();
		}catch (Exception e){
			System.out.println(e);
			System.out.println("creating table error");
		}

	}



}
