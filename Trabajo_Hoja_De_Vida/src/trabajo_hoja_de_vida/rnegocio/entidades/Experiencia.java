
package trabajo_hoja_de_vida.rnegocio.entidades;

/**
 *
 * @author CRISTIAN
 */
public class Experiencia {
     private int CodigoE;
    private Docente docente;
    private int años;
    private String lugar;
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia(int CodigoE, Docente docente, int años, String lugar, String descripcion) {
        this.CodigoE = CodigoE;
        this.docente = docente;
        this.años = años;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigoE() {
        return CodigoE;
    }

    public void setCodigoE(int CodigoE) {
        this.CodigoE = CodigoE;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    @Override
    public String toString() {
        return descripcion; 
    }
}

