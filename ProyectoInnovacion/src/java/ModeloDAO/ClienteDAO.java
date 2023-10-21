package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDcliente;
import Modelo.Cliente;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO implements CRUDcliente {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente clien = new Cliente();

    @Override
    public List listar() {
        ArrayList<Cliente> list = new ArrayList<>();
        String sql = "select * from cliente where ESTADO='1'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente clien = new Cliente();
                clien.setIdcliente(rs.getInt("IDCLIENTE"));
                clien.setDni(rs.getString("DNI"));
                clien.setNombre(rs.getString("NOMBRES"));
                clien.setApellido(rs.getString("APELLIDOS"));
                clien.setTelefono(rs.getString("TELEFONO"));
                clien.setCorreo(rs.getString("CORREO"));
                clien.setDireccion(rs.getString("DIRECCION"));
                clien.setFechanac(rs.getString("FECHANAC"));
                clien.setEstado(rs.getString("ESTADO"));
                list.add(clien);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Cliente list(int idcliente) {
        String sql = "select * from cliente where IDCLIENTE=" + idcliente;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clien.setIdcliente(rs.getInt("IDCLIENTE"));
                clien.setDni(rs.getString("DNI"));
                clien.setNombre(rs.getString("NOMBRES"));
                clien.setApellido(rs.getString("APELLIDOS"));
                clien.setTelefono(rs.getString("TELEFONO"));
                clien.setCorreo(rs.getString("CORREO"));
                clien.setDireccion(rs.getString("DIRECCION"));
                clien.setFechanac(rs.getString("FECHANAC"));
                clien.setEstado(rs.getString("ESTADO"));
            }
        } catch (Exception e) {
        }
        return clien;
    }

    @Override
    public boolean agregar(Cliente clien) {
        String sql = "insert into cliente(DNI,NOMBRES,APELLIDOS,TELEFONO,CORREO,DIRECCION,FECHANAC,ESTADO) values "
                + "('"+clien.getDni()+"','"+ clien.getNombre()+"','"+ clien.getApellido()+"','"+ clien.getTelefono()+"',"
                + "'"+clien.getCorreo()+"','"+ clien.getDireccion() +"','"+clien.getFechanac()+"','"+clien.getEstado()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Cliente clien) {
        String sql = "update cliente set DNI='" + clien.getDni() + "',NOMBRES='" + clien.getNombre() + "',"
                + "APELLIDOS='" + clien.getApellido() + "',TELEFONO='" + clien.getTelefono() + "',CORREO='" + clien.getCorreo() + "',"
                + "DIRECCION='" + clien.getDireccion() + "',FECHANAC='" + clien.getFechanac() + "',"
                + "ESTADO='" + clien.getEstado()+ "' where IDCLIENTE=" + clien.getIdcliente();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idcliente) {
        String sql = "update cliente set ESTADO='0' where IDCLIENTE="+ idcliente;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
