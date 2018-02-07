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
import trabajo_hoja_de_vida.rnegocio.dao.IPublicacion;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.entidades.Publicacion;

/**
 *
 * @author Usuario
 */
public class PublicacionImpl implements IPublicacion{
    
     @Override
    public int insertar(Publicacion publicacion) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into publicacion  values "
                +"(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, publicacion.getCod_publicacion()));
        lstPar.add(new Parametro(2, publicacion.getDocente().getCod_docente()));
        lstPar.add(new Parametro(3, publicacion.getEditorial()));
        lstPar.add(new Parametro(4, publicacion.getTitulo()));
        lstPar.add(new Parametro(5, publicacion.getAño()));
       
        
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
    public int modificar(Publicacion publicacion) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE publicacion"
                + "   SET =?, Cod_publicacion=?, cod_docente=?, titulo=?,editorial=?, "
                +"año=?, where Codigo_publicacion=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, publicacion.getCod_publicacion()));
        lstPar.add(new Parametro(2, publicacion.getDocente().getCod_docente()));
        lstPar.add(new Parametro(3, publicacion.getEditorial()));
        lstPar.add(new Parametro(4, publicacion.getTitulo()));
        lstPar.add(new Parametro(5, publicacion.getAño()));
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
    public int eliminar(Publicacion publicacion) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM publicacion  where Codigo_publicacion=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, publicacion.getCod_publicacion()));       
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
    public Publicacion obtener(int codigo) throws Exception {
        Publicacion publicacion = null;
        String sql = "SELECT Codigo_publicacion,cod_docente, Editorial, titulo, año, "
                + " FROM publicacion where Codigo_publicacion=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                publicacion = new Publicacion();
                publicacion.setCod_publicacion(rst.getInt(1));
                IDocente docenteDao = new DocenteImpl();
                Docente docente = docenteDao.obtener(rst.getInt(2));
                publicacion.setDocente(docente);
                publicacion.setEditorial(rst.getString(3));
                publicacion.setTitulo(rst.getString(4));
                publicacion.setAño(rst.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return publicacion;
    }

    @Override
    public List<Publicacion> obtener() throws Exception {
        List<Publicacion> lista = new ArrayList<>();
         String sql = "SELECT Codigo_publicacion,cod_docente, editorial, titulo, año, "
                + "   FROM publicacion ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Publicacion publicacion=null;
            while (rst.next()) {
                publicacion = new Publicacion();
                publicacion.setCod_publicacion(rst.getInt(1));
                IDocente docenteDao = new DocenteImpl();
                Docente docente = docenteDao.obtener(rst.getInt(2));
                publicacion.setDocente(docente);
                publicacion.setEditorial(rst.getString(3));
                publicacion.setTitulo(rst.getString(4));
                publicacion.setAño(rst.getString(5));
                lista.add(publicacion);
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
