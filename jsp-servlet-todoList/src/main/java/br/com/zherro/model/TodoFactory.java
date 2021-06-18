package br.com.zherro.model;

import java.util.List;
import java.util.Optional;

import br.com.zherro.domain.Card;

import java.util.ArrayList;

public class TodoFactory {
	
		public static final List<Card> cards = new ArrayList<>();
		
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
			
			cards.add(card);
			cards.add(card);
			cards.add(card1);
		}

		public static List<Card> listCards( ) {
			if(cards.size() <= 0) {
				
			}
			return cards;
		}

		public static void createCards() {
			initList();
		}
		
		public static Card getById(Long id) {
			Optional<Card> card =  cards.stream()
										.filter( c -> c.getId().equals(id) )
										.findFirst();
			return card.orElse(null);
		}

		public static void addCard(Card card, final Long id) {
			
			
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
			
						
		}
	
}
