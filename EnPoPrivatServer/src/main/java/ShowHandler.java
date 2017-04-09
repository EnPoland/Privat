import java.io.*;
import java.net.Socket;

/**
 * Created by списп on 04.04.2017.
 */
public class ShowHandler extends ClientHandler {

    public ShowHandler(Socket st) {
        super(st);
    }

    public void showType() throws IOException {
        OutputStream outStream = client.getOutputStream();
        PrintWriter out = new PrintWriter(outStream, true);
        InputStream inStream = client.getInputStream();
        BufferedReader inputLine = new BufferedReader(new InputStreamReader(inStream));
        out.println("Enter type");
        String string = inputLine.readLine();
        for (Deposit deposit:Main.linkedlist){
            String s = deposit.getType();
            if (string.equals(s)){
                out.println(deposit);
            }
        }
    }

    public void showBank() throws IOException{
        OutputStream outStream = client.getOutputStream();
        PrintWriter out = new PrintWriter(outStream, true);
        InputStream inStream = client.getInputStream();
        BufferedReader inputLine = new BufferedReader(new InputStreamReader(inStream));
        out.println("Enter name of a bank");
        String string = inputLine.readLine();
        for (Deposit deposit:Main.linkedlist){
            String s = deposit.getName();
            if(string.equals(s)){
                out.println(deposit);
            }
        }
    }

}
