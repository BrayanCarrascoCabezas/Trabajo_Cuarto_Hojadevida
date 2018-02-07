/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.entidades;

import java.util.*;

public class Titulo_Posgrado {
      private int codTitulo_posgrado;
    private Docente docente;
    private String pais;
    private String titulo_posgrado;
    private String universidad;

    public Titulo_Posgrado() {
    }

    public Titulo_Posgrado(int codTitulo_posgrado, Docente docente, String pais, String titulo_posgrado, String universidad) {
        this.codTitulo_posgrado = codTitulo_posgrado;
        this.docente = docente;
        this.pais = pais;
        this.titulo_posgrado = titulo_posgrado;
        this.universidad = universidad;
    }

    public int getCodTitulo_posgrado() {
        return codTitulo_posgrado;
    }

    public void setCodTitulo_posgrado(int codTitulo_posgrado) {
        this.codTitulo_posgrado = codTitulo_posgrado;
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

    public String getTitulo_posgrado() {
        return titulo_posgrado;
    }

    public void setTitulo_posgrado(String titulo_posgrado) {
        this.titulo_posgrado = titulo_posgrado;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
}
