package br.com.zherro.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.zherro.db.InsertPStatementExample;
import br.com.zherro.db.SelectPStatementExample;
import br.com.zherro.domain.Card;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TodoFactory {
	
		public static final Map<String, List<Card>> todoArchive = new HashMap();
		

		public static List<Card> listCards( String todoKey ) {
			SelectPStatementExample seleStatement = new SelectPStatementExample();
			return seleStatement.executeSelectStatment(todoKey);
		}
		
		public static Card getById(String todoKey, Long id) {
			SelectPStatementExample seleStatement = new SelectPStatementExample();
			return seleStatement.executeSelectStatment(todoKey, id);
		}

		public static void addCard(String todoKey, Card card) {
			
			 InsertPStatementExample createTableExample = new InsertPStatementExample();
		     try {
				createTableExample.insertRecord(todoKey, card);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
	
}
