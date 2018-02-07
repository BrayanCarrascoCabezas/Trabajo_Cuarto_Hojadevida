/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.impl;

import trabajo_hoja_de_vida.accesodatos.*;

import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Titulo_PosgradoImpl implements ITitulo_Posgrado {
    @Override
    public int insertar(Titulo_Posgrado titulo_posgrado) throws Exception {
        int numFilasAfectadas=0;
        String sql="insert into Titulo_Posgrado(Cod_posgrado,cod_docente,pais,titulo_posgrado,universidad) values (?),(?),(?),(?),(?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, titulo_posgrado.getCodTitulo_posgrado()));
        lstPar.add(new Parametro(2, titulo_posgrado.getDocente().getCod_docente()));
        lstPar.add(new Parametro(3, titulo_posgrado.getPais()));
        lstPar.add(new Parametro(4, titulo_posgrado.getTitulo_posgrado()));
        lstPar.add(new Parametro(5, titulo_posgrado.getUniversidad()));
        
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
    public int modificar(Titulo_Posgrado titulo_posgrado) throws Exception {
         int numFilasAfectadas = 0;
        String sql = "UPDATE Titulo_Posgrado"
                + "   SET CodTitulo_Posgrado=?,cod_docente=?,pais=?,Titulo_Pregrado=?,universidad=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, titulo_posgrado.getCodTitulo_posgrado()));
        lstPar.add(new Parametro(2, titulo_posgrado.getDocente().getCod_docente()));
        lstPar.add(new Parametro(3, titulo_posgrado.getPais()));
        lstPar.add(new Parametro(4, titulo_posgrado.getTitulo_posgrado()));
        lstPar.add(new Parametro(5, titulo_posgrado.getUniversidad()));
        lstPar.add(new Parametro(6, titulo_posgrado.getCodTitulo_posgrado()));
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
    public int eliminar(Titulo_Posgrado titulo_posgrado) throws Exception {
       int numFilasAfectadas = 0;
         String sql = "DELETE FROM Titulo_Posgrado  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, titulo_posgrado.getCodTitulo_posgrado()));      
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
    public Titulo_Posgrado obtener(int codigo) throws Exception {
    Titulo_Posgrado titulo_posgrado = null;
        String sql = "SELECT Cod_Pregrado,cod_docente,pais,Titulo_Pregrado,universidad FROM Titulo_Posgrado where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                titulo_posgrado = new Titulo_Posgrado();
                titulo_posgrado.setCodTitulo_posgrado(rst.getInt(1));
                
                IDocente docenteDao = new DocenteImpl();
                Docente docente = docenteDao.obtener(rst.getInt(2));
                   
                titulo_posgrado.setPais(rst.getString(3));
                titulo_posgrado.setTitulo_posgrado(rst.getString(4));
                titulo_posgrado.setUniversidad(rst.getString(5));
                titulo_posgrado.setDocente(docente);
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return titulo_posgrado;
    }
     @Override
    public List<Titulo_Posgrado> obtener() throws Exception {
         List<Titulo_Posgrado> lista = new ArrayList<>();
         String sql = "SELECT Cod_Posgrado,cod_docente,pais,Titulo_Posgrado,universidad FROM Titulo_Posgrado ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Titulo_Posgrado titulo_posgrado=null;
            while (rst.next()) {
                titulo_posgrado = new Titulo_Posgrado();
                titulo_posgrado.setCodTitulo_posgrado(rst.getInt(1));
                IDocente docenteDao = new DocenteImpl();
                Docente docente = docenteDao.obtener(rst.getInt(2));
                titulo_posgrado.setDocente(docente);
                titulo_posgrado.setPais(rst.getString(3));
                titulo_posgrado.setTitulo_posgrado(rst.getString(4));
                titulo_posgrado.setUniversidad(rst.getString(5));
               
                lista.add(titulo_posgrado);
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
