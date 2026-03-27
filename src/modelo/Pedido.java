package modelo;


import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    public Pedido(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public Double calcularTotal() {
       return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
    

}
