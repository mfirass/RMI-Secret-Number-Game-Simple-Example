import rmi.IGameRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            IGameRemote stub = (IGameRemote) ctx.lookup("RMIGame");
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("Guess:");
                int nb = scanner.nextInt();
                if (nb == -1) break;
                String response = stub.startGame(nb);
                System.out.println(response);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
