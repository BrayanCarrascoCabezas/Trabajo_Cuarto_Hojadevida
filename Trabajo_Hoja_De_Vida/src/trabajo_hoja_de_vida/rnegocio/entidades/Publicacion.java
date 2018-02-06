
package trabajo_hoja_de_vida.rnegocio.entidades;


public class Publicacion {
    
    private int Cod_publicacion;
    private Docente docente;
    private String titulo;
    private String editorial;
    private String año; 

    public Publicacion() {
    }

    public Publicacion(int Cod_publicacion, Docente docente, String titulo, String editorial, String año) {
        this.Cod_publicacion = Cod_publicacion;
        this.docente = docente;
        this.titulo = titulo;
        this.editorial = editorial;
        this.año = año;
    }

    public int getCod_publicacion() {
        return Cod_publicacion;
    }

    public void setCod_publicacion(int Cod_publicacion) {
        this.Cod_publicacion = Cod_publicacion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}
