/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;
import trabajo_hoja_de_vida.accesodatos.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
/**
 *
 * @author FABRICIO CONSTANTE
 */
public class FrmCursoNuevo extends JInternalFrame{
    JLabel lblTitulo1,lblCodigo,lblDescripcion;
    JTextField txtTitulo1,txtCodigo,txtDescripcion;
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmCursoNuevo(){
        this.setSize(200,200);
        this.setLayout(new BorderLayout());
     
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo1 = new JLabel("DATOS DEL CURSO");
        
        lblCodigo= new JLabel("CODIGO:");
        lblDescripcion= new JLabel("DESCRIPCION:");
        
        txtTitulo1 = new JTextField(2);
        txtCodigo= new JTextField(2);
        txtDescripcion= new JTextField(2);

        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblDescripcion);
        pnlCentral.add(txtDescripcion);
        
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
        this.add(lblTitulo1, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);  
        this.setClosable(true);        
        
    }
    public static void main(String[] args) {
        FrmCursoNuevo frmMenu= new FrmCursoNuevo();
        frmMenu.setVisible(true);
    }  
    public void btnAceptarActionListener(ActionEvent e){
        
        try {
            
            Curso curso = new Curso();
            curso.setCodigo(Integer.parseInt(txtCodigo.getText()));
            curso.setDescripcion(txtDescripcion.getText());
            ICurso cursoDao = new CursoImpl();
            
            if(cursoDao.insertar(curso)>0){
                JOptionPane.showMessageDialog(this,"Registro Correcto!!",
                        "Transacción correcta",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this,"Error de Guardado!!",
                "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
            
            
        } catch (Exception x) {
              JOptionPane.showMessageDialog(this,"Proceso incorrecto!!" + x.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            
        }
      
    }
}