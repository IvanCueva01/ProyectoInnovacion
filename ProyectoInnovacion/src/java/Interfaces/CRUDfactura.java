package Interfaces;

import Modelo.Factura;
import java.util.List;

public interface CRUDfactura {
    public List listar();
    public Factura list(int idfactura);
    public boolean agregar(Factura factu);
    public boolean editar(Factura factu);
    public boolean eliminar(int idfactura);
}
