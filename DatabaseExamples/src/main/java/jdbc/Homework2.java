package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Homework2 {

	public static void main(String[] args) {
		// Homework 2
		// you dont need a scanner for this
		// write a query that returns the distict state where we have offices where the state is not null
		// loop over the result set and for each row do another query to select the customers that are in that state
		// print a message "-------------------------- <state> ----------------------" and then the customer number and customer name for that state
		// make a new statement for each query
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "Justinis#1!";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			// Homework 2
			// you dont need a scanner for this
			// write a query that returns the distinct state where we have offices where the state is not null
			// loop over the result set and for each row do another query to select the customers that are in that state
			// print a message "-------------------------- <state> ----------------------" and then the customer number and customer name for that state
			// make a new statement for each query
			String SelectSQL = "select distinct o.state "
					+ "from offices o "
					+ "where o.state is not null;";
					
			Statement stmt = connection.createStatement();
			//PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			ResultSet result = stmt.executeQuery(SelectSQL);
			while (result.next()) {
				String state = result.getString("State");
				System.out.println("------------------------" + state + "-------------------------------");
				String SelectSQL2 = "select distinct o.state, c.customerName, c.customerNumber "
						+ "from offices o, customers c "
						+ "where c.state = ? "
						+ "group by c.customerNumber "
						+ "order by o.state;";
				PreparedStatement stmt2 = connection.prepareStatement(SelectSQL2);
				stmt2.setString(1,state);
				ResultSet result2 = stmt2.executeQuery();
				while (result2.next()) {
					String customerName = result2.getString("CustomerName");
					String customerNumber = result2.getString("CustomerNumber");
					System.out.println("CustomerNumber: " + customerNumber + " | " + "CustomerName: " + customerName);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
