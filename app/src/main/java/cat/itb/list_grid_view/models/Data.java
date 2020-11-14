package cat.itb.list_grid_view.models;

public class Data {
    private String nombreJugador, posicion, dorsal;
    private int nacionalidad;

    public Data(String nombreJugador, String posicion, String dorsal, int nacionalidad) {
        this.nombreJugador = nombreJugador;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.nacionalidad = nacionalidad;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
