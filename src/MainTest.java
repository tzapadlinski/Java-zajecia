import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Seance s = new Seance(11);
        FileService fs = new FileService();
        fs.writeFile(s, "dupaa.txt");
        Seance g = (Seance) fs.readFile("dupaa.txt");
        System.out.println(g);
    }
}