public class Lab1Test {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository("Customers.txt");
        SeanceRepository seanceRepository = new SeanceRepository("Seances.txt");
        TicketsService ticketsService = new TicketsService();
    }
}
