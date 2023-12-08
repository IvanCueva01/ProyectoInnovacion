package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDfactura;
import Modelo.Factura;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FacturaDAO implements CRUDfactura {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Factura factu = new Factura();

    @Override
    public List listar() {
        ArrayList<Factura> list = new ArrayList<>();
        String sql = "select * from DetallesFactura";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura factu = new Factura();
                factu.setIdfactura(rs.getInt("FacturaID"));
                factu.setIdcliente(rs.getInt("ClienteID"));
                factu.setFechafactura(rs.getString("FechaFactura"));
                factu.setIdservicio(rs.getInt("ServicioID"));
                factu.setCantidad(rs.getInt("Cantidad"));
                factu.setPrecioUnitario(rs.getDouble("PrecioUnitario"));
                factu.setTotal(rs.getDouble("Total"));
                list.add(factu);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Factura list(int idfactura) {
        String sql = "select * from DetallesFactura where FacturaID=" + idfactura;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                factu.setIdfactura(rs.getInt("FacturaID"));
                factu.setIdcliente(rs.getInt("ClienteID"));
                factu.setFechafactura(rs.getString("FechaFactura"));
                factu.setIdservicio(rs.getInt("ServicioID"));
                factu.setCantidad(rs.getInt("Cantidad"));
                factu.setPrecioUnitario(rs.getDouble("PrecioUnitario"));
                factu.setTotal(rs.getDouble("Total"));
            }
        } catch (Exception e) {
        }
        return factu;
    }

    @Override
    public boolean agregar(Factura factu) {
        String sqlDetalles = "INSERT INTO DetallesFactura (ClienteID, FechaFactura, ServicioID, Cantidad, PrecioUnitario, Total)values(?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlDetalles);
            ps.setInt(1, factu.getIdcliente());
            ps.setString(2, factu.getFechafactura());
            ps.setInt(3, factu.getIdservicio());
            ps.setInt(4, factu.getCantidad());
            ps.setDouble(5, factu.getPrecioUnitario());
            ps.setDouble(6, factu.getTotal());
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public boolean editar(Factura factu) {
        String sqlDetalles = "UPDATE DetallesFactura SET ClienteID=?,FechaFactura=?,ServicioID=?,Cantidad=?,PrecioUnitario=?,Total=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlDetalles);
            ps.setInt(1, factu.getIdcliente());
            ps.setString(2, factu.getFechafactura());
            ps.setInt(3, factu.getIdservicio());
            ps.setInt(4, factu.getCantidad());
            ps.setDouble(5, factu.getPrecioUnitario());
            ps.setDouble(6, factu.getTotal());
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public boolean eliminar(int idfactura) {
        String sql = "delete from detallesfactura where FacturaID=" + idfactura;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
