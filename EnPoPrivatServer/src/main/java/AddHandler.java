import java.io.*;
import java.net.Socket;

public class AddHandler
extends ClientHandler {
    public AddHandler(Socket st) {
        super(st);
    }

    public void add() throws IOException {
        OutputStream outStream = this.client.getOutputStream();
        PrintWriter out = new PrintWriter(outStream, true);
        InputStream inStream = this.client.getInputStream();
        BufferedReader inputLine = new BufferedReader(new InputStreamReader(inStream));
        out.println("Enter name of a bank");
        String name = inputLine.readLine();
        out.println("Enter country");
        String country = inputLine.readLine();
        out.println("Enter type");
        String type = inputLine.readLine();
        out.println("Enter depositor");
        String depositor = inputLine.readLine();
        out.println("Enter account_id");
        String account_id = inputLine.readLine();
        out.println("Enter amount_on_deposit");
        double amount_on_deposit = Double.parseDouble(inputLine.readLine());
        Main.ammount.add(amount_on_deposit);
        out.println("Enter profitability");
        double profitability = Integer.parseInt(inputLine.readLine());
        out.println("Enter time_constraints");
        double time_constraints = Double.parseDouble(inputLine.readLine());
        if (!Main.idExist((String)account_id)) {
            if (time_constraints > 0.0 & profitability > 0.0 & amount_on_deposit > 0.0) {
                out.println(" ADDING ");
                Deposit deposit = new Deposit(name, country, type, depositor, account_id, amount_on_deposit, profitability, time_constraints);
                Main.addTo((Deposit)deposit);
                Converter.toJSON((Deposit)deposit, (String)account_id);
            } else {
                out.println("ERROR");
            }
        } else {
            out.println("Deposit with this id is already exist");
        }
    }
}