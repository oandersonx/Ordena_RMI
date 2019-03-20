package server;

import java.rmi.RemoteException;

public class ServidorMain {
	public static void main(String[] args) {
            
		String ip = "192.168.43.231", name = "SD";
		try {
			Ordenar ordena = new Ordenar();
			Server servidor = new Server(ordena, ip, name);
		} catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (InstantiationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
                
                
	}
}
