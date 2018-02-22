
package trabajo_hoja_de_vida.rnegocio.entidades;
import java.util.*;
public class Exp_Docente {
    private int Codigo_Ex_D;
    private Experiencia experiencia;
    private Curso_Materia cursomateria;
    private String institucion;
    private Date fechainicio;
    private Date fechafinal;

    public Exp_Docente() {
    }

    public Exp_Docente(int Codigo_Ex_D, Experiencia experiencia, Curso_Materia cursomateria, String institucion, Date fechainicio, Date fechafinal) {
        this.Codigo_Ex_D = Codigo_Ex_D;
        this.experiencia = experiencia;
        this.cursomateria = cursomateria;
        this.institucion = institucion;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
    }

    public int getCodigo_Ex_D() {
        return Codigo_Ex_D;
    }

    public void setCodigo_Ex_D(int Codigo_Ex_D) {
        this.Codigo_Ex_D = Codigo_Ex_D;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    public Curso_Materia getCursomateria() {
        return cursomateria;
    }

    public void setCursomateria(Curso_Materia cursomateria) {
        this.cursomateria = cursomateria;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    
    
    
}
