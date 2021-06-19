
package br.com.zherro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import br.com.zherro.domain.Card;

/**
 * Insert PrepareStatement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class InsertPStatementExample {
    private static final String INSERT_USERS_SQL = "INSERT INTO tb_todo" +
        "  ( todoKey, title, notes, created_at) VALUES " +
        " (?, ?, ?, ?);";

    public static void main(String[] argv) throws SQLException {
        InsertPStatementExample createTableExample = new InsertPStatementExample();
        createTableExample.insertRecord("none", new Card());
    }

    public void insertRecord(String todoKey, Card card) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCConnector.getConnection();
        		
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, todoKey);
            preparedStatement.setString(2, card.getTitle());
            preparedStatement.setString(3, card.getDescription());
            
            Date now = new Date();
            preparedStatement.setDate(4, new java.sql.Date( now.getTime() ));

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
        	JDBCConnector.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}