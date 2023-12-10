package Modelo;

public class Seccion {
    private int idseccion;
    private String titulo;

    public Seccion() {
    }

    public Seccion(int idseccion, String titulo) {
        this.idseccion = idseccion;
        this.titulo = titulo;
    }

    public int getIdseccion() {
        return idseccion;
    }

    public void setIdseccion(int idseccion) {
        this.idseccion = idseccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
