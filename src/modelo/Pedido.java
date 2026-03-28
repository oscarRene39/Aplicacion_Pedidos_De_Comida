package modelo;


import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;// relacion de asociacion de un pedido con varios productos
    public Pedido(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public Double calcularTotal() {
        Double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
    
}
