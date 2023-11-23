package Interfaces;

import Modelo.Servicio;
import java.util.List;

public interface CRUDservicio {
    public List listar();
    public Servicio list(int idservicio);
    public boolean agregar(Servicio servi);
    public boolean editar(Servicio servi);
    public boolean eliminar(int idservicio);
    
}
