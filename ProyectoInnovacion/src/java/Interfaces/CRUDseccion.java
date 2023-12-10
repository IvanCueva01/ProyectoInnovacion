package Interfaces;
import Modelo.Seccion;
import java.util.List;

public interface CRUDseccion {
    public List listar();
    public Seccion list(int idseccion);
    public boolean agregar(Seccion sec);
    public boolean editar(Seccion sec);
    public boolean eliminar(int idseccion); 
}
