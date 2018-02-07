package trabajo_hoja_de_vida.rnegocio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajo_hoja_de_vida.accesodatos.*;
import trabajo_hoja_de_vida.rnegocio.dao.IDeclaracion;
import trabajo_hoja_de_vida.rnegocio.entidades.Declaracion;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;

/**
 *
 * @author Usuario
 */
public class DeclaracionImpl implements IDeclaracion {

    @Override
    public int insertar(Declaracion declaracion) throws Exception {
     
        int numFilasAfectadas = 0;
        String sql = "insert into Declaracion  values "
                + "(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, declaracion.getDocente()));
        lstPar.add(new Parametro(2, declaracion.getDescripcion()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;    
        
    }

    @Override
    public int modificar(Declaracion declaracion) throws Exception {
      
        int numFilasAfectadas = 0;
        String sql = "UPDATE declaracion"
                + "   SET Codigo_docente=?, descripcion=? "
                + " where Codigo_docente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, declaracion.getDocente()));
        lstPar.add(new Parametro(2, declaracion.getDescripcion()));
     
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
        
    }

    @Override
    public int eliminar(Declaracion declaracion) throws Exception {
        
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM declaracion  where Codigo_docente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, declaracion.getDocente()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Declaracion obtener(int Codigo_docente) throws Exception {
        
        Declaracion declaracion = null;
        String sql = "SELECT * FROM declaracion where Codigo_docente=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, Codigo_docente));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
               
                declaracion = new Declaracion();
                declaracion.setDocente(docente(1));
                declaracion.setDescripcion(rst.getString(2));
                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return declaracion;    
        
    }

    @Override
    public List<Declaracion> obtener() throws Exception {
       
        List<Declaracion> lista = new ArrayList<>();;
        String sql = "SELECT * FROM declaracion ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Declaracion declaracion = null;
            while (rst.next()) {
                declaracion = new Declaracion();
                declaracion.setDocente(docente(1));
                declaracion.setDescripcion(rst.getString(2));
             

                lista.add(declaracion);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return lista;
        
    }

    private Docente docente(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

   