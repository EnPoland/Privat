import javax.management.StringValueExp;
import javax.xml.bind.annotation.XmlList;
import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * Created by списп on 31.03.2017.
 */
public class Main {


    public static List<Deposit> linkedlist = Collections.synchronizedList(new LinkedList<Deposit>());
    public static List ammount = Collections.synchronizedList(new ArrayList<Integer>());
    public static int count = 0;

    public static int getCount(){
        File file = new File("O:\\study\\EnPoPrivatServer\\data");
        String[] string = file.list();
        return count = string.length;
    }

    public static boolean idExist(String id){
        File file = new File("O:\\study\\EnPoPrivatServer\\data");
        String[] string = file.list();
        for (int i = 0;i<string.length;i++){
            if (string[i].equals(id));
        }

        return true;
    }

    public static void addTo(Deposit deposit){
        linkedlist.add(deposit);
    }

    public static void main(String args[]) {

        File file = new File("O:\\study\\EnPoPrivatServer\\data");
        String[] string = file.list();
        for (int i = 0; i < string.length; i++) {
            try {
                linkedlist.add(Converter.toJavaObject(string[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }




        for (int i = 0; i < string.length; i++) {
            try {
               ammount.add( Converter.toJavaObject(string[i]).amount_on_deposit);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }





        new Server();
    }




}
