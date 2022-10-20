import java.util.HashMap;

public class SeatsService {
    private int seatsInRow;

    private HashMap<Character, HashMap<Integer,Boolean>> availableSeats;

    //true - wolne
    //false - zajete

    public SeatsService() {
        seatsInRow = 15;
        availableSeats = new HashMap<>() {{
            put('A', initializeColumns());
            put('B', initializeColumns());
            put('C', initializeColumns());
            put('D', initializeColumns());
            put('E', initializeColumns());
            put('F', initializeColumns());
            put('G', initializeColumns());
        }};

        this.initializeColumns();
    }

    public SeatsService(int seatsInRow) {
        this.seatsInRow = seatsInRow;
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
        return innerMap;
    }

    public void makeSeatsFree(Character row, Integer column) {
        availableSeats.get(row).put(column, true);
    }

    public void addSeat(Character row, Integer column) {
        availableSeats.get(row).put(column, false);
    }

    public boolean isSeatFree(Character row, Integer column) {
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


}
