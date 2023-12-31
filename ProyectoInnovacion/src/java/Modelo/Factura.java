package Modelo;

public class Factura {
    int idfactura;
    int idcliente;
    String fechafactura;
    int idservicio;
    int cantidad;
    double precioUnitario;
    double total;
    double igv;

    public Factura() {
    }

    public Factura(int idcliente, String fechafactura, int idservicio, int cantidad, double precioUnitario, double total,double igv) {
        this.idcliente = idcliente;
        this.fechafactura = fechafactura;
        this.idservicio = idservicio;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = total;
        this.igv = igv;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(String fechafactura) {
        this.fechafactura = fechafactura;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double precioUnitario,int cantidad) {
        this.total = precioUnitario*cantidad;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double precioUnitario,int cantidad) {
        this.igv = precioUnitario*cantidad*0.18;
    }
    
}
