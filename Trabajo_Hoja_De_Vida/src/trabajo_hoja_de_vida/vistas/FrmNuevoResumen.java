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
import javax.swing.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;
public class FrmNuevoResumen   extends JInternalFrame{
    
    
 List<Docente> lstDocentes;
    JComboBox<Docente> cmbDocente;
    JLabel titulo0;
    JLabel cod_Docente;
    JLabel descripcion;

    JTextField txcod_Docente;
    JTextField txdescripcion;
    JComboBox cmbDocentes;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public FrmNuevoResumen() {

        this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS DEL RESUMEN");

        cod_Docente = new JLabel("CODIGO DOCENTE");
        descripcion = new JLabel("DESCRIPCION");

        txcod_Docente = new JTextField();
        txdescripcion = new JTextField();
        
        CargarDocente();
        cmbDocentes = new JComboBox(lstDocentes.toArray());
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(cod_Docente);
        pnlcentral.add(cmbDocentes);
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

        FrmNuevoResumen frmMenu = new FrmNuevoResumen();
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
        IResumen resumenDao = new ResumenImpl();

        try {

            Resumen resum= new Resumen();
           resum.setDocente((Docente) cmbDocente.getSelectedItem());           
            resum.setDescripcion(txdescripcion.getText());          
            if (resumenDao.insertar(resum) > 0) {
                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR !! " + ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
