import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
       // SeatsService ht = new SeatsService();
        /*
        ht.addSeat('A', 10);
        ht.addSeat('A', 14);
        ht.addSeat('A', 1);
        ht.addSeat('A', 34);
        ht.printAllSeats();

         */

        StaticContainer staticContainer = new StaticContainer();

        TicketsService.buyTicket(new Customer("a","x", "aaa", "123400"));
    }
}