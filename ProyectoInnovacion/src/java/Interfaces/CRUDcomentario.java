/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Ivan
 */
import Modelo.Comentario;
import java.util.List;

public interface CRUDcomentario {
     public List listar();
    public Comentario list(int id);
    public boolean agregar(Comentario com);
    public boolean editar(Comentario com);
    public boolean eliminar(int id);
}
