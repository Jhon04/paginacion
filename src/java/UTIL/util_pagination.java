package UTIL;

import DAO.Conexion;
import MODELO.Modelo_pagination;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class util_pagination {
    
    Conexion cn = new Conexion();
    Connection con = cn.getConnection();
    PreparedStatement pst;
    ResultSet rs;
    
    public List listarProducto(){
        List<Modelo_pagination> lista = new ArrayList();
        try {
            pst = con.prepareStatement("call USP_LISTAR");
            rs = pst.executeQuery();
            Modelo_pagination obj;
            while(rs.next()){
                obj = new Modelo_pagination();
                obj.setId_p(rs.getInt(1));
                obj.setNo_p(rs.getString(2));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            out.println("error en metodo Marca Util Listar: " + ex.getMessage());
        }
        return lista;
    }
    
    public int totalLista(){
        int total = 0;
        try{
            pst = con.prepareStatement("call USP_TOTAL_LISTA");
            rs = pst.executeQuery();
            if(rs.next()){
                total = rs.getInt(1);
            }
        }catch(SQLException ex){
            
        }
        return total;
    }
    
}
