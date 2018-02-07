
package trabajo_hoja_de_vida.vistas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Mishell
 */
public class FrmNuevaExpCapacitador extends JFrame{
    ArrayList<Experiencia> lstExp;
    JComboBox<Experiencia> cmbExp;
    ArrayList<Curso_Seminario> lstCurSem;
    JComboBox<Curso_Seminario> cmbCurSem;
    JLabel Titulo;
    JLabel codigoEC;
    JLabel codigoExp;
    JLabel codigoCurSem;
    JLabel entidades;
    JLabel fecha_inicio;
    JLabel fecha_final;
    JTextField txtcodE;
    JTextField txtentidades;
    JTextField txtfecha_Inicio;
    JTextField txtfecha_Final;
    JButton btnAceptar;
    JButton btnLimpiar;
    JPanel pnlSup;
    JPanel pnlCental;
    JPanel pnlPie;

    public FrmNuevaExpCapacitador() {
        this.setSize(420,270);
        this.setLayout(new BorderLayout());
        pnlSup=new JPanel(new FlowLayout());
        Titulo=new JLabel("Experiencia como Capacitador");
        Titulo.setFont(new Font("Arial Black", 0, 20));
        pnlSup.add(Titulo);
        pnlSup.setAlignmentX(CENTER_ALIGNMENT);
        this.add(pnlSup,BorderLayout.NORTH);
        pnlCental=new JPanel(new GridLayout(6, 2));
        codigoEC=new JLabel("Codigo: ");
        txtcodE=new JTextField("");
        codigoExp=new JLabel("Experiencia: ");
        lstExp=new ArrayList<Experiencia>();
        cargarExperiencias();
        cmbExp=new JComboBox(lstExp.toArray());
        codigoCurSem=new JLabel("Cursos/Seminarios: ");
        lstCurSem=new ArrayList<Curso_Seminario>();
        cargarCursosSeminarios();
        cmbCurSem=new JComboBox(lstCurSem.toArray());
        entidades=new JLabel("Entidades: ");
        txtentidades=new JTextField("");
        fecha_inicio=new JLabel("Fecha de Inicio: ");
        txtfecha_Inicio=new JTextField("");
        fecha_final=new JLabel("Fecha de Fin: ");
        txtfecha_Final=new JTextField("");
        pnlCental.add(codigoEC);
        pnlCental.add(txtcodE);
        pnlCental.add(codigoExp);
        pnlCental.add(cmbExp);
        pnlCental.add(codigoCurSem);
        pnlCental.add(cmbCurSem);
        pnlCental.add(entidades);
        pnlCental.add(txtentidades);
        pnlCental.add(fecha_inicio);
        pnlCental.add(txtfecha_Inicio);
        pnlCental.add(fecha_final);
        pnlCental.add(txtfecha_Final);
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

        FrmNuevaExpCapacitador frmExpCap = new FrmNuevaExpCapacitador();
        frmExpCap.setVisible(true);

    }

    private void cargarExperiencias() {
        IExperiencia curDao = new ExperienciaImpl();
        try {
            lstExp = (ArrayList<Experiencia>) curDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cargarCursosSeminarios() {
        ICusro_Seminario curDao = new Curso_SeminarioImpl();
        try {
            lstCurSem = curDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void btnAceptarActionListener(ActionEvent e) {
        try {
            Exp_Capacitador nCapacitador = new Exp_Capacitador();
            nCapacitador.setCodigo_EC(Integer.parseInt(txtcodE.getText()));
//            nCapacitador.setExperiencia(cmbExp.getSelectedIndex());
//            nCapacitador.setCursoSeminario(codigoCurSem.);
            nCapacitador.setEntidades(txtentidades.getText());
            DateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
            try {
                nCapacitador.setFecha_inicio(formatoFecha.parse(txtfecha_Inicio.getText()));
                nCapacitador.setFecha_final(formatoFecha.parse(txtfecha_Final.getText()));
            } catch (Exception er) {
                JOptionPane.showMessageDialog(this, "ERROR DE FECHA!!"+er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO FALLIDO!!"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
