package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AggregateJDBCExample {

	public static void main(String[] args) {
		
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "Justinis#1!";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter an amount: ");
			Integer amount = scan.nextInt();
			
			//String firstName = "Steve";
			String SelectSQL = "select c.customerNumber, c.customerName, avg((MSRP - buyPrice)*quantityOrdered) as avg_margin "
						+ "from orders o, orderdetails od, products p, customers c "
						+ "where o.orderNumber = od.orderNumber "
						+ "and od.productCode = p.productCode "
						+ "and o.customerNumber = c.customerNumber "
						+ "group by c.customerNumber "
					 	+ "having avg((MSRP - buyPrice)*quantityOrdered) > ? "
						+ "order by avg_margin desc;";
					
			//Statement stmt = connection.createStatement();
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setInt(1,amount);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String customerNumber = result.getString("customerNumber");
				String customerName = result.getString("customerName");
				String averageMargin = result.getString("avg_margin");				
				System.out.println(customerNumber + ": " + customerName + " " + averageMargin);
			}
			scan.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	}


