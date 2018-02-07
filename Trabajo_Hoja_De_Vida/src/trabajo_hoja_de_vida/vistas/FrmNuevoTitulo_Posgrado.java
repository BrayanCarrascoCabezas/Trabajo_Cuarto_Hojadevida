
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
public class FrmNuevoTitulo_Posgrado extends JFrame{
    
    List<Docente> lstDocentes;
    JComboBox<Docente> cmbDocente;
     JLabel titulo0;
    JLabel cod_Docente;
    JLabel cod_Posgrado;
    JLabel pais;
    JLabel titulo_posgrado;
    JLabel universidad;
    JTextField txcod_Docente;
    JTextField txcod_Posgrado;
    JTextField txpais;
    JTextField txtTitulo_posgrdao;
    JTextField txtuniversidad;
    JComboBox cmbDocentes;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;
    public FrmNuevoTitulo_Posgrado(){
    this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS TITULO POSGRADO");

        cod_Docente = new JLabel("CODIGO DOCENTE ");

        cod_Posgrado= new JLabel("CODIGO DEL TITULO");

        pais = new JLabel("PAIS");

         titulo_posgrado= new JLabel("NOMBRE DEL TITULO");

        universidad = new JLabel("NOMBRE DE LA UNIVERSIDAD");
          txcod_Docente = new JTextField();
        txcod_Posgrado = new JTextField();
        txpais = new JTextField();
        txtTitulo_posgrdao = new JTextField();
        txtuniversidad = new JTextField();

        CargarDocente();
        cmbDocentes = new JComboBox(lstDocentes.toArray());
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(cod_Docente);
        pnlcentral.add(cmbDocentes);
        pnlcentral.add(cod_Posgrado);
        pnlcentral.add(txcod_Posgrado);
        pnlcentral.add(pais);
        pnlcentral.add(txpais);
        pnlcentral.add(titulo_posgrado);
        pnlcentral.add(txtTitulo_posgrdao);
        pnlcentral.add(universidad);
        pnlcentral.add(txtuniversidad);
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
        ITitulo_Posgrado estDao = new Titulo_PosgradoImpl();

        try {

            Titulo_Posgrado est = new Titulo_Posgrado();
            est.setDocente((Docente) cmbDocente.getSelectedItem());           
            est.setCodTitulo_posgrado(Integer.parseInt(txcod_Posgrado.getText()));
            est.setPais(txpais.getText());        
            est.setTitulo_posgrado(txtTitulo_posgrdao.getText());
            est.setUniversidad(txtuniversidad.getText());          
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

