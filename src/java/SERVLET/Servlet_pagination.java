package SERVLET;

import MODELO.Modelo_pagination;
import UTIL.util_pagination;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//JSON
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "Servlet_pagination", urlPatterns = {"/Servlet_pagination"})
public class Servlet_pagination extends HttpServlet {
    
    util_pagination uP = new util_pagination();
    Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType( "text/html; charset=iso-8859-1" );
        PrintWriter out = response.getWriter();
        
        try {
            List<Modelo_pagination> lista = uP.listarProducto();
            JSONObject objJ = new JSONObject();
            JSONArray con = new JSONArray();
            Modelo_pagination mObj = null;
            /*segunda peticion*/
            for(Object objTmp : lista){
                Modelo_pagination mp = (Modelo_pagination) objTmp;
                mObj = new Modelo_pagination(mp.getId_p(), mp.getNo_p());
                con.add(mObj);
            }
            objJ.put("Registros", uP.totalLista());
            con.add(objJ);
            out.println(gson.toJson(con));
            out.flush();

        } catch (Exception e) {
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
