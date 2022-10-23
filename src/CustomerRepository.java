import java.io.IOException;
import java.util.Collection;
import java.util.Optional;


//TODO dodam funkcje jeśli zdecydujemy się na zapisywanie/czytanie klientów wg danego pola.
public class CustomerRepository {
    private final FileService fileService;
    private String fileName;

    public CustomerRepository(String fileName) {
        fileService = new FileService();
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void saveAllCustomers(Collection<Customer> customers) throws IOException {
        fileService.writeFile(customers, fileName);
    }

    public Collection<Customer> getAllCustomers() throws IOException, ClassNotFoundException {
        Optional<Object> optionalObject = fileService.readFile(fileName);
        if(optionalObject.isEmpty()){
            throw new IOException("No objects were read. Try changing fileName.");
        }
        Collection<Customer> customers =(Collection<Customer>) optionalObject.get();
        return customers;
    }
}
