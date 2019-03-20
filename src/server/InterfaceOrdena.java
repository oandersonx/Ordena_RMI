package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceOrdena extends Remote {
    
	ArrayList<Integer> ordenarNumeros(ArrayList<Integer> arrays) throws RemoteException;
        
}
