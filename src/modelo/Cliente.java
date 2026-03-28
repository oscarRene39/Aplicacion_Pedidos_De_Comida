package modelo;

// subclase Cliente

public class Cliente extends Usuario {
    
    private int TurnoPedido;

    public Cliente(String nombre,  int TurnoPedido) {
        super(nombre);
        this.TurnoPedido = TurnoPedido;
    }

    public int getTurnoPedido() {
        return TurnoPedido;
    }

    public void setTurnoPedido(int TurnoPedido) {
        this.TurnoPedido = TurnoPedido;
    }
    
}
