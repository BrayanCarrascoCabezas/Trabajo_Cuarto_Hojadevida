
package trabajo_hoja_de_vida.rnegocio.impl;
import java.util.*;
import java.sql.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.accesodatos.*;

public class Exp_DocenteImpl implements IExp_Docente{
    
    @Override
    public int insertar(Exp_Docente exp_exp_docenteente) throws Exception {
        int nFilas = 0;
        String csql = "INSERT INTO Exp_Docente (Codigo_Ex_D, codigoE, cod_Curso_Materia, institucion, fechainicio, fechafinal) VALUES (?,?,?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, exp_exp_docenteente.getCodigo_Ex_D()));
        lstP.add(new Parametro(2, exp_exp_docenteente.getExperiencia().getCodigoE()));
        lstP.add(new Parametro(3, exp_exp_docenteente.getCursomateria().getCurso_Materia()));
        lstP.add(new Parametro(4, exp_exp_docenteente.getInstitucion()));
        lstP.add(new Parametro(5, exp_exp_docenteente.getFechainicio()));
        lstP.add(new Parametro(6, exp_exp_docenteente.getFechafinal()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            nFilas = con.ejecutaComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public int modificar(Exp_Docente exp_exp_docenteente) throws Exception {
        int nFilas=0;
        String csql="UPDATE Exp_Docente SET Codigo_Ex_D=?,  codigoE=?, cod_Curso_Materia=?, institucion=?, fechainicio=?, fechafinal=? Where Codigo_Ex_D=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, exp_exp_docenteente.getCodigo_Ex_D()));
        lstPar.add(new Parametro(2, exp_exp_docenteente.getExperiencia().getCodigoE()));
        lstPar.add(new Parametro(3, exp_exp_docenteente.getCursomateria().getCurso_Materia()));
        lstPar.add(new Parametro(4, exp_exp_docenteente.getInstitucion()));
        lstPar.add(new Parametro(5, exp_exp_docenteente.getFechainicio()));
        lstPar.add(new Parametro(6, exp_exp_docenteente.getFechafinal()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            nFilas=con.ejecutaComando(csql, lstPar); 
        } catch (Exception e) {
            System.out.println("Error de modificacion: "+e.getMessage());
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public int eliminar(Exp_Docente exp_exp_docenteente) throws Exception {
        int nFilas=0;
        String csql="DELETE FROM Exp_Docente Where Codigo_Ex_D=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, exp_exp_docenteente.getCodigo_Ex_D()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            nFilas=con.ejecutaComando(csql, lstPar); 
        } catch (Exception e) {
            System.out.println("Error de Eliminacionn: "+e.getMessage());
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public Exp_Docente obtener(int codigo) throws Exception {
        Exp_Docente exp_docente = null;
        String csql = "SELECT codExpD, codE, cod_Curso_Materia, institucion, fechainicio, fechafinal FROM Exp_Docente Where codExpD=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        IExperiencia expDao=new ExperienciaImpl();
        Experiencia exp=null;
        ICursoMateria curDao=new Curso_MateriaImpl();
        Curso_Materia cur=null;
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(csql, lstPar);
            while (rst.next()) {
                exp_docente=new Exp_Docente();
                exp_docente.setCodigo_Ex_D(rst.getInt(1));
                exp=expDao.obtener(rst.getInt(2));
                exp_docente.setExperiencia(exp);
                exp=expDao.obtener(rst.getInt(3));
                exp_docente.setCursomateria(cur);
                exp_docente.setInstitucion(rst.getString(4));
                exp_docente.setFechainicio(rst.getDate(5));
                exp_docente.setFechafinal(rst.getDate(6));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return exp_docente;
    }

    @Override
    public ArrayList<Exp_Docente> obtener() throws Exception {
        ArrayList<Exp_Docente> exp_docentes = new ArrayList<>();
        IExperiencia expDao=new ExperienciaImpl();
        Experiencia exp=null;
        ICursoMateria curDao=new Curso_MateriaImpl();
        Curso_Materia cur=null;
        String csql="SELECT Codigo_Ex_D, codigoE, cod_Curso_Materia, institucion, fechainicio, fechafin from Exp_Docente";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutaQuery(csql, null);
            Exp_Docente exp_docente=null;
            while(rst.next()){
                exp_docente=new Exp_Docente();
                exp_docente.setCodigo_Ex_D(rst.getInt(1));
                exp=expDao.obtener(rst.getInt(2));
                exp_docente.setExperiencia(exp);
                exp=expDao.obtener(rst.getInt(3));
                exp_docente.setCursomateria(cur);
                exp_docente.setInstitucion(rst.getString(4));
                exp_docente.setFechainicio(rst.getDate(5));
                exp_docente.setFechafinal(rst.getDate(6));
                exp_docentes.add(exp_docente);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return exp_docentes;
    }
}
