package in.blogspot.randomcompiler.proxy.pattern.impl;

import java.rmi.RemoteException;

import in.blogspot.randomcompiler.proxy.pattern.api.ATMState;

public class WithdrawCashState extends ATMState {
	public WithdrawCashState(ATM atm) {
		this.atm = atm;
	}
	
	@Override
	public boolean ejectCard() {
		System.out.println("Card ejected");
		return true;
	}
	
	@Override
	public boolean withdrawCash() {
		System.out.println("Cash withdrawn: " + atm.getAmount());
		try {
			atm.setCash(atm.getCash() - atm.getAmount());
			atm.setAmount(0);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
