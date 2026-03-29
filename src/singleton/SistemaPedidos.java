package singleton; // Paquete que contiene clases Singleton

import java.util.ArrayList; // Importa clase para listas dinámicas
import java.util.List; // Importa interfaz para listas
import modelo.Pedido; // Importa clase Pedido

// Clase que implementa el patrón Singleton para gestionar todos los pedidos del sistema
public class SistemaPedidos {
    
    private static SistemaPedidos instancia; // Variable estática para guardar única instancia
    private List<Pedido> pedidos; // Lista que almacena todos los pedidos

    // Constructor privado para evitar creación de instancias desde fuera
    private SistemaPedidos(){ // Constructor privado - nadie puede crear objetos desde fuera
        this.pedidos = new ArrayList<>(); // Inicializa lista vacía de pedidos
    }

    // Método estático para obtener la única instancia del sistema
    public static SistemaPedidos getInstancia() { // Método estático - se puede llamar sin crear objeto

        if (instancia == null) { // Verifica si no existe instancia aún
            instancia = new SistemaPedidos(); // Crea la única instancia
        }
        return instancia; // Devuelve la instancia existente o recién creada
    }
    
    // Agrega un nuevo pedido a la lista
    public void agregarPedido(Pedido pedido) { // Método para agregar pedido
        pedidos.add(pedido); // Agrega pedido a la lista
    }

    // Devuelve la lista de todos los pedidos
    public List<Pedido> getPedidos() { // Método para obtener lista de pedidos
        return pedidos; // Devuelve la lista completa
    }

    // Muestra todos los pedidos registrados en consola
    public void mostrarTodosLosPedidos() { // Método para mostrar todos los pedidos
        if (pedidos.isEmpty()) { // Verifica si la lista está vacía
            System.out.println("No hay pedidos registrados."); // Muestra mensaje si no hay pedidos
            return; // Sale del método
        }

        System.out.println("\n=== TODOS LOS PEDIDOS REGISTRADOS ==="); // Muestra título
        for (int i = 0; i < pedidos.size(); i++) { // Bucle para recorrer cada pedido
            Pedido pedido = pedidos.get(i); // Obtiene pedido en posición i
            System.out.println("\n--- PEDIDO #" + (i + 1) + " ---"); // Muestra número de pedido
            System.out.println("Cliente: " + pedido.getCliente().getNombre()); // Muestra nombre del cliente
            System.out.println("Email: " + pedido.getCliente().getEmail()); // Muestra email del cliente
            System.out.println("Productos:"); // Muestra etiqueta productos
            pedido.getProductos().forEach(producto -> // Recorre cada producto del pedido
                System.out.println("  - " + producto.getNombre() + ": $" + producto.getPrecio()) // Muestra nombre y precio
            );
            System.out.println("Total del pedido: $" + pedido.calcularTotal()); // Muestra total del pedido
        }
    }
}
