package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
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
import java.util.Date;

public class FrmNuevoCursoSeminario extends JInternalFrame {

    List<Docente> lstDocentes;
    JComboBox<Docente> cmbDocente;
    JLabel titulo0;
    JLabel cod_Docente;
    JLabel cod_CursoSeminario;

    JLabel nombreCS;

    JLabel horas;

    JLabel ubicacion;

    JLabel descripcion;

    JTextField txcod_Docente;
    JTextField txcod_CursoSeminario;
    JTextField txnombreCS;
    JTextField txhoras;
    JTextField txubicacion;
    JTextField txdescripcion;

    JComboBox cmbDocentes;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public FrmNuevoCursoSeminario() {

        this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();
        this.setClosable(true);
        pnlcentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS CURSO SEMINARIOS");

        cod_Docente = new JLabel("CODIGO ESTUDIANTE");

        cod_CursoSeminario = new JLabel("NUMERO CEDULA");

        nombreCS = new JLabel("NOMBRE");

        horas = new JLabel("APELLIDO");

        ubicacion = new JLabel("FECHA NACIMIENTO");

        descripcion = new JLabel("FECHA INGRESO");

        txcod_Docente = new JTextField();
        txcod_CursoSeminario = new JTextField();
        txnombreCS = new JTextField();
        txhoras = new JTextField();
        txubicacion = new JTextField();
        txdescripcion = new JTextField();

        CargarDocente();
        cmbDocentes = new JComboBox(lstDocentes.toArray());
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(cod_Docente);
        pnlcentral.add(cmbDocentes);
        pnlcentral.add(cod_CursoSeminario);
        pnlcentral.add(txcod_CursoSeminario);
        pnlcentral.add(nombreCS);
        pnlcentral.add(txnombreCS);
        pnlcentral.add(horas);
        pnlcentral.add(txhoras);
        pnlcentral.add(ubicacion);
        pnlcentral.add(txubicacion);
        pnlcentral.add(descripcion);
        pnlcentral.add(txdescripcion);

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
        this.add(titulo0, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {

        FrmNuevoCursoSeminario frmMenu = new FrmNuevoCursoSeminario();
        frmMenu.setVisible(true);

    }

    public void CargarDocente() {

        IDocente curDao = new DocenteImpl();
        try {
            lstDocentes = curDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void btnAceptarActionListener(ActionEvent e) {
        ICusro_Seminario estDao = new Curso_SeminarioImpl();

        try {

            Curso_Seminario est = new Curso_Seminario();
            est.setDocente((Docente) cmbDocente.getSelectedItem());           
            est.setCod_CursoSeminario(Integer.parseInt(txcod_CursoSeminario.getText()));
            est.setNombreCS(txnombreCS.getText());
            est.setHoras(Integer.parseInt(txhoras.getText()));          
            est.setUbicacion(txubicacion.getText());
            est.setDescripcion(txdescripcion.getText());          
            if (estDao.insertar(est) > 0) {
                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR !! " + ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
