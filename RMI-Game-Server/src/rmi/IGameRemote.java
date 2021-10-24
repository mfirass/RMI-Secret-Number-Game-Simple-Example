package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGameRemote extends Remote {
    public String startGame(int number) throws RemoteException;
}
