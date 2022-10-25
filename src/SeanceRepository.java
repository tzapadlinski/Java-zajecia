import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class SeanceRepository {
    private final FileService fileService;
    private String fileName;

    public SeanceRepository(String fileName) {
        fileService = new FileService();
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void saveAllSeances(Collection<Seance> seances) throws IOException {
        fileService.writeFile(seances, fileName);
    }

    public Collection<Seance> getAllSeances() throws IOException, ClassNotFoundException {
        Optional<Object> optionalObject = fileService.readFile(fileName);
        if(!optionalObject.isPresent()){
            throw new IOException("No objects were read. Try changing fileName.");
        }
        Collection<Seance> seances =(Collection<Seance>) optionalObject.get();
        return seances;
    }
}
