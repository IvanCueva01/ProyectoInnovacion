package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDempresa;
import Modelo.Empresa;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpresaDAO implements CRUDempresa{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empresa empre = new Empresa();
    
    @Override
    public List listar() {
          ArrayList<Empresa> list = new ArrayList<>();
        String sql = "select * from empresa where estado='1'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empresa empre = new Empresa();
                empre.setId(rs.getInt("id"));
                empre.setRuc(rs.getString("ruc"));
                empre.setRazonsocial(rs.getString("razonsocial"));
                empre.setTelefono(rs.getString("telefono"));
                empre.setCorreo(rs.getString("correo"));
                empre.setDireccion(rs.getString("direccion"));
                empre.setEstado(rs.getString("estado"));
                list.add(empre);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Empresa list(int id) {
            String sql = "select * from empresa where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                empre.setId(rs.getInt("id"));
                empre.setRuc(rs.getString("ruc"));
                empre.setRazonsocial(rs.getString("razonsocial"));
                empre.setTelefono(rs.getString("telefono"));
                empre.setCorreo(rs.getString("correo"));
                empre.setDireccion(rs.getString("direccion"));
                empre.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return empre;
    }

    @Override
    public boolean agregar(Empresa empre) {
      String sql = "insert into empresa(ruc,razonsocial,telefono,correo,direccion,estado) values "
                + "('"+empre.getRuc()+"','"+ empre.getRazonsocial()+"','"+ empre.getTelefono()+"',"
                + "'"+empre.getCorreo()+"','"+ empre.getDireccion() +"','"+empre.getEstado()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Empresa empre) {
    String sql = "update empresa set ruc='" + empre.getRuc()+ "',razonsocial='" + empre.getRazonsocial()+ "',"
                + "telefono='" + empre.getTelefono() + "',correo='" + empre.getCorreo() + "',"
                + "direccion='" + empre.getDireccion() + "', estado='" + empre.getEstado()+ "' where id=" + empre.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
      String sql = "update empresa set estado='0' where id="+ id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
