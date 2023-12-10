package Modelo;

public class Articulo {
   private int id;
   private String titulo;
   private String contenido;
   private int idseccion;

    public Articulo() {
    }

    public Articulo(int id, String titulo, String contenido,int idseccion) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.idseccion = idseccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }    

    public int getIdseccion() {
        return idseccion;
    }

    public void setIdseccion(int idseccion) {
        this.idseccion = idseccion;
    }
    
}
