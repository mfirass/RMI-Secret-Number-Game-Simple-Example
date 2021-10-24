import rmi.GameImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            GameImpl od = new GameImpl();
            System.out.println(od.toString());
            System.out.println(od.getSecretNumber());
            //Naming.rebind("rmi://localhost:1099/RMIGame", od);
            Context ctx = new InitialContext();
            ctx.rebind("RMIGame", od);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
