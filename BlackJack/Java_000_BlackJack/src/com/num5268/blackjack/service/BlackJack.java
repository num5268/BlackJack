package com.num5268.blackjack.service;

import java.util.Random;
import java.util.Scanner;

public class BlackJack {

	public static int deck[] = new int[52];
	public static int deckIndex = 0; // 사용자가 앞으로 사용할 카드 인덱스

	public static String whoIsWin() { // 승패 메소드
		int p1 = getSum(p1Deck, p1Index);
		int p2 = getSum(p2Deck, p2Index);
		String playState = "";
		if (p1 > 21) { // 먼저 카드를 받은 p1이 진다
			playState = "p2 승리!!!";
		} else if (p2 > 21) {
			playState = "p1 승리!!!";
		} else if (p1 > p2) {
			playState = "p1 승리!!!";
		} else if (p1 == p2) {
			playState = "무승부!!!";
		} else {
			playState = "p2 승리!!!";
		}
		return playState;
	}

	public static void gameDisplay() { // 분배 화면 메소드
		System.out.println("");
		System.out.println(">>카드 현황");
		deckDisplay(p1Deck, p1Index, "p1: ");
		System.out.println("p1 총점> " + getSum(p1Deck, p1Index));
		deckDisplay(p2Deck, p2Index, "p2: ");
		System.out.println("p2 총점> " + getSum(p2Deck, p2Index));
		System.out.println("");
	}

	public static int getSum(int[] deck, int index) { // 점수 구하기 메소드
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

	public static void deckDisplay(int deck[], int index, String title) {
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

	public static void deckDisplay(int deck[], int index) {
		String cardShape[] = { "스페이스", "클로버", "다이아", "하트" };
		String cardNumber[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		for (int i = 0; i < p1Index; i++) {
			int cardSIndex = deck[i] / cardNumber.length; // 카드 모양(cardShape) 종류 '0:스페이스/1:클로버/2:다이아/3:하트' 총 0~3의 값
			System.out.print(cardShape[cardSIndex]);
			int cardNIndex = deck[i] % cardNumber.length; // 카드 숫자(cardNumber) 종류 총 0~12의 값
			System.out.print(cardNumber[cardNIndex] + " , ");
		}
	}

	public static void deckDisplay() {
		String cardShape[] = { "스페이스", "클로버", "다이아", "하트" };
		String cardNumber[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		System.out.print("p1:");
		for (int i = 0; i < p1Index; i++) {
			int cardSIndex = p1Deck[i] / cardNumber.length; // 카드 모양(cardShape) 종류 '0:스페이스/1:클로버/2:다이아/3:하트' 총 0~3의 값
			System.out.print(cardShape[cardSIndex]);
			int cardNIndex = p1Deck[i] % cardNumber.length; // 카드 숫자(cardNumber) 종류 총 0~12의 값
			System.out.print(cardNumber[cardNIndex] + " , ");
		}
	}

	public static int p1Deck[] = new int[10]; // p1의 카드 목록
	public static int p1Index; // p1 카드 목록의 인덱스
	public static boolean p1Flag = true; // 사용자가 카드를 받을것인지 결정하는 플래그

	public static Scanner sc = new Scanner(System.in);

	public static void getp1Deck() {
		if (p1Flag) {
			System.out.println("카드를 받겠습니까? [0=NO 1=YES]");
			if (sc.nextLine().equals("0")) { // 카드를 받지 않는 작업
				p1Flag = false;
			}
			if (p1Flag) { // 카드를 받는 작업
				p1Deck[p1Index] = deck[deckIndex];
				deckIndex++;
				p1Index++;
			}
		}
	}

	// p2
	public static int p2Deck[] = new int[10]; // p2의 카드 목록
	public static int p2Index; // p2 카드 목록의 인덱스
	public static boolean p2Flag = true; // 사용자가 카드를 받을것인지 결정하는 플래그

	public static void getp2Deck() {
		if (p2Flag) {
			System.out.println("카드를 받겠습니까? [0=NO 1=YES]");
			if (sc.nextLine().equals("0")) { // 카드를 받지 않는 작업
				p2Flag = false;
			}
			if (p2Flag) { // 카드를 받는 작업
				p2Deck[p2Index] = deck[deckIndex];
				deckIndex++;
				p2Index++;
			}
		}
	}

	public static void mixDeck() { // 2.카드섞기 함수
		Random rd = new Random();
		int randNum;
		int temp;
		for (int i = 0; i < 10000; i++) {
			randNum = rd.nextInt(52);
			temp = deck[0];
			deck[0] = deck[randNum];
			deck[randNum] = temp;
		}
	}

	public static void createDeck() { // 1.카드생성 함수
		for (int i = 0; i < 52; i++) {
			deck[i] = i;
		}
	}

	public static void main(String[] args) {
	 
	        createDeck();
	        mixDeck();
	        for (int i = 0; i < 3; i++) {
	            getp1Deck();
	            getp2Deck();
	            gameDisplay();
	        }
	        System.out.println("★★★★★");
	        System.out.println(whoIsWin());

	}
}
