import java.util.*;

public class TicketsService {
    public static List<Seance> seanceList;

    public static void buyTicket(Customer customer){
        //to trzeba potem zmienic na wczytanie z listy statycznej i powiazac seatsservice z konkretnym seansem
       // customer.setSeance(seance);



        int iterator = 1;
        Map<Integer,Integer> list = new HashMap<Integer,Integer>();

        for(int i = 0; i<StaticContainer.seanceList.size(); i++)
        {
            if(StaticContainer.seanceList.get(i).getSeatsService().areThereAvailableSeats())
               { System.out.println(String.valueOf(iterator+" "+StaticContainer.seanceList.get(i).getTitle()));
               list.put(iterator,i);
               iterator++;
               }
        }
        System.out.println("Wprowadz numer seansu:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.nextLine();
        while(!list.containsKey(number))
        {
            System.out.println("Wprowadz poprawny numer seansu:");
            number = scan.nextInt();
            scan.nextLine();
        }

        Seance seance = StaticContainer.seanceList.get(list.get(number));
        SeatsService seatsService = seance.getSeatsService();



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
                if(!seatsService.areThereAvailableSeats())
                {
                    System.out.println("Nie ma wiecej wolnych miejsc. Wybierz 1 aby przejsc do platnosci lub 0 aby anulowac");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    while((choice!=1)&&(choice!=0))
                    {
                        System.out.println("Wybierz 1 aby przejsc do platnosci lub 0 aby anulowac");
                        choice = scanner.nextInt();
                        scanner.nextLine();
                    }

                    if(choice==0)
                        return;

                    break;
                }
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
            drawSeatsTest(seatsService,s);
        }else{
            System.out.println("Brak miejsc");
        }
    }

    public static void drawSeatsTest(SeatsService seatsService,String s)
    {
        System.out.println("Aktualny stan miejsc");
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