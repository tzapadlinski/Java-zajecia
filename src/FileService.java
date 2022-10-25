import java.io.*;
import java.util.Optional;

public class FileService {

    public void writeFile(Object savedObj, String filename) throws IOException {
        FileOutputStream f = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(f);
        out.writeObject(savedObj);
        out.close();
    }

    public Optional<Object> readFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(f);
        Object readObject = in.readObject();
        Optional<Object> optionalObject = Optional.of(readObject);
        return optionalObject;
    }
}
