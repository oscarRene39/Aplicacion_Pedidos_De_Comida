import factoryMethod.ProductoFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;
import singleton.SistemaPedidos;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaPedidos sistemaPedidos = SistemaPedidos.getInstancia();
        
        System.out.println("¡Bienvenido al sistema de pedidos de comida!");
        
        try {
            while (true) {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Crear nuevo pedido");
                System.out.println("2. Ver todos los pedidos");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                
                switch (opcion) {
                    case 1:
                        crearNuevoPedido(scanner, sistemaPedidos);
                        break;
                    case 2:
                        sistemaPedidos.mostrarTodosLosPedidos();
                        break;
                    case 3:
                        System.out.println("Gracias por usar nuestro sistema de pedidos.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
    
    private static void crearNuevoPedido(Scanner scanner, SistemaPedidos sistemaPedidos) {
        try {
            // Ingresar datos del cliente
            System.out.println("\n=== DATOS DEL CLIENTE ===");
            System.out.print("Nombre del cliente: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Email del cliente: ");
            String email = scanner.nextLine();
            
            System.out.print("ID del cliente: ");
            int idCliente = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            Cliente cliente = new Cliente(nombre, email, idCliente);
            System.out.println("Cliente creado: " + cliente.getNombre());
            
            // Ingresar productos del pedido
            List<Producto> productos = new ArrayList<>();
            System.out.println("\n=== PEDIDO DE PRODUCTOS ===");
            
            // Preguntar por cada tipo de producto
            System.out.println("\n=== BEBIDAS ===");
            System.out.print("¿Desea agregar una bebida? (s/n): ");
            String agregarBebida = scanner.nextLine();
            if (agregarBebida.equalsIgnoreCase("s")) {
                System.out.print("Nombre de la bebida: ");
                String nombreBebida = scanner.nextLine();
                System.out.print("Precio de la bebida: ");
                double precioBebida = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer
                Producto bebida = ProductoFactory.crearProducto("bebida", nombreBebida, precioBebida);
                productos.add(bebida);
                System.out.println("Bebida agregada: " + bebida.getNombre() + " - $" + bebida.getPrecio());
            }
            
            System.out.println("\n=== COMIDAS ===");
            System.out.print("¿Desea agregar una comida? (s/n): ");
            String agregarComida = scanner.nextLine();
            if (agregarComida.equalsIgnoreCase("s")) {
                System.out.print("Nombre de la comida: ");
                String nombreComida = scanner.nextLine();
                System.out.print("Precio de la comida: ");
                double precioComida = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer
                Producto comida = ProductoFactory.crearProducto("comida", nombreComida, precioComida);
                productos.add(comida);
                System.out.println("Comida agregada: " + comida.getNombre() + " - $" + comida.getPrecio());
            }
            
            System.out.println("\n=== POSTRES ===");
            System.out.print("¿Desea agregar un postre? (s/n): ");
            String agregarPostre = scanner.nextLine();
            if (agregarPostre.equalsIgnoreCase("s")) {
                System.out.print("Nombre del postre: ");
                String nombrePostre = scanner.nextLine();
                System.out.print("Precio del postre: ");
                double precioPostre = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer
                Producto postre = ProductoFactory.crearProducto("postre", nombrePostre, precioPostre);
                productos.add(postre);
                System.out.println("Postre agregado: " + postre.getNombre() + " - $" + postre.getPrecio());
            }
            
            // Permitir agregar más productos si desea
            while (true) {
                System.out.print("\n¿Desea agregar algún producto adicional? (s/n): ");
                String continuar = scanner.nextLine();
                if (!continuar.equalsIgnoreCase("s")) {
                    break;
                }
                
                System.out.println("\nOpciones de tipo de producto disponibles:");
                System.out.println("  - bebida");
                System.out.println("  - comida");
                System.out.println("  - postre");
                System.out.print("Tipo del producto (bebida/comida/postre): ");
                String tipoProducto = scanner.nextLine();
                
                System.out.print("Nombre del producto: ");
                String nombreProducto = scanner.nextLine();
                
                System.out.print("Precio del producto: ");
                double precioProducto = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer
                
                Producto producto = ProductoFactory.crearProducto(tipoProducto, nombreProducto, precioProducto);
                productos.add(producto);
                System.out.println("Producto agregado: " + producto.getNombre() + " - $" + producto.getPrecio());
            }
            
            // Crear y guardar el pedido
            Pedido pedido = new Pedido(cliente, productos);
            sistemaPedidos.agregarPedido(pedido);
            
            // Mostrar resumen del pedido
            System.out.println("\n=== RESUMEN DEL PEDIDO ===");
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Productos:");
            for (Producto producto : productos) {
                System.out.println("  - " + producto.getNombre() + ": $" + producto.getPrecio());
            }
            System.out.println("Total del pedido: $" + pedido.calcularTotal());
            System.out.println("¡Pedido guardado exitosamente!");
            
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
