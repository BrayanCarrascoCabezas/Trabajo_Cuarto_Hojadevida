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
public class Curso_Materia {
    private int Curso_Materia;
    private Curso CodigoC;
    private Materia CodigoM;

    public Curso_Materia() {
    }

    public Curso_Materia(int Curso_Materia, Curso CodigoC, Materia CodigoM) {
        this.Curso_Materia = Curso_Materia;
        this.CodigoC = CodigoC;
        this.CodigoM = CodigoM;
    }

    public int getCurso_Materia() {
        return Curso_Materia;
    }

    public void setCurso_Materia(int Curso_Materia) {
        this.Curso_Materia = Curso_Materia;
    }

    public Curso getCodigoC() {
        return CodigoC;
    }

    public void setCodigoC(Curso CodigoC) {
        this.CodigoC = CodigoC;
    }

    public Materia getCodigoM() {
        return CodigoM;
    }

    public void setCodigoM(Materia CodigoM) {
        this.CodigoM = CodigoM;
    }

}
