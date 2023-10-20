package Interfaces;

import Modelo.Empleado;
import java.util.List;

public interface CRUDempleado {
    public List listar();
    public Empleado list(int idemple);
    public boolean agregar(Empleado emple);
    public boolean editar(Empleado emple);
    public boolean eliminar(int idemple);
}
