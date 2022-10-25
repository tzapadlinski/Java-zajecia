import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class RepositoryTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Seance s1 = new Seance("Morbius", LocalDate.now(), LocalTime.now(), PEGI.none, new SeatsService());
        Seance s2 = new Seance("The Room", LocalDate.now(), LocalTime.now(), PEGI.adult, new SeatsService());
        List<Seance> seances = List.of(s1, s2);
        Customer c1 = new Customer("a","x", "aaa", "123400");
        Customer c2 = new Customer("b","c", "bbb", "12320");
        List customers = List.of(c1, c2);

        SeanceRepository seanceRepository = new SeanceRepository("seances.txt");
        CustomerRepository customerRepository = new CustomerRepository("customers.txt");
        seanceRepository.saveAllSeances(seances);
        customerRepository.saveAllCustomers(customers);
        List<Seance> seancesTest = (List<Seance>) seanceRepository.getAllSeances();
        System.out.println(seancesTest.get(1));
        System.out.println(customerRepository.getAllCustomers());
        customerRepository.setFileName("customersOtherNameTest.txt");
        customerRepository.saveAllCustomers(customers);
        System.out.println(customerRepository.getAllCustomers());
        

    }
}