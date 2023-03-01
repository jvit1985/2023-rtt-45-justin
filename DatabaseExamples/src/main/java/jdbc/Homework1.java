package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
		
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "Justinis#1!";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter an amount: ");
			Integer amount = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter a state: ");
			String state = scan.nextLine();
			
			//I want to see a list of all customers that have made a payment larger than <amount> in a particular <state>
			//Print the checkNumber, amount (formatted to $#.00 ) and the customer name ordered by the largest amount first
			//input variables for the scanner are 1) the amount and 2) 2 digit state code
			String SelectSQL = "select c.customerName, p.checkNumber, p.amount, c.state "
					+ "from customers c, payments p "
					+ "where c.customerNumber = p.customerNumber "
					+ "and p.amount > ? "
					+ "and c.state = ? "
					+ "order by p.amount desc;";
					
			//Statement stmt = connection.createStatement();
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setInt(1,amount);
			stmt.setString(2,state);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String customerName = result.getString("customerName");
				String checkNumber = result.getString("checkNumber");
				String amountPaid = result.getString("amount");	
				String statePicked = result.getString("state");
				System.out.println(customerName + ": " + checkNumber + " : " + amountPaid + " | " + statePicked);
			}
			scan.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
