/*
 * 1. 딜러와 게이머 단 2명만 있다. 
 * 
 * 2. 카드는 조커를 제외한 52장이다 카드는 
 * 		다이아몬드, 하트, 스페이드, 클럽 무늬를 가진 A,
 * 		2~10, K(킹), Q(퀸), J(잭) 으로 이루어져 있다. 
 * 
 * 3. A는 1점, 2~10은 숫자 그대로 점수를, K/Q/J는 10점으로
 * 		계산한다. (블랙잭 규칙은 A는 1과 11 둘다 가능하지만 
 * 			여기선 1만 허용하도록 한다.) 
 * 
 * 4. 딜러와 게이머는 순차적으로 카드를 하나씩
 * 		뽑아 각자 2개의 카드를 소지한다. 
 * 		게이머는 얼마든지 카드를 추가로 뽑을 수 있다. 
 * 
 * 5. 딜러는 2카드의 합계 점수가 16점 이하이면
 * 		반드시 1장을 추가로 뽑고, 17점 이상이면 추가할 수 없다. 
 * 
 * 6. 양쪽 모두 추가 뽑기 없이, 
 * 		카드를 오픈하면 딜러와 게이머 중 소유한
 * 		카드의 합이 21에 가장 가까운 쪽이 승리한다. 
 * 
 * 7. 21을 초과하면 무조건 초과한 쪽이 게임에서 진다. 
 * 
 * 8. 코드는 JAVA의 기본
 * 		JDK와 외부 LIB를 참조 할 수 있다. 
 * 
 * 9. 모든 게임은 콘솔을 통해서 진행된다. (키보드와 콘솔 출력을 구현)
 */
package com.num5268.blackjack.service;

import java.util.Random;
import java.util.Scanner;

public class BlackJack02 {
	
	protected Scanner scan;
	protected Random rnd;
	protected int[] deck;
	public BlackJack02() {
		
		scan = new Scanner(System.in);
		rnd = new Random();
	}
	
	public void cardsuffle() {
		deck = new int[52];
		String[] cardShape = {"스페이스","클로바","다이아","하트"};// 모양을 배열로 선언
		String[] cardNumber = {"A","2","3","4","5","6","7","8","9","10","J","Q","K",}; //A ~ K까지 배열 선언
		
		for (int i =0; i<52 ; i++) { // DECK 선언
			deck[i] = i;
		}
		for(int i = 0; i< 1000; i++) { // SUFFLE
			int rndNum = rnd.nextInt(52);
			int temp = deck[0];
			deck[0] = deck[rndNum];
			deck[rndNum] = temp;
			System.out.println(temp);
		}
	}
	
	public void player() { // 플
		int deckIndex = 0;
		int pDeck[] = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }; 
		int dDeck[] = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int userAIndex = 0;
		int userBIndex = 0;
		boolean userAFlag = true;
		boolean userBFlag = true;
		int ScoreASum = 0;
		int ScoreBSum = 0;

		while(true) {
			System.out.println("playA님 카드를 받으시겠습니까? Yes-1/No-0");
			System.out.print(">>");
			Integer userA = scan.nextInt();
			if(userA == 0) {
				System.out.println("h");
				
				
			}
		}
	}
	
}
