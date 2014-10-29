package in.blogspot.randomcompiler.proxy.pattern.impl;

import java.rmi.RemoteException;

import in.blogspot.randomcompiler.proxy.pattern.api.ATMRemote;

public class RemoteCashFiller {
	ATMRemote atmRemote;
	
	public RemoteCashFiller(ATMRemote atmRemote) {
		this.atmRemote = atmRemote;
	}
	
	public void checkAndFillCash() {
		try {
			if(atmRemote.getCash() < 10000) {
				atmRemote.fillCash(90000L);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void printAvailableCash() {
		try {
			atmRemote.printAvailableCash();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
