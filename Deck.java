// package com.codingdojo.cardgame;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards;
	private int size;
	    public Deck() {
	        this.cards = new ArrayList<Card>();
	
	        // Populate the cards list -- loop to 52
	        for (String name : new String[] {"Hearts", "Clubs", "Diamonds", "Spades"}) {
	            for (Integer rank = 1; rank <= 13; rank++) {
	            	
	                this.cards.add(new Card(name, rank));
	            }
	        }
	        this.size=52;
	    }
	
		public ArrayList<Card> getCards() {
			return cards;
		}
	
		public void setCards(ArrayList<Card> cards) {
			this.cards = cards;
		}
		public int getSize() {
			return this.size;
		}
		
		public boolean compareTwoCards(Card card1,Card card2) {
	    	 String[]array = new String[]{"Spades", "Hearts", "Dimonds", "Clubs"};
	    	 System.out.println("rank1: "+ card1.getRank());
	    	 System.out.println("rank2: " +card2.getRank());
	    	 if ( card1.getRank() < card2.getRank()) {  
	    		 return false;     
	    		 
	    	 } else if (card1.getRank() == card2.getRank()){ 
	    		 for (int i = 0; i < array.length; i++) {
	    			 if (card1.getSuit() == array[i]) {
	    				 return true;
	    			 }
	    			 if (card2.getSuit() == array[i]) {
	    				 return false;
	    			 }
	    		 }
	    	 }
	    	 return true;
	    	
	    }
		
		public ArrayList <Card> updateDeck(String named, int ranked){
			{

		        
		        ArrayList<Card>temp=new ArrayList<Card>();
		        
	       
//		        System.out.println("named: "+ named + " ranked "+ ranked);
		        
		        for(int i=0; i<this.cards.size(); i++) {
		        	if (this.cards.get(i).getSuit()==named && this.cards.get(i).getRank()==ranked) {
	                	continue;
	                }else {
	                	temp.add(new Card(this.cards.get(i).getSuit(), this.cards.get(i).getRank())); // exclude the one we wants to remove
	                }
		        	
	
		        }

		        this.cards = new ArrayList<Card>(temp); // clone this.cards (AKA this deck) to the temp card deck

	        
		        //keep updating the size of the deck of card
		        this.size--;
		        return this.cards;
			}
	}
			
}	
