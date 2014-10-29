package in.blogspot.randomcompiler.proxy.pattern.api;

import in.blogspot.randomcompiler.proxy.pattern.impl.ATM;

public abstract class ATMState {
	protected ATM atm;
	protected int pin;
	
	public boolean insertCard() {
		System.out.println("There should not be a card already inserted");
		return false;
	}
	
	public boolean ejectCard() {
		System.out.println("You have to insert a card first");
		return false;
	}
	
	public boolean enterPin(int pin) {
		System.out.println("Insert the card first");
		return false;
	}
	
	public boolean enterAmount(int amount) {
		System.out.println("First enter a valid PIN");
		return false;
	}
	
	public boolean withdrawCash() {
		System.out.println("First enter a valid PIN and amount");
		return false;
	}
	
	public boolean fillCash(long cash) {
		System.out.println("Cash could not be filled while the ATM is being used");
		return false;
	}
}
