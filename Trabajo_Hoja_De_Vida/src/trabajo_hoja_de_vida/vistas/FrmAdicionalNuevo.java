/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.impl.DocenteImpl;

/**
 *
 * @author WILCXMAC
 */
public class FrmAdicionalNuevo extends JInternalFrame{
    
    JLabel lblTitulo1,lblTitulo2;

    JLabel lblTitulo0;
   
    JTextField txtTitulo1;
        List<Docente> lstAdicional;
    JComboBox<Docente> cmbAdiconal;
    

    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmAdicionalNuevo() {
        
        this.setSize(250,160);
        this.setLayout(new BorderLayout());
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("ADICIONAL");
        
        lblTitulo1= new JLabel(" DOCENTE:");
        lblTitulo2= new JLabel("DESCRIPCION:");
       
         cargarDocentes();
         cmbAdiconal= new JComboBox(lstAdicional.toArray());
        txtTitulo1 = new JTextField(2);
       


        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblTitulo1);
        pnlCentral.add(cmbAdiconal);
        pnlCentral.add(lblTitulo2);
        pnlCentral.add(txtTitulo1);

  

        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        pnlCentral.setBackground(Color.getHSBColor(100,60,270).brighter());
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);   
        
    }
    public static void main(String[] args) {
        FrmAdicionalNuevo frmMenu= new FrmAdicionalNuevo();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        JOptionPane.showMessageDialog(this,"Proceso correcto!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
    }
    
            public void cargarDocentes() {
        try {
       IDocente estudiante=new DocenteImpl();
       lstAdicional=estudiante.obtener();
   
        } catch (Exception e) {System.out.println("ERROR"+e.getMessage());
        }

  
    }
 
}