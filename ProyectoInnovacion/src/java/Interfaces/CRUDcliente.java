package Interfaces;

import Modelo.Cliente;
import java.util.List;

public interface CRUDcliente {
  public List listar();
    public Cliente list(int idcliente);
    public boolean agregar(Cliente clien);
    public boolean editar(Cliente clien);
    public boolean eliminar(int idcliente);  
}
