package address;

import java.util.List;
import java.util.Scanner;

import address_data.AddressBook;
import address_data.AddressEntry;

public class AddressBookApplication {
    private AddressBook addressBook;
    private Scanner scanner;

    public AddressBookApplication() {
        String filePath = "G:/yahir/Documentos/Application_AddressBook/AddressBook_Contacts.txt";
        addressBook = new AddressBook(filePath);
        scanner = new Scanner(System.in);
    }

    public void run() {
        Menu menu = new Menu();
        boolean exit = false;

        while (!exit) {
            menu.mostrarMenu();
            String opcion = menu.getUserOpcion();

            switch (opcion) {
                case "1":
                    addContact();
                    break;
                case "2":
                    deleteContact();
                    break;
                case "3":
                    searchContactByLastName();
                    break;
                case "4":
                    showAllContacts();
                    break;
                case "5":
                    exit = true;
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("¡Directorio Cerrado con éxito! Que tengas buen día...");
                    System.out.println("-------------------------------------------------------------");
                    break;
                default:
                    System.out.println("Opcion no disponible. Inténtalo de nuevo.");
                    break;
            }
        }
    }

    private void addContact() {
        System.out.println("Complete los datos del contacto en los siguientes campos:");
        System.out.print("Nombre(s): ");
        String Nombre = scanner.nextLine();
        System.out.print("Apellido(s): ");
        String Apellido = scanner.nextLine();
        System.out.print("Calle: ");
        String Calle = scanner.nextLine();
        System.out.print("Ciudad: ");
        String Ciudad = scanner.nextLine();
        System.out.print("Estado: ");
        String Estado = scanner.nextLine();
        System.out.print("Código postal: ");
        String codigoPostal = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String Telefono = scanner.nextLine();

        AddressEntry entry = new AddressEntry(Nombre, Apellido, Calle, Ciudad, Estado,
                codigoPostal, email, Telefono);
        addressBook.addContact(entry);
    }

    private void deleteContact() {
        System.out.println("Ingrese el apellido del contacto a eliminar: ");
        String Apellido = scanner.nextLine();
        List<AddressEntry> searchResults = addressBook.searchContactByLastName(Apellido);
        if (!searchResults.isEmpty()) {
            System.out.println("Se encontraron las siguientes entradas:");
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i));
            }
            System.out.print("Selecciona el contacto a eliminar: ");
            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion >= 1 && opcion <= searchResults.size()) {
                AddressEntry entryToRemove = searchResults.get(opcion - 1);
                addressBook.deleteContact(entryToRemove);
            } else {
                System.out.println("Opción inválida.");
            }
        } else {
            System.out.println("No se encontraron contactos con ese a");
        }
    }

    private void searchContactByLastName() {
        System.out.println("Ingrese el inicio del apellido para buscar:");
        String Apellido = scanner.nextLine();
        List<AddressEntry> searchResults = addressBook.searchContactByLastName(Apellido);
        if (!searchResults.isEmpty()) {
            System.out.println("Se encontraron las siguientes entradas:");
            for (AddressEntry entry : searchResults) {
                System.out.println(entry);
                System.out.println("---------------");
            }
        } else {
            System.out.println("No se encontraron entradas con ese apellido.");
        }
    }

    private void showAllContacts() {
        List<AddressEntry> entries = addressBook.getAllEntries();
        if (!entries.isEmpty()) {
            System.out.println("Lista de entradas:");
            for (AddressEntry entry : entries) {
                System.out.println(entry);
                System.out.println("---------------");
            }
        } else {
            System.out.println("La libreta de direcciones está vacía.");
        }
    }

    public static void main(String[] args) {
        AddressBookApplication application = new AddressBookApplication();
        application.run();
    }
}