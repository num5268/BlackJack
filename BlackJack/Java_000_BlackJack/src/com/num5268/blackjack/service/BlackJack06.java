package com.num5268.blackjack.service;

import java.util.Random;
import java.util.Scanner;

public class BlackJack06 {

	protected int p1Deck[];
	protected int p1Index;
	protected int d1Deck[];
	protected int d1Index;
	
	protected int[] deck;
	protected int deckIndex;
	protected Random rnd;
	protected Scanner scan;
	
	public BlackJack06() {
		
		p1Deck = new int[10];
		d1Deck = new int[10];
		deck = new int[52];
		deckIndex = 0;
		rnd = new Random();
		scan = new Scanner(System.in);
	}
	
	public void createDeck() { // 1.카드생성 함수
		for (int i = 0; i < 52; i++) {
			deck[i] = i;
		}
	}
	
	public void mixDeck() { // 2.카드섞기 함수
		Random rd = new Random();
		int rndNum;
		int temp;
		for (int i = 0; i < 10000; i++) {
			rndNum = rd.nextInt(52);
			temp = deck[0];
			deck[0] = deck[rndNum];
			deck[rndNum] = temp;
		}
	}
	public void deckDisplay(int deck[], int index, String title) {
		String cardShape[] = { "스페이스", "클로버", "다이아", "하트" };
		String cardNumber[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		System.out.print(title);
		for (int i = 0; i < p1Index; i++) {
			int cardSIndex = deck[i] / cardNumber.length; // 카드 모양(cardShape) 종류 '0:스페이스/1:클로버/2:다이아/3:하트' 총 0~3의 값
			System.out.print(cardShape[cardSIndex]);
			int cardNIndex = deck[i] % cardNumber.length; // 카드 숫자(cardNumber) 종류 총 0~12의 값
			System.out.print(cardNumber[cardNIndex] + " , ");
		}
		System.out.println();
	}

	
	public void getp1Deck() {
		while(true) {
			
			System.out.println("카드를 받겠습니까? [0=NO 1=YES]");
			Integer intP1 = scan.nextInt();
			if (intP1 == 0) { // 카드를 받지 않는 작업
				
			}
			if (intP1 == 1) { // 카드를 받는 작업
				p1Deck[p1Index] = deck[deckIndex];
				deckIndex++;
				p1Index++;
			}
			this.getd1Deck();
		}
			
		}
	public void getd1Deck() {
		System.out.println("카드를 받겠습니까? [0=NO 1=YES]");
		Integer intd1 = scan.nextInt();
		if (intd1 == 0) { // 카드를 받지 않는 작업
			
		}
		if (intd1 == 1) { // 카드를 받는 작업
			d1Deck[d1Index] = deck[deckIndex];
			deckIndex++;
			d1Index++;
		}
		this.gameDisplay();
	}
	public int getSum(int[] deck, int index) { // 점수 구하기 메소드
		int sum = 0;
		for (int i = 0; i < index; i++) { // A=1 J,Q,K=10으로 점수처리 한것
			int score = 0;
			score = deck[i] % 13 + 1;
			if (score > 10) {
				score = 10;
			}
			sum = sum + score;
		}
		for (int i = 0; i < index; i++) {
			if (deck[i] % 13 == 0) {
				if (sum + 10 <= 21) {
					sum = sum + 10;
				}
			}
		}
		return sum;
	}
	public void gameDisplay() { // 분배 화면 메소드
			System.out.println("");
			System.out.println(">>카드 현황");
			deckDisplay(p1Deck, p1Index, "p1: ");
			System.out.println("player 총점> " + getSum(p1Deck, p1Index));
			if( getSum(p1Deck, p1Index) >21) {
				whoIsWin();
			}
			deckDisplay(d1Deck, d1Index, "d2: ");
			System.out.println("dealer 총점> " + getSum(d1Deck, d1Index));
			System.out.println("");
			
	}
	public String whoIsWin() { // 승패 메소드
		int player = getSum(p1Deck, p1Index);
		int dealer = getSum(d1Deck, d1Index);
		String playState = "";
		if (player > 21) { // 먼저 카드를 받은 p1이 진다
			playState = "dealer 승리!!!";
		} else if (dealer > 21) {
			playState = "player 승리!!!";
		} else if (player > dealer) {
			playState = "player 승리!!!";
		} else if (player == dealer) {
			playState = "무승부!!!";
		} else {
			playState = "dealer 승리!!!";
		}
		return playState;
	}
}
