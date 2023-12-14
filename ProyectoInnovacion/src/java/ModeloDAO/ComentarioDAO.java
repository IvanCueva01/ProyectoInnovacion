/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Modelo.Comentario;
import Interfaces.CRUDcomentario;
import Config.Conexion;
import java.sql.*;
import java.util.*;

public class ComentarioDAO implements CRUDcomentario{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Comentario com = new Comentario();

    @Override
    public List listar() {
    ArrayList<Comentario> mensajes = new ArrayList<>();
        String sql = "select * from comentario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comentario com = new Comentario();
                com.setId(rs.getInt("id_comentario"));
                com.setMensaje(rs.getString("comentario"));
                com.setAutor(rs.getString("autor"));
                com.setFecha(rs.getString("fecha"));
                mensajes.add(com);
            }
        } catch (Exception e) {
        }
        return mensajes;
    }
    @Override
    public Comentario list(int id) {
    String sql = "select * from comentario where id_comentario="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                com.setId(rs.getInt("id_comentario"));
                com.setMensaje(rs.getString("comentario"));
                com.setAutor(rs.getString("autor"));
                com.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
        }
        return com;
    }

    @Override
    public boolean agregar(Comentario com) {
     String sql = "insert into comentario(comentario,autor,fecha) values (?,?,CURRENT_TIME())";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, com.getMensaje());
            ps.setString(2, com.getAutor());
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean editar(Comentario com) {
       String sql = "update comentario set comentario=?,autor=? where id_comentario=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, com.getMensaje());
            ps.setString(2, com.getAutor());
            ps.setInt(3, com.getId());
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
     String sql = "delete from comentario where id_comentario="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }
}
