
package trabajo_hoja_de_vida.vistas;

import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import javax.swing.*;
import java.util.*;

public class FrmNuevoExp_Docente extends JInternalFrame{
    ArrayList<Experiencia> lstExp;
    JComboBox<Experiencia> cmbExp;
    
//    ArrayList<Curso_Materia> lstCur;
//    JComboBox<Curso_Materia> cmbCur;
    
    JLabel Titulo;
    JLabel Cod_Exp_D;
    JLabel codigoE;
    JLabel codigoCursoM;
    JLabel institucion;
    JLabel fechainicio;
    JLabel fechafin;
    
    JTextField txtCod_Exp_D;
    JTextField txtInstitucion;
    JTextField txtfechainicio;
    JTextField txtfechafinal;
    
    JButton btnAceptar;
    JButton btnLimpiar;
    JPanel pnlSup;
    JPanel pnlCental;
    JPanel pnlPie;

    public FrmNuevoExp_Docente() {
        this.setSize(420,270);
        this.setLayout(new BorderLayout());
        pnlSup=new JPanel(new FlowLayout());
        Titulo=new JLabel("Experiencia como Docente");
        Titulo.setFont(new Font("Arial Black", 0, 20));
        pnlSup.add(Titulo);
        pnlSup.setAlignmentX(CENTER_ALIGNMENT);
        this.add(pnlSup,BorderLayout.NORTH);
        pnlCental=new JPanel(new GridLayout(6, 2));
        Cod_Exp_D=new JLabel("Codigo: ");
        txtCod_Exp_D=new JTextField("");
        codigoE=new JLabel("Experiencia: ");
        lstExp=new ArrayList<Experiencia>();
        cargarExperiencias();
        cmbExp=new JComboBox(lstExp.toArray());
//        codigoCursoM=new JLabel("Cursos/Materias: ");
//        lstCur=new ArrayList<Curso_Materia>();
//        cargarCursosMaterias();
//        cmbCur=new JComboBox(lstCur.toArray());
        institucion=new JLabel("Nombre Institucion: ");
        txtInstitucion=new JTextField("");
        fechainicio=new JLabel("Fecha de Inicio: ");
        txtfechainicio=new JTextField("");
        fechafin=new JLabel("Fecha Fin: ");
        txtfechafinal=new JTextField("");
        pnlCental.add(Cod_Exp_D);
        pnlCental.add(txtCod_Exp_D);
        pnlCental.add(codigoE);
        pnlCental.add(cmbExp);
//        pnlCental.add(codigoCursoM);
//        pnlCental.add(cmbCur);
        pnlCental.add(institucion);
        pnlCental.add(txtInstitucion);
        pnlCental.add(fechainicio);
        pnlCental.add(txtfechainicio);
        pnlCental.add(fechafin);
        pnlCental.add(txtfechafinal);
        pnlCental.setAlignmentX(CENTER_ALIGNMENT);
        pnlCental.setAlignmentY(CENTER_ALIGNMENT);
        pnlPie=new JPanel(new GridLayout(1, 2));
        btnAceptar=new JButton("Aceptar");
        btnLimpiar=new JButton("Limpiar");
        pnlPie.add(btnAceptar);
        pnlPie.add(btnLimpiar);
           btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error " + ex.getMessage());
                }
            }
        });
        this.add(pnlSup,BorderLayout.NORTH);
        this.add(pnlCental,BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {

        FrmNuevoExp_Docente frmExp_Doc = new FrmNuevoExp_Docente();
        frmExp_Doc.setVisible(true);

    }

    private void cargarExperiencias() {
        IExperiencia curDao = new ExperienciaImpl();
        try {
            lstExp = (ArrayList<Experiencia>) curDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
//    private void cargarCursosMaterias() {
//        ICurso_Materia curDao = new Curso_MateriaImpl();
//        try {
//            lstCur = (ArrayList<Curso_Materia>) curDao.obtener();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
    
    public void btnAceptarActionListener(ActionEvent e) {
        IExp_Docente expDoc = new Exp_DocenteImpl();
        try {
            Exp_Docente nDocente = new Exp_Docente();
            nDocente.setCodigo_Ex_D(Integer.parseInt(txtCod_Exp_D.getText()));
            nDocente.setExperiencia((Experiencia) cmbExp.getSelectedItem());
                if (expDoc.insertar(nDocente) > 0) {
                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
//            nDocente.setCurso_Materia((Curso_Materia) cmbCur.getSelectedItem());
//                if (expDoc.insertar(nDocente) > 0) {
//                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
//
//                } else {
//                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
//                }
            nDocente.setInstitucion(txtInstitucion.getText());
            DateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
            try {
                nDocente.setFechainicio(formatoFecha.parse(txtfechainicio.getText()));
                nDocente.setFechafinal(formatoFecha.parse(txtfechafinal.getText()));
            } catch (Exception er) {
                JOptionPane.showMessageDialog(this, "ERROR DE FECHA!!"+er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO FALLIDO!!"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
