package modelo;

// subclase Cliente

public class Cliente extends Usuario {
    
    private int idCliente;

    public Cliente(String nombre, String email, int idCliente) {
        super(nombre, email);
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
