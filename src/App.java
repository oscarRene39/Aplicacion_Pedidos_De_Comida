import factoryMethod.ProductoFactory; // Importa clase para crear productos
import java.util.ArrayList; // Importa clase para listas dinámicas
import java.util.List; // Importa interfaz para listas
import java.util.Scanner; // Importa clase para leer teclado
import modelo.Cliente; // Importa clase Cliente
import modelo.Pedido; // Importa clase Pedido
import modelo.Producto; // Importa clase Producto
import singleton.SistemaPedidos; // Importa clase Singleton

// Clase principal de la aplicación - punto de entrada del sistema de pedidos
public class App {
    public static void main(String[] args) { // Método principal - inicia el programa
        Scanner scanner = new Scanner(System.in); // Crea objeto para leer teclado
        SistemaPedidos sistemaPedidos = SistemaPedidos.getInstancia(); // Obtiene instancia única del sistema
        
        System.out.println("¡Bienvenido al sistema de pedidos de comida!"); // Muestra mensaje de bienvenida
        
        try { // Inicia bloque para capturar errores
            while (true) { // Bucle infinito del menú
                System.out.println("\n=== MENÚ PRINCIPAL ==="); // Muestra título del menú
                System.out.println("1. Crear nuevo pedido"); // Muestra opción 1
                System.out.println("2. Ver todos los pedidos"); // Muestra opción 2
                System.out.println("3. Salir"); // Muestra opción 3
                System.out.print("Seleccione una opción: "); // Pide al usuario elegir opción
                
                int opcion = scanner.nextInt(); // Lee número que el usuario ingresa
                scanner.nextLine(); // Limpia buffer del teclado
                
                switch (opcion) { // Evalúa la opción elegida
                    case 1: // Si elige 1
                        crearNuevoPedido(scanner, sistemaPedidos); // Llama método para crear pedido
                        break; // Sale del switch
                    case 2: // Si elige 2
                        sistemaPedidos.mostrarTodosLosPedidos(); // Llama método para mostrar pedidos
                        break; // Sale del switch
                    case 3: // Si elige 3
                        System.out.println("Gracias por usar nuestro sistema de pedidos."); // Muestra despedida
                        scanner.close(); // Cierra el scanner
                        return; // Termina el programa
                    default: // Si elige otra opción
                        System.out.println("Opción no válida. Intente nuevamente."); // Muestra error
                }
            }
        }
        catch (Exception e) { // Si ocurre algún error
            System.out.println("Error inesperado: " + e.getMessage()); // Muestra mensaje del error
        }
        finally { // Siempre se ejecuta
            scanner.close(); // Cierra el scanner
        }
    }
    
