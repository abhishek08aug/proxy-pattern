package in.blogspot.randomcompiler.proxy.pattern.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import in.blogspot.randomcompiler.proxy.pattern.api.ATMRemote;
import in.blogspot.randomcompiler.proxy.pattern.api.ATMState;

public class ATM extends UnicastRemoteObject implements ATMRemote {

	private NoCardInsertedState noCardInsertedState;
	private CardInsertedState cardInsertedState;
	private ValidPinState validPinState;
	private InvalidPinState invalidPinState;
	private InvalidAmountState invalidAmountState;
	private WithdrawCashState withdrawCashState;
	private OutOfCashState outOfCashState;
	
	private long cash;
	private long maxCashLimit;	
	private ATMState currentState;
	private int amount;
	
	public ATM(long maxCashLimit) throws RemoteException {
		noCardInsertedState = new NoCardInsertedState(this);
		cardInsertedState = new CardInsertedState(this);
		validPinState = new ValidPinState(this);
		invalidPinState = new InvalidPinState(this);
		invalidAmountState = new InvalidAmountState(this);
		withdrawCashState = new WithdrawCashState(this);
		outOfCashState = new OutOfCashState(this);
		
		cash = 0;
		amount = 0;
		this.maxCashLimit = maxCashLimit;
		currentState = outOfCashState;
	}
	
	public void setState(ATMState state) {
		currentState = state;
	}
	
	public void printAvailableCash() throws RemoteException {
		System.out.println("Cash in ATM: " + cash);
	}
	
	public long getCash() throws RemoteException {
		return cash;
	}
	
	public void setCash(long cash) {
		if(cash > maxCashLimit) {
			System.out.println("Sorry! This ATM can only hold maximum cash of: " + maxCashLimit);
		}
		this.cash = cash;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getMaxCashLimit() {
		return maxCashLimit;
	}

	public boolean insertCard() {
		if(currentState.insertCard()) {
			currentState = cardInsertedState;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean ejectCard() {
		if(currentState.ejectCard()) {
			currentState = noCardInsertedState;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean enterPin(int pin) {
		if(currentState.enterPin(pin)) {
			currentState = validPinState;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean enterAmount(int amount) {
		if(currentState.enterAmount(amount)) {
			currentState = withdrawCashState;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean withdrawCash() {
		if(currentState.withdrawCash()) {
			currentState = cardInsertedState;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean fillCash(long cash) throws RemoteException {
		if(currentState.fillCash(cash)) {
			currentState = noCardInsertedState;
			return true;
		} else {
			return false;
		}
	}
}
