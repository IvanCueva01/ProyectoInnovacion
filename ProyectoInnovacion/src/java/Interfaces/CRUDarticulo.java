package Interfaces;
import Modelo.Articulo;
import java.util.List;

public interface CRUDarticulo {
    public List listar();
    public Articulo list(int id);
    public boolean agregar(Articulo arti);
    public boolean editar(Articulo arti);
    public boolean eliminar(int id); 
}
