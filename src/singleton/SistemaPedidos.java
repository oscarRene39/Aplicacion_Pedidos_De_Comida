package singleton;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

public class SistemaPedidos {
    private static SistemaPedidos instancia;
    private List<Pedido> pedidos;
    
    private SistemaPedidos(){
        this.pedidos = new ArrayList<>();
    }
    
    public static SistemaPedidos getInstancia() {
        if (instancia == null) {
            instancia = new SistemaPedidos();
        }
        return instancia;
    }
    
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
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
            System.out.println("Turno cliente: " + pedido.getCliente().getTurnoPedido());
            System.out.println("Cajero: " + pedido.getCajero().getNombre() + " (" + pedido.getCajero().getIdCajero() + ")");
            System.out.println("Productos:");
            pedido.getProductos().forEach(producto -> 
                System.out.println("  - " + producto.getNombre() + " x" + producto.getCantidad() + ": $" + producto.getPrecio())
            );
            System.out.println("Total del pedido: $" + pedido.calcularTotal());
        }
    }
}
