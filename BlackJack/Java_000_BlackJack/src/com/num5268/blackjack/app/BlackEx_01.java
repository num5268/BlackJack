package com.num5268.blackjack.app;

import com.num5268.blackjack.service.BlackJack06;

public class BlackEx_01 {
	
	public static void main(String[] args) {
		
		BlackJack06 bl = new BlackJack06();
		
		bl.createDeck();
		bl.mixDeck();
		
		bl.getp1Deck();
		bl.getd1Deck();
		
	}

}
