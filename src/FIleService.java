import java.io.*;

public class FIleService {
    public void writeFile(Object savedObj, String filename) throws IOException {
        FileWriter f = new FileWriter(filename);
        BufferedWriter out = new BufferedWriter(f);
        out.write(savedObj.toString());
        out.close();
    }

    public String readFile(String filename) throws IOException {
        String input = new String();
        String strLine = new String();
        FileInputStream f = new FileInputStream(filename);
        DataInputStream in = new DataInputStream(f);
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        while ((strLine = r.readLine()) != null)
            input += strLine;
        in.close();
        return input;
    }
}
