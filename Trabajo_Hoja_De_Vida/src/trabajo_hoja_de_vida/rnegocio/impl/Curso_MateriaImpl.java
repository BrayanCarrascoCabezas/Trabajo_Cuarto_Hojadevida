/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import trabajo_hoja_de_vida.accesodatos.Conexion;
import trabajo_hoja_de_vida.accesodatos.Parametro;
import trabajo_hoja_de_vida.rnegocio.dao.ICursoMateria;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.Curso;
import trabajo_hoja_de_vida.rnegocio.entidades.Curso_Materia;
import trabajo_hoja_de_vida.rnegocio.entidades.Materia;


/**
 *
 * @author Usuario
 */
public class Curso_MateriaImpl implements ICursoMateria{
    
     @Override
    public int insertar(Curso_Materia curso_materia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Curso_Materia(Curso_Materia, CodigoC, CodigoM )"
                + " values (?,?,?,)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, curso_materia.getCurso_Materia()));
        listParametro.add(new Parametro(2, curso_materia.getCodigoC().getCodigo()));
        listParametro.add(new Parametro(3, curso_materia.getCodigoM().getCodigo()));
        

        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Curso_Materia curso_materia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Curso_Materia(Curso_Materia, CodigoC, CodigoM )";
                
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, curso_materia.getCurso_Materia()));
        listParametro.add(new Parametro(2, curso_materia.getCodigoC().getCodigo()));
        listParametro.add(new Parametro(3, curso_materia.getCodigoM().getCodigo()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Curso_Materia curso_materia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Curso_Materia WHERE Curso_Materia=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, curso_materia.getCurso_Materia()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Curso_Materia obtener(int codigo) throws Exception {
        Curso_Materia cursomateria = null;
       
                
        String sql = "SELECT Curso_Materia, CodigoC, CodigoM  FROM Curso_Materia where Curso_Materia=?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        listadoParametros.add(new Parametro(1, cursomateria));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutaQuery(sql, listadoParametros);
            while (resultado.next()) {
                cursomateria = new Curso_Materia();
                cursomateria .setCurso_Materia(resultado.getInt(1));
                ICurso cursoDao= new CursoImpl();
                Curso curso=cursoDao.obtener(resultado.getInt(2));
                IMateria materiaDao= new MateriaImpl();
                Materia materia = materiaDao.obtener(resultado.getInt(3));
                           
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return cursomateria;
    }

    @Override
    public ArrayList<Curso_Materia> obtener() throws Exception {
        ArrayList<Curso_Materia> lista = new ArrayList<>();
        Curso_Materia cursomateria = null;
        IDocente donDao = new DocenteImpl();
        String sql = "SELECT Curso_Materia, CodigoC, CodigoM  FROM Curso_Materia";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutaQuery(sql, null);
            Curso_Materia cursosec = null;
            while (resultado.next()) {
                
                cursomateria = new Curso_Materia();
                cursomateria .setCurso_Materia(resultado.getInt(1));
                ICurso cursoDao= new CursoImpl();
                Curso curso=cursoDao.obtener(resultado.getInt(2));
                IMateria materiaDao= new MateriaImpl();
                Materia materia = materiaDao.obtener(resultado.getInt(3));
                
                lista.add(cursomateria);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return lista;
    }
    
}
