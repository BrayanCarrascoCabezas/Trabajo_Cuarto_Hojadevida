
package trabajo_hoja_de_vida.rnegocio.entidades;


public class Resumen {
    private Docente docente;
    private String descripcion;

    public Resumen() {
    }

    public Resumen(Docente docente, String descripcion) {
        this.docente = docente;
        this.descripcion = descripcion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
