package Interfaces;

import Modelo.Empresa;
import java.util.List;

public interface CRUDempresa {
    public List listar();
    public Empresa list(int id);
    public boolean agregar(Empresa empre);
    public boolean editar(Empresa empre);
    public boolean eliminar(int id); 
}
