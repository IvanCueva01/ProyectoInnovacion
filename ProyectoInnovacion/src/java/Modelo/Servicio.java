package Modelo;

public class Servicio {
    int idservicio;
    String nombre;
    String estado;

    public Servicio() {
    }

    public Servicio(int idservicio, String nombre, String estado) {
        this.idservicio = idservicio;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
