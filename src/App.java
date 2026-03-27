import factoryMethod.ProductoFactory;
import java.util.Arrays;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;

public class App {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido al sistema de pedidos de comida!");
        try {
            // Crear un cliente
            Cliente cliente1 = new Cliente("Juan Pérez", "juan.perez@example.com", 1);

            System.out.println("Cliente creado: " + cliente1.getNombre());

            // Crear productos
            Producto bebida = ProductoFactory.crearProducto("bebida", "Coca-Cola", 2500);
            Producto comida = ProductoFactory.crearProducto("comida", "Hamburguesa", 5000);
            Producto postre = ProductoFactory.crearProducto("postre", "Torta de chocolate", 3000);

            // Agregar productos al pedido
            Pedido pedido = new Pedido(cliente1, Arrays.asList(bebida, comida, postre));
           
                // Calcular total del pedido
                System.out.println("Total del pedido: $" + pedido.calcularTotal());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error al crear producto: " + e.getMessage());
        }
        finally {
            System.out.println("Gracias por usar nuestro sistema de pedidos.");
        }
    }
}
