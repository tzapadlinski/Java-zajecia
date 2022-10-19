import java.io.Serializable;

public class Seance implements Serializable {
    private static final long serialVersionUID = 123456L;
    private int dupa;

    public Seance(int dupa) {
        this.dupa = dupa;
    }

    public int getDupa() {
        return dupa;
    }

    @Override
    public String toString() {
        return "" + serialVersionUID + "\n" + dupa;
    }
}
