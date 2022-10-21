import java.io.Serializable;
import java.util.Collection;

public class Customer implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Seance seance;
    private Collection<String> seats;

    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
//                this.seance = seance;
//                this.seats = seats;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public Collection<String> getSeats() {
        return seats;
    }

    public void setSeats(Collection<String> seats) {
        this.seats = seats;
    }

}