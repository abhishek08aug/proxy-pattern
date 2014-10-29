package in.blogspot.randomcompiler.proxy.pattern.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ATMRemote extends Remote {

	public long getCash() throws RemoteException;
	
	public boolean fillCash(long cash) throws RemoteException;
	
	public void printAvailableCash() throws RemoteException;
}
