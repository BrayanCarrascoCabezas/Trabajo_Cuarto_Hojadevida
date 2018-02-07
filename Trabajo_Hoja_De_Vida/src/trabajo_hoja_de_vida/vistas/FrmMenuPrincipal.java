package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    
    JMenu mnDocente;
    JMenuItem mniNuevoDocente;
    JMenuItem mniModificaDocente;
    JMenuItem mniEliminaDocente;
    JMenuItem mniBuscaDocente;
    JMenuItem mniListaDocente;

    JDesktopPane dkpEscritorio;

    public FrmMenuPrincipal() {
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));
        
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Sesión");
        mniSalir = new JMenuItem("Salir");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
                
        mnDocente= new JMenu("Docente");
        mniNuevoDocente= new JMenuItem("Nuevo");
        mniNuevoDocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDocenteActionPerformed(e);
            }
        });
        mniModificaDocente= new JMenuItem("Modifica");
        mniEliminaDocente= new JMenuItem("Elimina");
        mniBuscaDocente= new JMenuItem("Busca");
        mniListaDocente= new JMenuItem("Lista");

        mniListaDocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDocenteActionPerformed(e);
            }
        });
        
        mnDocente.add(mniNuevoDocente);
        mnDocente.add(mniModificaDocente);
        mnDocente.add(mniEliminaDocente);
        mnDocente.addSeparator();
        mnDocente.add(mniBuscaDocente);
        mnDocente.add(mniListaDocente);
        
               
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnDocente);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
    }
    
    public void mniNuevoDocenteActionPerformed(ActionEvent e){
        FrmNuevoDocente frm = new FrmNuevoDocente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
    
     public void mniListaDocenteActionPerformed(ActionEvent e)
    {
    FrmListaDocente frm= new FrmListaDocente();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.GreenMagicSkin"); // Setencia que aplica el skin Creme de Substance
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }
}
