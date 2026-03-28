package modelo;

public class Cajero extends Usuario {
    private String idCajero;

    public Cajero(String nombre,  String idCajero) {
        super(nombre);
        this.idCajero = idCajero;
    }

    public String getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(String idCajero) {
        this.idCajero = idCajero;
    }

    @Override
    public String toString() {
        return super.toString() + ", idCajero='" + idCajero + '\'';
    }
}