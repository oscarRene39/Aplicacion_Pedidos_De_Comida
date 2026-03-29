package factoryMethod;

import modelo.Producto;

public class ProductoFactory {
    public static Producto crearProducto(String tipoString, String nombre, double precio) {

        switch (tipoString.toLowerCase()) {
            case "bebida":
                return new Producto(nombre +" bebida", precio);
            case "comida":
                return new Producto(nombre +" comida", precio);
            case "postre":
                return new Producto(nombre +" postre", precio);
            default:
                throw new IllegalArgumentException("Tipo de producto no reconocido: " );
        }
       
    }}

