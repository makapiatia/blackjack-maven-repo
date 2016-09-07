package com.tj.blackjack;

/**
 * Possible card ranks represented by an enum.
 * @author Tia Jackson
 *
 */
public enum CardRank {	
	ACE(1, "Ace"),
	TWO(2, "2"), 
	THREE(3, "3"), 
	FOUR(4, "4"), 
	FIVE(5, "5"), 
	SIX(6, "6"), 
	SEVEN(7, "7"),
	EIGHT(8, "8"), 
	NINE(9, "9"), 
	TEN(10, "10"), 
	JACK(10, "Jack"), 
	QUEEN(10, "Queen"), 
	KING(10, "King");
	
	private int rankValue;
	private String rankDescription;
	
	// Create a CardRank with an a numerical value and a description
	private CardRank(int rankValue, String rankDescription){
		this.rankValue = rankValue;
		this.rankDescription = rankDescription;
	}
	
	// Get numerical rank value
	public int getRankValue(){
		return this.rankValue;
	}
	
	// Get description of the rank
	public String getRankDescription(){
		return this.rankDescription;
	}
}
