package Interfaces;

import Modelo.Incidencia;
import java.util.List;

public interface CRUDincidencia {
    public List listar();
    public Incidencia list(int idinci);
    public boolean agregar(Incidencia inci);
    public boolean editar(Incidencia inci);
    public boolean eliminar(int idinci);
}
