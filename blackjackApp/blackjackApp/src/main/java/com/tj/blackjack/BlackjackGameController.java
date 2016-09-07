package com.tj.blackjack;

import java.util.Scanner;

/**
 * 
 * @author Tia Jackson
 *
 */
public class BlackjackGameController {
	
	public static void main(String args[]){		
		
		System.out.println("Starting Blackjack\n");
		
		//Initialize scanner
		Scanner scanner1 = new Scanner(System.in);
		String playerNewGameResponse = "";
		boolean playNewGame = true;
		
		while(playNewGame){
			System.out.println("\nWould you like to play a new game of Blackjack? (Enter Y or N):");
		
			do
			{
				playerNewGameResponse = scanner1.next().toUpperCase();
				
				if (!playerNewGameResponse.equals("Y") && !playerNewGameResponse.equals("N"))
				{
					System.out.print("Please respond with Y or N:  ");
				}
			} while (!playerNewGameResponse.equals("Y") && !playerNewGameResponse.equals("N"));

			if (playerNewGameResponse.compareToIgnoreCase("Y") == 0) {
				playNewGame(scanner1);
			} else {
				playNewGame = false;
				System.out.println("\nThanks for Playing Blackjack. Goodbye");
			}
		}
		
		if(scanner1 != null) {
		    scanner1.close();
		}
		
	}
	
	public static void playNewGame(Scanner scanner2){
		
		String playerResponse;
				
		boolean continueGame = true;
		
		// Create and shuffle a new deck of cards
		Deck deckOfCards = new Deck();
		deckOfCards.shuffleCards();		
		
		// Create a Dealer and get the dealer's hand
		boolean isDealerHand = true;
		Dealer dealer = new Dealer(isDealerHand);
		Hand dealerHand = dealer.getHand();
		
		// Create a Player and get the player's hand
		isDealerHand = false;
		Player player = new Player(isDealerHand);
		Hand playerHand = player.getHand();
		
		// Deal two cards for Dealer
		boolean showCard = false;
		System.out.println("\nDealing first two cards to dealer, face down.");
		BlackjackHelper.hitHand(dealerHand, deckOfCards, showCard);
		BlackjackHelper.hitHand(dealerHand, deckOfCards, showCard);
				
		//	Deal two cards for Player
		showCard = true;
		System.out.println("\nDealing first two cards to player face up.");
		BlackjackHelper.hitHand(playerHand, deckOfCards, showCard);
		BlackjackHelper.hitHand(playerHand, deckOfCards, showCard);
		
		// Check for BLACKJACK TIE on first two cards...
		if(BlackjackHelper.isBlackjackTie(dealerHand, playerHand)){
			
			// Tie... Neither wins on first two cards blackjack tie... Game over, but show cards
			System.out.println("Dealer and Player both have Blackjack on first two cards! : TIE");
			continueGame = false;
		}
		
		//	Check for BLACKJACK for either hand on first two cards
		if(continueGame){
			if(BlackjackHelper.isBlackjack(dealerHand)){
				
				// Dealer wins... Game over, but show cards
				System.out.println("Dealer has BLACKJACK on first two cards : Dealer WINS");
				continueGame = false;
				
			} else if(BlackjackHelper.isBlackjack(playerHand)){
				
				// Player wins... Game over, but show cards
				System.out.println("Player has BLACKJACK on first two cards : Player WINS");
				continueGame = false;
			}
		}
		
		// Game is over after first two cards, so display the dealer and player hands
		if(!continueGame){		
			dealerHand.showHand();
			dealerHand.showHandleTotal();
			playerHand.showHand();
			playerHand.showHandleTotal();
			
			// !!! EXIT GAME IF BLACKJACK, BUST OR TIE !!!
			System.out.println("\nGame Over. Thanks for Playing!");
			
		} else {
			
			// Continue playing game
			
			System.out.println("\nNo Blackjack, Bust or Tie on first two cards... Continuing Game...");
					
			// Show the Player their current hand and current total
			playerHand.showHand();
			playerHand.showHandleTotal();
				
			// Dealer shows the Player the top card in his hand and ask the Player if HIT or STAND
			dealerHand.showTopCardInHand();
				
			boolean hitPlayer = false;
			System.out.println("HIT(H) or STAND(S)? (Enter H or S):");
				
			do
			{
				playerResponse = scanner2.next().toUpperCase();
				
				if (!playerResponse.equals("H") && !playerResponse.equals("S"))
				{
					System.out.print("Please respond with H or S:  ");
				}
			} while (!playerResponse.equals("H") && !playerResponse.equals("S"));
				
			if (playerResponse.compareToIgnoreCase("H") == 0) {
				hitPlayer = true;
				System.out.println("HIT Player" );
			} else {
				hitPlayer = false;
				System.out.println("Player STANDS" );
			}
				
			// Player hits until they have blackjack, bust or they stand
			while(hitPlayer){
				BlackjackHelper.hitHand(playerHand, deckOfCards, showCard);
					
				playerHand.showHand();
				playerHand.showHandleTotal();
					
				if(BlackjackHelper.isBlackjack(playerHand)){
					hitPlayer = false;
					System.out.println("Player has BLACKJACK! - Going to STAND");

				} else if(BlackjackHelper.isBust(playerHand)){
					hitPlayer = false;
					System.out.println("Player is BUST! - Going to STAND");

				}
					
				if(hitPlayer){
					System.out.println("HIT(H) or STAND(S)? (Enter H or S):");
						
					do
					{
						playerResponse = scanner2.next().toUpperCase();
							
						if (!playerResponse.equals("H") && !playerResponse.equals("S"))
						{
							System.out.print("Please respond with H or S:  ");
						}
					} while (!playerResponse.equals("H") && !playerResponse.equals("S"));
						
					if (playerResponse.compareToIgnoreCase("H") == 0) {
						System.out.println("HIT Player" );
					} else {
						hitPlayer = false;
						System.out.println("Player STANDS" );
					}
				}
			}
						
			//	Dealer shows their two initial cards
			dealerHand.showHandleTotal();
			dealerHand.showHand();			
		
			boolean hitDealer = false;			

			if(dealerHand.getHandTotal() < Constants.DEALER_STAND_NUMBER){
				hitDealer = true;
			}
				
			// Dealer hits until they bust or or go over 17
			while(hitDealer){
				BlackjackHelper.hitHand(dealerHand, deckOfCards, showCard);

				dealerHand.showHand();
				dealerHand.showHandleTotal();
					
				if(BlackjackHelper.isBust(dealerHand)){
					hitDealer = false;
					System.out.println("Dealer is BUST! - Going to STAND");
					continueGame = false;
				}
					
				if(dealerHand.getHandTotal() >= Constants.DEALER_STAND_NUMBER){
					hitDealer = false;
				}
			}

			// Check hands to determine winner
			BlackjackHelper.compareFinalHands(dealerHand, playerHand);
			
			System.out.println("\nGame Over. Thanks for Playing!");
		}
	}
}
