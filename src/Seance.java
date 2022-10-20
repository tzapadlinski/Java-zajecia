import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;


enum PEGI {
    none, child, teen, adult;
    //0,7,16,18
}

public class Seance implements Serializable {
    private String title;
    private LocalDate date;
    private LocalTime time;
    private PEGI pegi;
    private HashMap<Character, HashMap<Integer,Boolean>> availableSeats;

    public Seance(String title, LocalDate date, LocalTime time, PEGI pegi, HashMap<Character, HashMap<Integer, Boolean>> availableSeats) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.pegi = pegi;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public PEGI getPegi() {
        return pegi;
    }

    public void setPegi(PEGI pegi) {
        this.pegi = pegi;
    }

    public HashMap<Character, HashMap<Integer, Boolean>> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(HashMap<Character, HashMap<Integer, Boolean>> availableSeats) {
        this.availableSeats = availableSeats;
    }
}