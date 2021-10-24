package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GameImpl extends UnicastRemoteObject implements IGameRemote {

    private int secretNumber;
    private boolean end;

    public GameImpl() throws RemoteException {
        super();
        generateSecret();
    }

    @Override
    public String startGame(int number) throws RemoteException {
        if (end == false){
            if (number > secretNumber) return "Your number is bigger than the secret number";
            else if (number < secretNumber) return "Your number is smaller than the secret number";
            else {
                end = true;
                return "Congraaaats! You made it into the secret number";
            }
        }
        else {
            return "Game finished! the secret number is "+secretNumber;
        }
    }

    private void generateSecret(){
        secretNumber = (int) (Math.random()*1000);
    }

    public int getSecretNumber(){
        return secretNumber;
    }
}
