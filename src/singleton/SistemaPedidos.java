package singleton;

public class SistemaPedidos {
    private static SistemaPedidos instancia;
    private SistemaPedidos(){

        
    }
    public static SistemaPedidos getInstancia() {
        if (instancia == null) {
            instancia = new SistemaPedidos();
        }
        return instancia;
    }
}
