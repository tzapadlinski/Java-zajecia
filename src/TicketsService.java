import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class TicketsService {
    public static List<Seance> seanceList;

    public static void buyTicket(Customer customer, Seance seance, SeatsService seatsService){
        //to trzeba potem zmienic na wczytanie z listy statycznej i powiazac seatsservice z konkretnym seansem
        customer.setSeance(seance);

        if(seatsService.getNumberOfSeats()>0) {
            String s = "ABCDEFG";
            drawSeats(seatsService, s);
            Character row;
            int column;
            Scanner scanner = new Scanner(System.in);
            Collection<String> tickets = new ArrayList<String>();
            while(true){
                String userInput = scanner.nextLine();
                row = userInput.charAt(0);
                column = Integer.parseInt(String.valueOf(userInput.charAt(1)));
                if(row == '0')
                    break;
                if (row < s.charAt(0) || row > s.charAt(s.length() - 1) || column < 0 || column > seatsService.getSeatsInRow())
                    System.out.println("Niedozwolony wybor. Prosze wpisac poprawna wartosc");
                else if (!seatsService.isSeatFree(row, column))
                    System.out.println("Miejsce zajete. Prosze wpisac poprawna wartosc");
                else{
                    tickets.add(String.valueOf(row+column));
                    seatsService.addSeat(row,column);
                }

            }

            customer.setSeance(seance);
            customer.setSeats(tickets);
            System.out.print("Nastepuje przekierowanie do platnosci prosze wpisac pin z aplikacji bankowej: ");
            scanner.nextLine();
            System.out.println("Platnosc zfinalizowana");
            drawSeats(seatsService,s);
        }else{
            System.out.println("Brak miejsc");
        }
    }

    private static void drawSeats(SeatsService seatsService,String s)
    {
        System.out.println("Wybierz miejsce ze schematu podajac litere i numer. Wyswietlane sa tylko numery miejsc wolnych.\n" +
                " Po wybraniu kazdorazowo miejsca nacisjnij eneter. Aby zakonczyc wpisz 00");

        for(int i = 0; i<s.length(); i++)
        {
            System.out.print(String.valueOf(s.charAt(i) + "  "));
            for(int q = 1; q<=seatsService.getSeatsInRow(); q++)
            {
                if(seatsService.isSeatFree(s.charAt(i),q))
                    System.out.print(String.valueOf(q+" "));
                else
                    System.out.print(String.valueOf("  "));
            }

            System.out.println();
        }
    }
}