import java.io.*;
import java.net.Socket;

/**
 * Created by списп on 31.03.2017.
 */
public class ClientHandler implements Runnable  {



    public ClientHandler(Socket st) {
        client = st;
    }
    public void run() {
        while (true){
        try {
                ShowHandler showHandler = new ShowHandler(client);
                InfoHandler infoHandler = new InfoHandler(client);
                InputStream inStream = client.getInputStream();
                BufferedReader inputLine = new BufferedReader(new InputStreamReader(inStream));
                String stringFromClient = inputLine.readLine(); //Строка, полученная от клиента
                System.out.println(stringFromClient);
                OutputStream outStream = client.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true);

                if(stringFromClient.equals("add")){
                    AddHandler addHandler = new AddHandler(client);
                    addHandler.add();
                }else if(stringFromClient.equals("delete"))
                {
                    out.println("Enter id");
                    String id = inputLine.readLine();
                    File file = new File("O:\\study\\EnPoPrivatServer\\data\\"+id+".json");
                    if(file.delete()){
                        out.println("DONE");
                    }else out.println("Deposit with this id doesn't exist");

                } else if(stringFromClient.equals("list"))
                {
                    for(Object string: Main.linkedlist) {
                      out.println("LIST");
                      out.println(Main.linkedlist);
                    }
                }
                else if(stringFromClient.equals("sum")){
                    Double sum = new Double(0);
                    for(int i = 0; i<Main.ammount.size();i++){
                     sum += (Double) Main.ammount.get(i);
                    }
                    out.println(sum);
                }else if(stringFromClient.equals("count"))
                {
                    out.println(Main.getCount());
                } else if(stringFromClient.equals(" info depositor")){
                    infoHandler.infoDepositor();
                }
                else if(stringFromClient.equals("info account")){
                    infoHandler.infoId();
                }else if(stringFromClient.equals("show bank")){
                    showHandler.showBank();
                }else if (stringFromClient.equals("show type")){
                    showHandler.showType();
                } else out.println("ENTER RIGHT COMMAND");
        }catch (IOException e){e.printStackTrace();}
        }
    }




    protected Socket client;
}
