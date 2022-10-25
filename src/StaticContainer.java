import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaticContainer {

    public static CustomerRepository customerRepository = new CustomerRepository("customers.txt");
    public static SeanceRepository seanceRepository = new SeanceRepository("seances.txt");

    public static ArrayList<Customer> clientList;
    public static ArrayList<Seance> seanceList;

    static {
        try {
            clientList = new ArrayList<Customer>(customerRepository.getAllCustomers());
            seanceList = new ArrayList<Seance>(seanceRepository.getAllSeances());
           // Seance s1 = new Seance("Morbius", LocalDate.now(), LocalTime.now(), PEGI.none, new SeatsService());
            //Seance s2 = new Seance("The Room", LocalDate.now(), LocalTime.now(), PEGI.adult, new SeatsService());

        }
        catch (IOException e) {
            System.out.println(e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }catch(Exception e)
        {

            e.printStackTrace();
        }
    }


}
