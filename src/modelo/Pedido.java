package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {
    private Cliente cliente;
    private Cajero cajero;
    private List<Producto> productos;

    public Pedido(Cliente cliente, Cajero cajero, List<Producto> productos) {
        this.cliente = cliente;
        this.cajero = cajero;
        this.productos = productos;
    }

    public Double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public static Pedido ingresarPedido(Scanner scanner) {
        System.out.println("\n=== DATOS DEL CLIENTE ===");
        System.out.print("Nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Turno del cliente: ");
        int turnoCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteT = new Cliente(nombreCliente, turnoCliente);

        System.out.println("\n=== DATOS DEL CAJERO ===");
        System.out.print("Nombre del cajero: ");
        String nombreCajero = scanner.nextLine();
        System.out.print("ID del cajero: ");
        String idCajero = scanner.nextLine();

        Cajero cajero = new Cajero(nombreCajero, idCajero);

        List<Producto> productos = new ArrayList<>();

        System.out.println("\n=== PRIMER PRODUCTO (OBLIGATORIO) ===");
        productos.add(leerProducto(scanner));

        while (true) {
            System.out.print("Desea ingresar mas productos? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
            System.out.println("\n=== NUEVO PRODUCTO ===");
            productos.add(leerProducto(scanner));
        }

        return new Pedido(cliente, cajero, productos);
    }

    private static Producto leerProducto(Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0.");
        }

        return new Producto(nombre, precio, cantidad);
    }
}
