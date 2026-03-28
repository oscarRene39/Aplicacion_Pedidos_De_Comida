import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Cajero;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;
import singleton.SistemaPedidos;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaPedidos sistemaPedidos = SistemaPedidos.getInstancia();

        System.out.println("Bienvenido al sistema de pedidos de comida!");

        try {
            while (true) {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Crear nuevo pedido");
                System.out.println("2. Ver todos los pedidos");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opcion: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        
                        break;
                    case 2:
                        sistemaPedidos.mostrarTodosLosPedidos();
                        break;
                    case 3:
                        System.out.println("Gracias por usar nuestro sistema de pedidos.");
                        return;
                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    }
}
