package br.com.zherro.db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import br.com.zherro.domain.Card;

/**
 * Select PreparedStatement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class SelectPStatementExample {
    private static final String QUERY = "select id,todoKey, title, notes, created_at from tb_todo where todoKey = ?";
    private static final String QUERY2 = "select id,todoKey, title, notes, created_at from tb_todo where todoKey = ? and id = ?";

    public static void main(String[] args) {


    }
    
    public List<Card> executeSelectStatment(String key) {
        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCConnector.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
        	
            preparedStatement.setString(1, key);
            System.out.println(preparedStatement);
            
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            
            List<Card> cards = new ArrayList();
            
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getInt("id");
                String todoKey = rs.getString("todoKey");
                String title = rs.getString("title");
                String notes = rs.getString("notes");
                Date createdAt = rs.getDate("created_at");
                
                Card card = new Card();
                card.setId(id);
                card.setTitle(title);
                card.setDescription(notes);
                card.setDate( LocalDateTime.ofInstant(Instant.ofEpochMilli( createdAt.getTime() ), ZoneId.of("UTC-4")) );
                cards.add(card);
                
                System.out.println(id + "," + todoKey + "," + title + "," + notes + "," + createdAt);
            }
            
            return cards;
            
        } catch (SQLException e) {
        	JDBCConnector.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        
        return new ArrayList<Card>();
    }

	public Card executeSelectStatment(String key, Long idNote) {
        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCConnector.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {

            preparedStatement.setString(1, key);
            preparedStatement.setLong(2, idNote);
            System.out.println(preparedStatement);
            
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            
            Card card = new Card();
            
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getInt("id");
                String todoKey = rs.getString("todoKey");
                String title = rs.getString("title");
                String notes = rs.getString("notes");
                Date createdAt = rs.getDate("created_at");

                card.setId(id);
                card.setTitle(title);
                card.setDescription(notes);
                card.setDate( LocalDateTime.ofInstant(createdAt.toInstant(), ZoneId.of("BET")) );
                
                System.out.println(id + "," + todoKey + "," + title + "," + notes + "," + createdAt);
            }
            
            return card;
            
        } catch (SQLException e) {
        	JDBCConnector.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        
        return new Card();
	}
}