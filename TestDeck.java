// package com.codingdojo.cardgame;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TestDeck {
	public static void main(String[] args) throws IOException {
			
//			Deck myDeck = new Deck();
//			for (Card card: myDeck.getCards()) {
//				card.showCard();
//			}
			
			game();
			
	}
	public static void game() throws IOException {
		
		Random rand=new Random();
		int randPlayer=0, randAuto=0;
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		boolean isWinner=false;
		Deck myDeck = new Deck(); // create a whole new deck 
		
		
		// GAME START====================
		
		System.out.println("======== Welcome To <GUESS WHO IS BIGGER> Game World ========");
	
		// Prompts player to enter name \\ 
		System.out.print("Please enter your name for game: ");
		String name = reader.readLine();
		String answer = "Y";
		int pScore=0;
		
		
		while(!answer.equals("N") && myDeck.getSize()>1){
			
			System.out.println("\nWelcome," +name + "! Today your opponent is Computer");
			System.out.println("Remaining Deck Size: "+ myDeck.getSize());
			randPlayer=rand.nextInt(myDeck.getSize()+1)+1;
			randAuto=rand.nextInt(myDeck.getSize()+1)+1;
			while(randAuto==randPlayer) {
				randAuto=rand.nextInt(myDeck.getSize()+1)+1;
			}
			System.out.println("\n	Current Score: "+ pScore);
			System.out.println("\n	Here is your card: \n");
			System.out.print("               ");
			Card playerC =myDeck.getCards().get(randPlayer);
			myDeck.getCards().get(randPlayer).showCard();
			System.out.println("\n\n");
			
			System.out.println("      Opponent is ready!\n");
			Card opponentC=myDeck.getCards().get(randAuto);

			
//			myDeck.getCards().get(randPlayer).showCard();
			isWinner=myDeck.compareTwoCards(playerC, opponentC);
//			System.out.println("w: " + isWinner);
			System.out.print("   (Rank > Suit) \n");
			System.out.print("   ( Spades > Hearts > Diamonds > Clubs ) \n");
			System.out.print("   Please enter a guess if your card are higher or lower than opponent (higher or lower): ");
			
			String isHigher = reader.readLine(); //readLine() return String
//			myDeck.getCards().get(randAuto).showCard();
			
			
			if(isHigher.equals("higher")) {
				System.out.println("w: " + isWinner);
				if(isWinner==true) {
					System.out.print("\nYou Guess Correct! You win\n");
					pScore++;
					
				}else {
					System.out.println("\nYou Guess Wrong. You lose");
					
				}
				
			}else if(isHigher.equals("lower")){
				if(isWinner) {
					System.out.println("\nYou Guess Wrong. You lose");
					
				}else {
					System.out.println("\nYou Guess Correct! You win");
					pScore++;
				}
			}else {
				System.out.println("invalid input. ");
			}
			
			System.out.print("Opponent's card is ");
			myDeck.getCards().get(randAuto).showCard();
			
			myDeck.updateDeck(myDeck.getCards().get(randAuto).getSuit(), myDeck.getCards().get(randAuto).getRank());
			myDeck.updateDeck(myDeck.getCards().get(randPlayer).getSuit(), myDeck.getCards().get(randPlayer).getRank());
			
			System.out.print("\nDo you wish to continue to play the game? (Y or N): ");
			answer = reader.readLine();
		}
		System.out.println("Thank you for playing! \n The End..........");
	}
}
