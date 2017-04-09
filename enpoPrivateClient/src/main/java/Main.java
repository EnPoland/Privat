import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        try {
            Socket client = new Socket("localhost", 3456);
            try {

                OutputStream outStream = client.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true);
                System.out.print("Type in smth: ");
                System.out.println("list,sum,count,info account,info depositor,show type,show bank,add,delete");
                while (true){

                    Scanner in = new Scanner(System.in);
                    String theString = in.nextLine();
                    out.println(theString);
                    InputStream inStream = client.getInputStream();
                    BufferedReader inputLine = new BufferedReader(new InputStreamReader(inStream));
                    String c = inputLine.readLine();
                    System.out.println(c);
            }
            }
            finally {
                client.close();
            }
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}