import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        Seance s = new Seance(11);
        FIleService fs = new FIleService();

        fs.writeFile(s, "dupaa.txt");
    }
}