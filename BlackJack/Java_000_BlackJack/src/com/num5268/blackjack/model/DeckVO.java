package com.num5268.blackjack.model;

public class DeckVO {

	private String suit;
	private String denomination;
	private Integer value = 0;
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return " 모양=" + suit + ", 숫자=" + denomination + ", 값=" + value + "]";
	}
	
	
}
