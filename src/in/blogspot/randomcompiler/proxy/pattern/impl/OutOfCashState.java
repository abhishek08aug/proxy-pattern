package in.blogspot.randomcompiler.proxy.pattern.impl;

import java.rmi.RemoteException;

import in.blogspot.randomcompiler.proxy.pattern.api.ATMState;

public class OutOfCashState extends ATMState {

	public OutOfCashState(ATM atm) {
		this.atm = atm;
	}
	
	@Override
	public boolean fillCash(long cash) {
		try {
			if(atm.getCash() + cash <= atm.getMaxCashLimit()) {
				System.out.println("ATM is filled with cash successfully");
				atm.setCash(atm.getCash() + cash);
				return true;
			} else {
				return false;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
