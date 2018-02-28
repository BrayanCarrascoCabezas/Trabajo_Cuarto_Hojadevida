
package trabajo_hoja_de_vida.vistas;

import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;
import static java.awt.Component.CENTER_ALIGNMENT;
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

public class FrmNuevoExp_Directiva extends JInternalFrame{
    ArrayList<Experiencia> lstExp;
    JComboBox<Experiencia> cmbExp;
    
    JLabel Titulo;
    JLabel CodigoExp_D;
    JLabel CodigoE;
    JLabel Empresa_Institucion;
    JLabel Entidades;
    JLabel Fecha_Inicio;
    JLabel Fecha_Final;
    
    JTextField txtCodigoExp_D;
    JTextField txtFecha_Inicio;
    JTextField txtFecha_Finalal;
    
    JButton btnAceptar;
    JButton btnLimpiar;
    JPanel pnlSup;
    JPanel pnlCental;
    JPanel pnlPie;

    public FrmNuevoExp_Directiva() {
        this.setSize(420,270);
        this.setLayout(new BorderLayout());
        pnlSup=new JPanel(new FlowLayout());
        Titulo=new JLabel("Experiencia como Directivo");
        Titulo.setFont(new Font("Arial Blue", 0, 20));
        pnlSup.add(Titulo);
        pnlSup.setAlignmentX(CENTER_ALIGNMENT);
        this.add(pnlSup,BorderLayout.NORTH);
        pnlCental=new JPanel(new GridLayout(6, 2));
        CodigoExp_D=new JLabel("Codigo: ");
        txtCodigoExp_D=new JTextField("");
        CodigoE=new JLabel("Experiencia: ");
        lstExp=new ArrayList<Experiencia>();
        cargarExperiencias();
        cmbExp=new JComboBox(lstExp.toArray());
        Empresa_Institucion=new JLabel("Empresa / Institucion: ");
        Entidades=new JLabel("Nombre Entidad: ");
        Fecha_Inicio=new JLabel("Fecha de Inicio: ");
        txtFecha_Inicio=new JTextField("");
        Fecha_Final=new JLabel("Fecha Fin: ");
        txtFecha_Finalal=new JTextField("");
        pnlCental.add(CodigoExp_D);
        pnlCental.add(txtCodigoExp_D);
        pnlCental.add(CodigoE);
        pnlCental.add(cmbExp);
        pnlCental.add(Empresa_Institucion);
        pnlCental.add(Entidades);
        pnlCental.add(Fecha_Inicio);
        pnlCental.add(txtFecha_Inicio);
        pnlCental.add(Fecha_Final);
        pnlCental.add(txtFecha_Finalal);
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

        FrmNuevoExp_Directiva frmExp_Dir = new FrmNuevoExp_Directiva();
        frmExp_Dir.setVisible(true);

    }

    private void cargarExperiencias() {
        IExperiencia curDao = new ExperienciaImpl();
        try {
            lstExp = (ArrayList<Experiencia>) curDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    public void btnAceptarActionListener(ActionEvent e) {
        IExp_Directiva expDir = new Exp_DirectivaImpl();
        try {
            Exp_Directiva nDirectiva = new Exp_Directiva();
            nDirectiva.setCodigoExp_D(Integer.parseInt(txtCodigoExp_D.getText()));
            nDirectiva.setExperiencia((Experiencia) cmbExp.getSelectedItem());
                if (expDir.insertar(nDirectiva) > 0) {
                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            DateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
            try {
                nDirectiva.setFecha_Inicio((java.sql.Date) formatoFecha.parse(txtFecha_Inicio.getText()));
                nDirectiva.setFecha_Final((java.sql.Date) formatoFecha.parse(txtFecha_Finalal.getText()));
            } catch (Exception er) {
                JOptionPane.showMessageDialog(this, "ERROR DE FECHA!!"+er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO FALLIDO!!"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
