/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.impl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajo_hoja_de_vida.accesodatos.Conexion;
import trabajo_hoja_de_vida.accesodatos.Parametro;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.dao.IResumen;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.entidades.Resumen;


public class ResumenImpl  implements IResumen{
    
    
  @Override
    public int insertar(Resumen resumen) throws Exception {
         int numFilasAfectadas = 0;
        String sql = "insert into Resumen  values (?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, resumen.getDocente().getCod_docente()));
        lstPar.add(new Parametro(2, resumen.getDescripcion()));

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
    public int modificar(Resumen resumen) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Resumen"
                + "   SET cod_docente=?,descripcion=? where cod_docente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, resumen.getDocente().getCod_docente()));
        lstPar.add(new Parametro(2, resumen.getDescripcion()));

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
    public int eliminar(Resumen resumen) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Resumen  where cod_docente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, resumen.getDocente().getCod_docente()));
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
    public Resumen obtener(int cod_docente) throws Exception {

        Resumen resumen = null;
        String sql = "SELECT Cod_docente,descripcion FROM Resumen where Cod_docente=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, resumen.getDocente().getCod_docente()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                resumen = new Resumen();

                IDocente docenteDao = new DocenteImpl();
                Docente docente = docenteDao.obtener(rst.getInt(1));
                resumen.setDocente(docente);
                resumen.setDescripcion(rst.getString(2));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return resumen;
    }

    @Override
    public List<Resumen> obtener() throws Exception {
       ArrayList<Resumen> lista = new ArrayList<>();
         String sql = "SELECT * FROM Resumen ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
           Resumen resumen=null;
            while (rst.next()) {
                resumen= new Resumen();
                IDocente docenteDao = new DocenteImpl();
                Docente docente = docenteDao.obtener(rst.getInt(2));
                resumen.setDocente(docente);
                resumen.setDescripcion(rst.getString(3));
                
                lista.add(resumen);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
 }