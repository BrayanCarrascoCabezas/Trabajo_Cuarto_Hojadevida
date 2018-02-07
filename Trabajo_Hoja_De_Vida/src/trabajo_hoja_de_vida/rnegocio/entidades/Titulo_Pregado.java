/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.entidades;

import java.util.*;

/**
 *
 * @author Davidssito Campos
 */
public class Titulo_Pregado {
    private int codTituloPre;
    private Docente docente;
    private String pais;
    private String titulo_pregado;
    private String universidad;

    public Titulo_Pregado() {
    }

    public Titulo_Pregado(int codTituloPre, Docente docente, String pais, String titulo_pregado, String universidad) {
        this.codTituloPre = codTituloPre;
        this.docente = docente;
        this.pais = pais;
        this.titulo_pregado = titulo_pregado;
        this.universidad = universidad;
    }

    public int getCodTituloPre() {
        return codTituloPre;
    }

    public void setCodTituloPre(int codTituloPre) {
        this.codTituloPre = codTituloPre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTitulo_pregado() {
        return titulo_pregado;
    }

    public void setTitulo_pregado(String titulo_pregado) {
        this.titulo_pregado = titulo_pregado;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
}
