
package trabajo_hoja_de_vida.rnegocio.entidades;

/**
 *
 * @author Mishell
 */
import java.util.*;
public class Exp_Capacitador {
    private int codigo_EC;
    private Experiencia experiencia;
    private Curso_Seminario cursoSeminario;
    private String Entidades;
    private Date fecha_inicio;
    private Date fecha_final;

    public Exp_Capacitador() {
    }

    public Exp_Capacitador(int codigo_EC, Experiencia experiencia, Curso_Seminario cursoSeminario, String Entidades, Date fecha_inicio, Date fecha_final) {
        this.codigo_EC = codigo_EC;
        this.experiencia = experiencia;
        this.cursoSeminario = cursoSeminario;
        this.Entidades = Entidades;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
    }

    @Override
    public String toString(){
        return Entidades;
    }

    public int getCodigo_EC() {
        return codigo_EC;
    }

    public void setCodigo_EC(int codigo_EC) {
        this.codigo_EC = codigo_EC;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    public Curso_Seminario getCursoSeminario() {
        return cursoSeminario;
    }

    public void setCursoSeminario(Curso_Seminario cursoSeminario) {
        this.cursoSeminario = cursoSeminario;
    }

    public String getEntidades() {
        return Entidades;
    }

    public void setEntidades(String Entidades) {
        this.Entidades = Entidades;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }
}
