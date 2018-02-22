/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabajo_hoja_de_vida.rnegocio.dao.ICurso;
import trabajo_hoja_de_vida.rnegocio.dao.ICursoMateria;
import trabajo_hoja_de_vida.rnegocio.dao.IMateria;
import trabajo_hoja_de_vida.rnegocio.entidades.Curso;
import trabajo_hoja_de_vida.rnegocio.entidades.Curso_Materia;
import trabajo_hoja_de_vida.rnegocio.entidades.Materia;
import trabajo_hoja_de_vida.rnegocio.impl.CursoImpl;
import trabajo_hoja_de_vida.rnegocio.impl.Curso_MateriaImpl;
import trabajo_hoja_de_vida.rnegocio.impl.MateriaImpl;

/**
 *
 * @author Usuario
 */
public class FrmNuevoCurso_Materia extends JFrame{
    
     List<Curso> lstCurso;
    JComboBox<Curso> cmbCurso;
    List<Materia> lstMateria;
    JComboBox<Materia> cmbMateria;
    JLabel titulo;
    JLabel Curso_Materia;
    JLabel CodigoC;
    JLabel CodigoM;

    

    JTextField txtCurso_Materia;
    JTextField txtCodigoC;
    JTextField txtCodigoM;
    

    JComboBox cmbCodigoC;
    JComboBox cmbCodigoM;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public FrmNuevoCurso_Materia() {

        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo = new JLabel("DATOS CURSO MATERIA");

        Curso_Materia = new JLabel("CODIGO CURSO Y MATERIA ");

        CodigoC = new JLabel("Codigo del curso");

        CodigoM = new JLabel("Codigoo de la materia");

        

        txtCurso_Materia = new JTextField();
        txtCodigoC = new JTextField();
        txtCodigoM= new JTextField();
       

        CargarCurso();
        CargarMateria ();
        cmbCurso = new JComboBox(lstCurso.toArray());
        cmbMateria= new JComboBox(lstMateria.toArray());
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo, BorderLayout.NORTH);
        pnlcentral.add(Curso_Materia);
        pnlcentral.add(cmbCurso);
        pnlcentral.add(CodigoC);
        pnlcentral.add(cmbCodigoM);
        pnlcentral.add(CodigoM);
        
        

        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);
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
        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {

        FrmNuevoCurso_Materia frmMenu = new FrmNuevoCurso_Materia();
        frmMenu.setVisible(true);

    }
    public void btnAceptarActionListener(ActionEvent e) {
        
        ICursoMateria cursomateriaDao = new Curso_MateriaImpl();

        try {

            Curso_Materia cm = new Curso_Materia();
            cm.setCodigoC((Curso) cmbCurso.getSelectedItem());    
            cm.setCodigoM((Materia) cmbMateria.getSelectedItem());  
            cm.setCurso_Materia(Integer.parseInt(txtCurso_Materia.getText()));
//            cm.setCodigoC((Curso) cmbCodigoC.getSelectedItem());           
//            cm.setCodigoM((Materia) cmbCodigoM.getSelectedItem());  
                   
            if (cursomateriaDao.insertar(cm) > 0) {
                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR !! " + ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void CargarCurso() {
        ICurso cursoDao = new CursoImpl();
        try {
            lstCurso = cursoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

}


    private void CargarMateria() {
     IMateria materiaDao = new MateriaImpl();
        try {
            lstMateria = materiaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
}
    
}
