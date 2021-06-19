package br.com.zherro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create Statement JDBC Example
 * @author Ramesh Fadatare
 *
 */
public class CreateStatementExample {

	private static final String createTableSQL = (new StringBuilder())
			.append( "CREATE TABLE IF NOT EXISTS tb_todo ( " )
			.append(" id bigserial primary key not null,  " )
			.append(" todoKey varchar(50),   ")
			.append(" title varchar(255),   ")
			.append(" notes	text,  " )
			.append(" created_at timestamp   ")
			.append(" ); ")
			.toString();
    

    public static void main(String[] argv) throws SQLException {
        CreateStatementExample createTableExample = new CreateStatementExample();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCConnector.getConnection();
            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);
            
            System.out.println(createTableSQL);
        } catch (SQLException e) {

            // print SQL exception information
        	JDBCConnector.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}