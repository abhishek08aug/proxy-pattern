package in.blogspot.randomcompiler.proxy.pattern.impl;

import java.rmi.RemoteException;

import in.blogspot.randomcompiler.proxy.pattern.api.ATMState;

public class InvalidAmountState extends ATMState {

	public InvalidAmountState(ATM atm) {
		this.atm = atm;
	}
	
	@Override
	public boolean ejectCard() {
		System.out.println("Card ejected");
		return true;
	}
	
	@Override
	public boolean enterAmount(int amount) {
		try {
			if(amount != 0 && amount%100 == 0 && atm.getCash() >= amount) {
				System.out.println("Valid amount");
				atm.setAmount(amount);
				return true;
			} else {
				System.out.println("Invalid amount");
				atm.setAmount(0);
				return false;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
