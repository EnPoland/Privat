import java.io.*;
import java.net.Socket;

/**
 * Created by списп on 04.04.2017.
 */
public class InfoHandler extends ClientHandler {

    public InfoHandler(Socket st) throws IOException {
        super(st);
    }

    OutputStream outStream = client.getOutputStream();
    PrintWriter out = new PrintWriter(outStream, true);
    InputStream inStream = client.getInputStream();
    BufferedReader inputLine = new BufferedReader(new InputStreamReader(inStream));

    public void infoDepositor() throws IOException {

        out.println("Enter name of depositor");
        String string = inputLine.readLine();{
            for (Deposit deposit:Main.linkedlist){
                String s = deposit.getDepositor();
                if(string.equals(s)){
                    out.println(deposit);
                }
            }
        }
    }

    public void infoId() throws IOException {
        out.println("Enter id");
        String id = inputLine.readLine();
        File file = new File("O:\\study\\EnPoPrivatServer\\data\\"+id+".json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            out.println(sCurrentLine);
        }
    }

}