    // Método para crear un nuevo pedido con cliente y productos
    private static void crearNuevoPedido(Scanner scanner, SistemaPedidos sistemaPedidos) {
        try { // Inicia bloque para capturar errores
            // Ingresar datos del cliente
            System.out.println("\n=== DATOS DEL CLIENTE ==="); // Muestra título sección cliente
            System.out.print("Nombre del cliente: "); // Pide nombre del cliente
            String nombre = scanner.nextLine(); // Lee nombre del cliente
            
            System.out.print("Email del cliente: "); // Pide email del cliente
            String email = scanner.nextLine(); // Lee email del cliente
            
            System.out.print("ID del cliente: "); // Pide ID del cliente
            int idCliente = scanner.nextInt(); // Lee ID del cliente
            scanner.nextLine(); // Limpia buffer
            
            Cliente cliente = new Cliente(nombre, email, idCliente); // Crea objeto cliente
            System.out.println("Cliente creado: " + cliente.getNombre()); // Confirma creación del cliente
            
            // Ingresar productos del pedido
            List<Producto> productos = new ArrayList<>(); // Crea lista vacía para productos
            System.out.println("\n=== PEDIDO DE PRODUCTOS ==="); // Muestra título sección productos
            
            // Preguntar por cada tipo de producto
            System.out.println("\n=== BEBIDAS ==="); // Muestra título sección bebidas
            System.out.print("¿Desea agregar una bebida? (s/n): "); // Pregunta si quiere bebida
            String agregarBebida = scanner.nextLine(); // Lee respuesta del usuario
            if (agregarBebida.equalsIgnoreCase("s")) { // Si responde sí
                System.out.print("Nombre de la bebida: "); // Pide nombre de bebida
                String nombreBebida = scanner.nextLine(); // Lee nombre de bebida
                System.out.print("Precio de la bebida: "); // Pide precio de bebida
                double precioBebida = scanner.nextDouble(); // Lee precio de bebida
                scanner.nextLine(); // Limpia buffer
                Producto bebida = ProductoFactory.crearProducto("bebida", nombreBebida, precioBebida); // Crea objeto bebida
                productos.add(bebida); // Agrega bebida a la lista
                System.out.println("Bebida agregada: " + bebida.getNombre() + " - $" + bebida.getPrecio()); // Confirma agregado
            }
            
            System.out.println("\n=== COMIDAS ==="); // Muestra título sección comidas
            System.out.print("¿Desea agregar una comida? (s/n): "); // Pregunta si quiere comida
            String agregarComida = scanner.nextLine(); // Lee respuesta del usuario
            if (agregarComida.equalsIgnoreCase("s")) { // Si responde sí
                System.out.print("Nombre de la comida: "); // Pide nombre de comida
                String nombreComida = scanner.nextLine(); // Lee nombre de comida
                System.out.print("Precio de la comida: "); // Pide precio de comida
                double precioComida = scanner.nextDouble(); // Lee precio de comida
                scanner.nextLine(); // Limpia buffer
                Producto comida = ProductoFactory.crearProducto("comida", nombreComida, precioComida); // Crea objeto comida
                productos.add(comida); // Agrega comida a la lista
                System.out.println("Comida agregada: " + comida.getNombre() + " - $" + comida.getPrecio()); // Confirma agregado
            }
            
            System.out.println("\n=== POSTRES ==="); // Muestra título sección postres
            System.out.print("¿Desea agregar un postre? (s/n): "); // Pregunta si quiere postre
            String agregarPostre = scanner.nextLine(); // Lee respuesta del usuario
            if (agregarPostre.equalsIgnoreCase("s")) { // Si responde sí
                System.out.print("Nombre del postre: "); // Pide nombre de postre
                String nombrePostre = scanner.nextLine(); // Lee nombre de postre
                System.out.print("Precio del postre: "); // Pide precio de postre
                double precioPostre = scanner.nextDouble(); // Lee precio de postre
                scanner.nextLine(); // Limpia buffer
                Producto postre = ProductoFactory.crearProducto("postre", nombrePostre, precioPostre); // Crea objeto postre
                productos.add(postre); // Agrega postre a la lista
                System.out.println("Postre agregado: " + postre.getNombre() + " - $" + postre.getPrecio()); // Confirma agregado
            }
            
            // Permitir agregar más productos si desea
            while (true) { // Bucle para agregar más productos
                System.out.print("\n¿Desea agregar algún producto adicional? (s/n): "); // Pregunta si quiere más productos
                String continuar = scanner.nextLine(); // Lee respuesta del usuario
                if (!continuar.equalsIgnoreCase("s")) { // Si no responde sí
                    break; // Sale del bucle
                }
                
                System.out.println("\nOpciones de tipo de producto disponibles:"); // Muestra opciones disponibles
                System.out.println("  - bebida"); // Muestra opción bebida
                System.out.println("  - comida"); // Muestra opción comida
                System.out.println("  - postre"); // Muestra opción postre
                System.out.print("Tipo del producto (bebida/comida/postre): "); // Pide tipo de producto
                String tipoProducto = scanner.nextLine(); // Lee tipo de producto
                
                System.out.print("Nombre del producto: "); // Pide nombre del producto
                String nombreProducto = scanner.nextLine(); // Lee nombre del producto
                
                System.out.print("Precio del producto: "); // Pide precio del producto
                double precioProducto = scanner.nextDouble(); // Lee precio del producto
                scanner.nextLine(); // Limpia buffer
                
                Producto producto = ProductoFactory.crearProducto(tipoProducto, nombreProducto, precioProducto); // Crea producto
                productos.add(producto); // Agrega producto a la lista
                System.out.println("Producto agregado: " + producto.getNombre() + " - $" + producto.getPrecio()); // Confirma agregado
            }
            
            // Crear y guardar el pedido
            Pedido pedido = new Pedido(cliente, productos); // Crea objeto pedido
            sistemaPedidos.agregarPedido(pedido); // Guarda pedido en el sistema
            
            // Mostrar resumen del pedido
            System.out.println("\n=== RESUMEN DEL PEDIDO ==="); // Muestra título del resumen
            System.out.println("Cliente: " + cliente.getNombre()); // Muestra nombre del cliente
            System.out.println("Productos:"); // Muestra etiqueta productos
            for (Producto producto : productos) { // Recorre todos los productos
                System.out.println("  - " + producto.getNombre() + ": $" + producto.getPrecio()); // Muestra cada producto
            }
            System.out.println("Total del pedido: $" + pedido.calcularTotal()); // Muestra total del pedido
            System.out.println("¡Pedido guardado exitosamente!"); // Confirma que se guardó
            
        }
        catch (IllegalArgumentException e) { // Si hay error de argumentos
            System.out.println("Error: " + e.getMessage()); // Muestra mensaje del error
        }
    }
} 
