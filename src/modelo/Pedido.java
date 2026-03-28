package modelo;

import java.util.List;

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
}
