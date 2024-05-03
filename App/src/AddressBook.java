import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddressBook {
    private List<AddressEntry> entries;
    private String filePath;

    public AddressBook(String filePath) {
        this.filePath = filePath;
        uploadEntriesFromFile();
    }

    public void addContact(AddressEntry entry) {
        if (noDuplicado(entry)) {
            System.out.println("---------------------");
            System.out.println("El contacto ya existe en tu Directorio");
        } else {
            entries.add(entry);
            saveEntriesFiles();
            System.out.println("---------------------");
            System.out.println("Contacto Agregado");
        }
    }

    public void deleteContact(AddressEntry entry) {
        entries.remove(entry);
        saveEntriesFiles();
        System.out.println("Contacto Eliminado");
    }

    public List<AddressEntry> searchLastName(String lastName) {
        List<AddressEntry> searchResults = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(lastName)) {
                searchResults.add(entry);
            }
        }

        return searchResults;
    }

    public List<AddressEntry> viewAllContacts() {
        return entries;
    }

    private void uploadEntriesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                AddressEntry entry = createAddressEntryFromString(line);
                if (entry != null) {
                    entries.add(entry);
                }
            }
        } catch (IOException e) {
            System.out.println("No se han podido cargar los datos del Directorio");
        }
    }

    private void saveEntriesFiles() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (AddressEntry entry : entries) {
                writer.write(entryToString(entry));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se han podido guardar los cambios.");
        }
    }

    private AddressEntry createAddressEntryFromString(String line) {
        String[] parts = line.split(",");

        if (parts.length == 8) {
            String name = parts[0];
            String lastName = parts[1];
            String street = parts[2];
            String city = parts[3];
            String state = parts[4];
            String postalCode = parts[5];
            String email = parts[6];
            String phone = parts[7];

            return new AddressEntry(name, lastName, street, city, state, postalCode, email, phone);
        }

        return null;
    }

    private String entryToString(AddressEntry entry) {
        return entry.getName() + " " + entry.getLastName() + " " + entry.getStreet() + " " + entry.getCity() + " "
                + entry.getState() + " " + entry.getPostalCode() + " " + entry.getEmail() + " " + entry.getPhone();
    }

    public void orderContact() {
        Collections.sort(entries, new Comparator<AddressEntry>() {
            @Override
            public int compare(AddressEntry entry1, AddressEntry entry2) {
                String name1 = entry1.getLastName();
                String name2 = entry2.getLastName();
                return name1.compareTo(name2);
            }
        });
    }

    private boolean noDuplicado(AddressEntry entry) {
        for (AddressEntry existingEntry : entries) {
            if (existingEntry.getName().equals(entry.getName())
                    && existingEntry.getLastName().equals(entry.getLastName())) {
                return true;
            }
        }
        return false;
    }
}