package in.blogspot.randomcompiler.proxy.pattern.demo;

import in.blogspot.randomcompiler.proxy.pattern.api.ATMRemote;
import in.blogspot.randomcompiler.proxy.pattern.impl.RemoteCashFiller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RemoteCashFillerTestDrive {

	public static void main(String[] args) {
		RemoteCashFiller filler = null;
		try {
			filler = new RemoteCashFiller((ATMRemote)Naming.lookup("rmi://localhost:8092/RemoteATM"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		filler.printAvailableCash();
		System.out.println("Filling cash in ATM");
		filler.checkAndFillCash();
		filler.printAvailableCash();
	}
}
