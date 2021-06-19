package br.com.zherro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class JDBCConnector {

	public static Connection getConnection() throws SQLException {
		Connection conexao = null;

		try {
			// When this class first attempts to establish a connection, it automatically
			// loads any JDBC 4.0 drivers found within
			// the class path. Note that your application must manually load any JDBC
			// drivers prior to version 4.0.

			Class.forName("org.postgresql.Driver");

//			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		// String url = "jdbc:mysql://localhost:3306/loja"; //Nome da base de dados

		 String url = "jdbc:postgresql://localhost:5432/teste-aula"; //Nome da base de dados

	 
		conexao = DriverManager.getConnection(url, "root", "root");
		return conexao;
	}
	

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	public static void createTable() {
		
		final String SQL_CREATE = "CREATE TABLE EMPLOYEE"
	            + "("
	            + " ID serial,"
	            + " NAME varchar(100) NOT NULL,"
	            + " SALARY numeric(15, 2) NOT NULL,"
	            + " CREATED_DATE timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,"
	            + " PRIMARY KEY (ID)"
	            + ")";
		
		 try (Connection conn = DriverManager.getConnection(
	             "jdbc:postgresql://127.0.0.1:5432/test", "postgres", "password");
	          Statement statement = conn.createStatement()) {
	
	         // if DDL failed, it will raise an SQLException
	         statement.execute(SQL_CREATE);
	
	     } catch (SQLException e) {
	         System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	     } catch (Exception e) {
	         e.printStackTrace();
	     }

	}
}
