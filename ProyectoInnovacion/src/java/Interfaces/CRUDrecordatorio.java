
package Interfaces;

import Modelo.Recordatorio;
import java.util.List;

public interface CRUDrecordatorio {
     public List listar();
    public Recordatorio list(int id);
    public boolean agregar(Recordatorio rec);
    public boolean editar(Recordatorio rec);
    public boolean eliminar(int id);
}
