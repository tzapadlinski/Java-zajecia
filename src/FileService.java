import java.io.*;

public class FileService {


    public void writeFile(Object savedObj, String filename) throws IOException {
        FileOutputStream f = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(f);
        out.writeObject(savedObj);
        out.close();
    }

    public Object readFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(f);
        Object object = in.readObject();
        return object;
    }
}
