package in.blogspot.randomcompiler.proxy.pattern.demo;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import in.blogspot.randomcompiler.proxy.pattern.impl.ATM;

public class ATMTestDrive {
	
	private static Registry registry;
	
	static {
		try {
			registry = LocateRegistry.createRegistry(8092);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ATM atm = null;
		
		try {
			atm = new ATM(100000L);
			Naming.rebind("rmi://localhost:8092/RemoteATM", atm);
			System.out.println("ATM Installed");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
