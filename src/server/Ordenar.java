package server;

import DAO.SequenciaDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Ordenar extends UnicastRemoteObject implements InterfaceOrdena{
    
	protected Ordenar() throws RemoteException {
		
	}
	
	public ArrayList<Integer> ordenarNumeros(ArrayList<Integer> numeros) throws RemoteException {
            
		System.out.println("Sequencia inserida");
		for(int i=0; i<numeros.size(); i++) {
			System.out.print(numeros.get(i) + "  ");
		}
	
                Collections.sort(numeros);
                
                String sequenciaOrdenada="";
                
                for(int i=0; i<numeros.size(); i++){
                    sequenciaOrdenada = sequenciaOrdenada + " "+ numeros.get(i);
                }
                
                SequenciaDAO sdao = new SequenciaDAO();
                sdao.add(sequenciaOrdenada);

		
		System.out.println("\nSequencia ordenada");
		for(int i=0; i<numeros.size(); i++) {
			System.out.print(numeros.get(i) + "  ");
		}
		System.out.println("\n\n");                
		
		return numeros;
	}
}