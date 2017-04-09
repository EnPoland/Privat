/**
 * Created by списп on 31.03.2017.
 */
import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.File;
import java.io.IOException;


public class Converter {




    public static void toJSON(Deposit deposit, String name) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("data/"+name+".json"), deposit);
        System.out.println("json created!");
    }

    public static Deposit toJavaObject(String name) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("O:\\study\\EnPoPrivatServer\\data\\"+name), Deposit.class);
    }

}