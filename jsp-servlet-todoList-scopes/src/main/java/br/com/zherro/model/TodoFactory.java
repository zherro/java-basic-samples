package br.com.zherro.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.zherro.domain.Card;

import java.util.ArrayList;
import java.util.HashMap;

public class TodoFactory {
	
		public static final Map<String, List<Card>> todoArchive = new HashMap();
		
		private static void initList() {
			
			int max = Integer.MAX_VALUE;
			int min = 100;
			long id = (long)Math.floor(Math.random()*(max-min+1)+min);
			
			Card card = new Card();
			card.setId(1L);
			card.setTitle("Title 1");
			card.setDescription("Life is too short to be alone, too precious. Share it with a friend."
					+ " All you have to do is let your imagination go wild. We must be quiet, soft and gentle.");
			
			id = (long)Math.floor(Math.random()*(max-min+1)+min);
			
			Card card1 = new Card();
			card1.setId(id);
			card1.setTitle("Title 2");
			card1.setDescription("Life is too short to be alone, too precious. Share it with a friend."
					+ " All you have to do is let your imagination go wild. We must be quiet, soft and gentle.");
			
			
			List<Card> cards = new ArrayList<Card>();
			
			cards.add(card);
			cards.add(card);
			cards.add(card1);
		}

		public static List<Card> listCards( String todoKey ) {
			List<Card> cards = todoArchive.get(todoKey);
			
			return cards == null
					? new ArrayList<Card>()
					: cards;
		}

		public static void createCards() {
			initList();
		}
		
		public static Card getById(String todoKey, Long id) {
			
			List<Card> cards = listCards( todoKey );
			
			Optional<Card> card =  cards.stream()
										.filter( c -> c.getId().equals(id) )
										.findFirst();
			return card.orElse(null);
		}

		public static void addCard(String todoKey, Card card, final Long id) {
			
			List<Card> cards = listCards( todoKey );
			
			if( id <= 0  ) {
				int max = Integer.MAX_VALUE;
				int min = 100;
				Long newId = (long)Math.floor(Math.random()*(max-min+1)+min);
				card.setId(newId);
				
				cards.add(card);
			} else {				
				cards.removeIf(c -> c.getId().equals(id));
				
				card.setId(id);
				cards.add(card);
			}	
			
			todoArchive.put(todoKey, cards);
						
		}
	
}
