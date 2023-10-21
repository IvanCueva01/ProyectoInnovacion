package Modelo;

public class Incidencia {
    int idinci;
    int idcliente;
    int idempleado;
    String asunto;
    String detalle;
    String fecharegistro;
    String estado;

    public Incidencia() {
    }

    public Incidencia(int idcliente, int idempleado, String asunto, String detalle, String fecharegistro, String estado) {
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.asunto = asunto;
        this.detalle = detalle;
        this.fecharegistro = fecharegistro;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    public int getIdinci() {
        return idinci;
    }

    public void setIdinci(int idinci) {
        this.idinci = idinci;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    
}
