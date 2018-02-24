/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;

import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class FrmNuevoDocente extends JInternalFrame{

    JLabel lblCodigo;
    JLabel lblCedula;
    JLabel lblNombre;
    JLabel lblApellidos;
    JLabel lblFechaNac;
    JLabel lblEmail;
    JLabel lblSexo;
    JLabel lblDireccion;
    JLabel lblTelefono;
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtCedula;
    JTextField txtNombres;
    JTextField txtApellidos;
    JTextField txtFechaNac;
    JTextField txtEmail;
    JComboBox cmbSexo;
    JTextField txtDireccion;
    JTextField txtTelefono;
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoDocente() {
        this.setSize(350, 350);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(9, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Docente");
        
        lblCodigo= new JLabel("Código:");
        lblCedula= new JLabel("Cédula:");
        lblNombre= new JLabel("Nombres:");
        lblApellidos= new JLabel("Apellidos:");
        lblFechaNac= new JLabel("Fecha Nacimiento:");
        lblEmail= new JLabel("Email:");
        lblSexo= new JLabel("Sexo:");
        lblTelefono= new JLabel("Teléfono:");
        lblDireccion= new JLabel("Dirección:");
        
        txtCodigo = new JTextField(2);
        txtCedula= new JTextField(2);
        txtNombres= new JTextField(2);
        txtApellidos= new JTextField(2);
        txtFechaNac= new JTextField(2);
        txtEmail= new JTextField(2);
        cmbSexo= new JComboBox(new String[]{"masculino","femenino"});
        txtDireccion= new JTextField(2); 
        txtTelefono= new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombres);
        pnlCentral.add(lblApellidos);
        pnlCentral.add(txtApellidos);
        pnlCentral.add(lblDireccion);
        pnlCentral.add(txtDireccion);
        pnlCentral.add(lblFechaNac);
        pnlCentral.add(txtFechaNac);
        pnlCentral.add(lblEmail);
        pnlCentral.add(txtEmail);
        pnlCentral.add(lblSexo);
        pnlCentral.add(cmbSexo);
        pnlCentral.add(lblTelefono);
        pnlCentral.add(txtTelefono);
        
                
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
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoDocente frmMenu= new FrmNuevoDocente();
        frmMenu.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionEvent e){
        Docente docente = new Docente();
            IDocente docenteDao = new DocenteImpl();
            docente.setCod_docente(Integer.parseInt(txtCodigo.getText()));
            docente.setCedula(txtCedula.getText());
            docente.setNombres(txtNombres.getText());
            docente.setApellidos(txtApellidos.getText());
            docente.setDireccion(txtDireccion.getText());
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                docente.setFecha_nac((txtFechaNac.getText()));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Error", JOptionPane.ERROR_MESSAGE);
            }
            docente.setEmail(txtEmail.getText());
            docente.setSexo(cmbSexo.getSelectedIndex()==0?"m":"f");
            docente.setTelefono(txtTelefono.getText());
            
            try {
                if(docenteDao.insertar(docente)>0 ){
                JOptionPane.showMessageDialog(this,"Registrado correctamente!!",
                "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(this,"Error desconocido: ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}
 