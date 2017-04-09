import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by списп on 31.03.2017.
 */
public class Server  {
    public Server() {

        try {
            ServerSocket server = null;
            client = null;
            try {
                server = new ServerSocket(3456);
                System.out.println("Waiting...");
                numberOfOnline = 0;

                while(true) {
                    client = server.accept();
                    numberOfOnline++;
                    System.out.println("One more client has been connected");
                    System.out.println("There are " + Server.numberOfOnline + " clients online");
                    Runnable r = new ClientHandler(client);
                    Thread t = new Thread(r);
                    t.start();
                }
            }
            finally {
                client.close();
                server.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Socket client;
    static int numberOfOnline;
}
