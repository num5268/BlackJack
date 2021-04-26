package com.num5268.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.num5268.blackjack.model.DeckVO;

public class BlackJack04 extends BlackJack03 {
	
	protected DeckVO deckVO;


	public BlackJack04() {
	}
	
	public DeckVO getDeck() {
		
		int nSize = deckList.size();
		int deckIndex = rnd.nextInt(nSize);
		
		DeckVO retDeckVO = deckList.get(deckIndex);
		deckList.remove(deckIndex);
		return retDeckVO;
	}
	
	public void makeDeck() {
		
		String[] denoms = strDenomi.split("");
		String[] suits = strSuit.split(":");
		
		// 4번 반복
		for(String suit : suits) {
			for(String denom : denoms) {
				Integer intValue = 0;
				
				try {
					intValue = Integer.valueOf(denom);
					if(intValue == 0) intValue = 10;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					// denom 문자열이 A,K,Q,J인경우 Ex
					if(denom.equals("A")) intValue = 0;
					else intValue = 10;
				}
				
				DeckVO deckVO = new DeckVO();
				deckVO.setSuit(suit);
				deckVO.setDenomination(denom);
				deckVO.setValue(intValue);
				deckList.add(deckVO);
				
				System.out.println(deckVO.toString());
			}
		}
	}
	protected void deckSuffle() {
		
		String strNum = deckVO.toString();
		for(int i = 0; i<1000; i++) {
			int temp;
			
			
		}
	}
	
}
