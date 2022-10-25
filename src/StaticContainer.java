import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaticContainer {

    public static CustomerRepository customerRepository = new CustomerRepository("clients.txt");
    public static SeanceRepository seanceRepository = new SeanceRepository("seances.txt");

    public static ArrayList<Customer> clientList;
    public static ArrayList<Seance> seanceList;

    static {
        try {
            clientList = (ArrayList<Customer>) customerRepository.getAllCustomers();
            seanceList = (ArrayList<Seance>) seanceRepository.getAllSeances();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}
