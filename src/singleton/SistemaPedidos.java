package singleton;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

// Clase que implementa el patrón Singleton para gestionar todos los pedidos del sistema
public class SistemaPedidos {
    
    private static SistemaPedidos instancia; // Única instancia del sistema (Singleton)
    private List<Pedido> pedidos; // Lista que almacena todos los pedidos

    // Constructor privado para evitar creación de instancias desde fuera
    private SistemaPedidos(){
        this.pedidos = new ArrayList<>();
    }

    // Método estático para obtener la única instancia del sistema
    public static SistemaPedidos getInstancia() {

        if (instancia == null) {// VERIFICA SI LA INSTANCIA ES NULA O SI EXISTE
            instancia = new SistemaPedidos(); //CREA LA INSTANCIA EN LA VARIABLE INSTANCIA
        }
        return instancia;//MUETRA LA INSTANCIA ACTUAL 
    }
    
    // Agrega un nuevo pedido a la lista
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Devuelve la lista de todos los pedidos
    public List<Pedido> getPedidos() {
        return pedidos; 
    }

    // Muestra todos los pedidos registrados en consola
    public void mostrarTodosLosPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        System.out.println("\n=== TODOS LOS PEDIDOS REGISTRADOS ===");
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            System.out.println("\n--- PEDIDO #" + (i + 1) + " ---");
            System.out.println("Cliente: " + pedido.getCliente().getNombre());
            System.out.println("Email: " + pedido.getCliente().getEmail());
            System.out.println("Productos:");
            pedido.getProductos().forEach(producto -> 
                System.out.println("  - " + producto.getNombre() + ": $" + producto.getPrecio())
            );
            System.out.println("Total del pedido: $" + pedido.calcularTotal());
        }
    }
}
