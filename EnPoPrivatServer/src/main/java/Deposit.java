
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;


/**
 * Created by списп on 31.03.2017.
 */


public class Deposit implements Serializable {
    public Deposit() {
    }
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Depositor")
    public String depositor;
    @JsonProperty("Account_id")
    public String account_id;
    @JsonProperty("Amount_on_deposit")
    public double amount_on_deposit;
    @JsonProperty("Profitability")
    public double profitability;
    @JsonProperty("Time_constraints")
    public double time_constraints;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public double getAmount_on_deposit() {
        return amount_on_deposit;
    }

    public void setAmount_on_deposit(double amount_on_deposit) {
        this.amount_on_deposit = amount_on_deposit;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public double getTime_constraints() {
        return time_constraints;
    }

    public void setTime_constraints(double time_constraints) {
        this.time_constraints = time_constraints;
    }

    public Deposit(String name, String country, String type, String depositor, String account_id, double amount_on_deposit, double profitability, double time_constraints) {
        this.name = name;
        this.country = country;
        this.type = type;
        this.depositor = depositor;

        this.account_id = account_id;
        this.amount_on_deposit = amount_on_deposit;
        this.profitability = profitability;
        this.time_constraints = time_constraints;
    }
    @Override
    public String toString() {
        return "Deposit"+account_id+"{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", depositor='" + depositor + '\'' +
                ", account_id='" + account_id + '\'' +
                ", amount_on_deposit='" + amount_on_deposit + '\'' +
                ", profitability='" + profitability + '\'' +
                ", time_constraints='" + time_constraints + '\'' +
                '}';
    }

}
