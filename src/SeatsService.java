import java.util.HashMap;

public class SeatsService {
    //TODO
    
    private int seatsInRow;

    private HashMap<Character, HashMap<Integer,Boolean>> availableSeats;
    private int numberOfSeats;
    private String rows = "ABCDEFG";

    //true - wolne
    //false - zajete

    public SeatsService() {
        seatsInRow = 15;
        numberOfSeats = 15*7;
        availableSeats = new HashMap<>() {{
            put('A', initializeColumns());
            put('B', initializeColumns());
            put('C', initializeColumns());
            put('D', initializeColumns());
            put('E', initializeColumns());
            put('F', initializeColumns());
            put('G', initializeColumns());
        }};

        //System.out.println(availableSeats);


       // this.initializeColumns();
    }

    public SeatsService(int seatsInRow) {
        this.seatsInRow = seatsInRow;
        numberOfSeats = seatsInRow*7;
        availableSeats = new HashMap<>() {{
            put('A', initializeColumns());
            put('B', initializeColumns());
            put('C', initializeColumns());
            put('D', initializeColumns());
            put('E', initializeColumns());
            put('F', initializeColumns());
            put('G', initializeColumns());
        }};
    }

    private HashMap<Integer,Boolean> initializeColumns() {
        HashMap<Integer,Boolean> innerMap = new HashMap<Integer,Boolean>();
        for(int i=1; i<=this.seatsInRow; i++) {
            innerMap.put(i, true);
        }
        System.out.print(innerMap);
        return innerMap;
    }

    public void makeSeatsFree(Character row, Integer column) {
        availableSeats.get(row).put(column, true);
    }

    public void addSeat(Character row, Integer column) {
        availableSeats.get(row).put(column, false);
    }

    public boolean isSeatFree(Character row, Integer column) {

        //System.out.print(availableSeats.get(row).get(1));
        if(availableSeats.get(row).get(column) == true)
            return true;
        else return false;
    }

    public void printAllSeats() {
        for (Character row: availableSeats.keySet()) {
            String key = row.toString();
            String value = availableSeats.get(row).toString();
            System.out.println(key + " " + value);
        }
    }

    public boolean areThereAvailableSeats()
    {

        for(int i = 0; i<rows.length(); i++)
        {
            for(int q = 1; q<=seatsInRow;q++)
            {
                if(availableSeats.get(rows.charAt(i)).get(q))
                    return true;
            }
        }

        return false;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }




}
