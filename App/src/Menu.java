import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("==== Directorio de Contactos ====");
        System.out.println("=================================");
        System.out.println("1. Agregar Contacto");
        System.out.println("2. Eliminar Contacto");
        System.out.println("3. Buscar Contactos");
        System.out.println("4. Mostrar Contactos");
        System.out.println("5. Salir");
        System.out.println("================================");
    }

    public String getUserOpcion() {
        System.out.print("¿Que deseas realizar?: ");
        return scanner.nextLine();
    }
}