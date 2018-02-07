/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.entidades;

/**
 *
 * @author Usuario
 */
public class Idioma_Docente {
    
    private Docente docente;
    private Idioma idioma;
    private String hablado;
    private String escrito;
    private String comprension;

    public Idioma_Docente() {
    }

    public Idioma_Docente(Docente docente, Idioma idioma, String hablado, String escrito, String comprension) {
        this.docente = docente;
        this.idioma = idioma;
        this.hablado = hablado;
        this.escrito = escrito;
        this.comprension = comprension;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String getHablado() {
        return hablado;
    }

    public void setHablado(String hablado) {
        this.hablado = hablado;
    }

    public String getEscrito() {
        return escrito;
    }

    public void setEscrito(String escrito) {
        this.escrito = escrito;
    }

    public String getComprension() {
        return comprension;
    }

    public void setComprension(String comprension) {
        this.comprension = comprension;
    }

    
    
    
    
    
}
