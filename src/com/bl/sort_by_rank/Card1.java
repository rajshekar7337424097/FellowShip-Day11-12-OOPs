package com.bl.sort_by_rank;

import java.security.DomainCombiner;

public class Card1 {
	public int suit, rank;
	
	public Card1() {
		this.suit = 0;
		this.rank = 0;
	}

	public Card1(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public static void printCard(Card1 c) {
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		
		System.out.println(ranks[c.rank] + "of"+suits[c.suit]);
	}
	
	public static void printDeck(Card1[] deck) {
		for (int i = 0; i < deck.length; i++) {
			printCard(deck[i]);
		}
	}
	
	public static int compareCards(Card1 c1, Card1 c2) {
		 
		int rank1 = (c1.rank + 11) % 13;
		int rank2 = (c2.rank + 11) % 13;
		
		if(rank1 > rank2) {
			return 1;
		}
		if (rank1 < rank2) {
			return -1;
		}
		
		if(c1.suit > c2.suit) {
			return 1;
		}
		if (c1.suit < c2.suit) {
			return -1;
		}
		return 0;	
	}
	
	public boolean sameCard(Card1 c1, Card1 c2) {
		return (c1.suit == c2.suit && c1.rank == c2.rank);
	}
	
	public static int findCard(Card1[] deck, Card1 card) {
		for (int i = 0; i < deck.length; i++) {
			if(deck[i].equals(card)) 
				return i;
		}
		return -1;
	}
	
		public static int findBisect(Card1[] deck, Card1 card, int low, int high) {
			System.out.println(low+""+high);
			
			if(high < low) {
				return -1;
			}
			 int mid = (high + low) / 2;
			 int comp = compareCards(card, deck[mid]);
			 
			 if (comp == 0) {
				 return mid;
			 }else if (comp < 0) {
				 return findBisect(deck, card, low, mid - 1);
			 } else {
				 return findBisect(deck, card, mid + 1, high);
			 }
		}
		
		public static Card1[] buildDeck() {
			Card1[] deck = new Card1[52];
			
			int index = 0;
			for (int suit = 0; suit <= 3; suit++) {
				for (int rank = 0; rank <= 13; rank++) {
					deck[index] = new Card1(suit, rank);
					index++;
				}
			}
			return deck;
		}
		
		public static void shuffleDeck(Card1[] deck) {
			for (int i = 0; i < deck.length; i++) {
				int j = randInt(i, deck.length - 1);
				swapCards(deck, i, j);
			}
		}

		private static void swapCards(Card1[] deck, int i, int j) {
			Card1 temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
			
		}

		private static int randInt(int low, int high) {
			while(true) {
				int x = (int)(Math.random() * (high - low + 1) + low);
				if(x >= low && x <= high) 
					return x;
				
			}
		}
		
		public static void sortDeck(Card1[] deck) {
			for (int i = 0; i < deck.length; i++) {
				int j = findLowestCard(deck, i, deck.length - 1);
				swapCards(deck, i, j);
			}
		}

		private static int findLowestCard(Card1[] deck, int low, int high) {
			int winner = low;
			for (int i = low + 1; i <= high; i++) {
				if(compareCards(deck[i], deck[winner]) < 0) {
					winner = i;
				}
				
			}
			return winner;
		}
		
		public static Card1[] subdeck(Card1[] deck, int low, int high) {
			Card1[] sub = new Card1[high - low +1];
			
			for (int i = 0; i < sub.length; i++) {
				sub[i] = deck[low + i];
			}
			return sub;
		}
		
		public static void main(String[] args) {
			Card1[] deck = buildDeck();
			sortDeck(deck);
			printDeck(deck);
			
			Card1 card1 = new Card1(2, 11);
			Card1 card2 = new Card1(1,1);
			
			System.out.println(findBisect(deck, deck[37], 0, 51));
			
			Card1[] hand = subdeck(deck, 4, 7);
			printDeck(hand);
		}
	

}
