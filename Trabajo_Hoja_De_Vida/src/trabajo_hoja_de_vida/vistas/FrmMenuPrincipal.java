package trabajo_hoja_de_vida.vistas;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//import org.jvnet.substance.SubstanceLookAndFeel;
//import org.jvnet.substance.watermark.SubstanceImageWatermark;
//
//public class FrmMenuPrincipal extends JFrame {
//
//    JMenuBar mnbPrincipal;
//    JMenu mnInicio;
//    JMenuItem mniLogin;
//    JMenuItem mniSalir;
//    JMenu mnEstudiante;
//    JMenuItem mniNuevoEstudiante;
//    JMenuItem mniModificaEstudiante;
//    JMenuItem mniEliminaEstudiante;
//    JMenuItem mniBuscaEstudiante;
//    JMenuItem mniListaEstudiante;
//    JMenu mnCurso;
//    JMenuItem mniNuevoCurso;
//    JMenuItem mniModificaCurso;
//    JMenuItem mniEliminaCurso;
//    JMenuItem mniListaCurso;
//    JMenuItem mniBuscaCurso;
//    JMenu mnMateria;
//    JMenuItem mniNuevaMateria;
//    JMenuItem mniModificaMateria;
//    JMenuItem mniEliminaMateria;
//    JMenuItem mniListaMateria;
//    JMenuItem mniBuscaMateria;
//    JMenu mnDocente;
//    JMenuItem mniNuevoDocente;
//    JMenuItem mniModificaDocente;
//    JMenuItem mniEliminaDocente;
//    JMenuItem mniBuscaDocente;
//    JMenuItem mniListaDocente;
//
//    JDesktopPane dkpEscritorio;
//
//    public FrmMenuPrincipal() {
//        dkpEscritorio= new JDesktopPane();
//        dkpEscritorio.setBackground(new Color(240, 240, 240));
//        
//        mnbPrincipal = new JMenuBar();
//        mnInicio = new JMenu("Inicio");
//        mniLogin = new JMenuItem("Iniciar Sesión");
//        mniSalir = new JMenuItem("Salir");
//        mniSalir.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniSalirActionPerformed(e);
//            }
//        });
//        mnEstudiante= new JMenu("Estudiante");
//        mniNuevoEstudiante= new JMenuItem("Nuevo");
//        mniNuevoEstudiante.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniNuevoEstudianteActionPerformed(e);
//            }
//        });
//        mniModificaEstudiante= new JMenuItem("Modifica");
//        mniEliminaEstudiante= new JMenuItem("Elimina");
//        mniBuscaEstudiante= new JMenuItem("Busca");
//        mniListaEstudiante= new JMenuItem("Lista");
//        
//        mniListaEstudiante.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniListaEstudianteActionPerformed(e);
//            }
//        });
//        
//         mnCurso= new JMenu("Curso");
//          mniNuevoCurso= new JMenuItem("Nuevo");
//        mniNuevoCurso.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniNuevoCursoActionPerformed(e);
//            }
//        });
//        mnEstudiante.add(mniNuevoEstudiante);
//        mnEstudiante.add(mniModificaEstudiante);
//        mnEstudiante.add(mniEliminaEstudiante);
//        mnEstudiante.addSeparator();
//        mnEstudiante.add(mniBuscaEstudiante);
//        mnEstudiante.add(mniListaEstudiante);
//        
//        mnDocente= new JMenu("Docente");
//        mniNuevoDocente= new JMenuItem("Nuevo");
//        mniNuevoDocente.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniNuevoDocenteActionPerformed(e);
//            }
//        });
//        mniModificaDocente= new JMenuItem("Modifica");
//        mniEliminaDocente= new JMenuItem("Elimina");
//        mniBuscaDocente= new JMenuItem("Busca");
//        mniListaDocente= new JMenuItem("Lista");
//
//        mniListaDocente.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniListaDocenteActionPerformed(e);
//            }
//        });
//        
//        mnDocente.add(mniNuevoDocente);
//        mnDocente.add(mniModificaDocente);
//        mnDocente.add(mniEliminaDocente);
//        mnDocente.addSeparator();
//        mnDocente.add(mniBuscaDocente);
//        mnDocente.add(mniListaDocente);
//        
//        mnCurso = new JMenu("Curso");
//        mniNuevoCurso = new JMenuItem("Nuevo");
//        mniNuevoCurso.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniNuevoCursoActionPerformed(e);
//            }
//        });
//        
//        mniModificaCurso = new JMenuItem("Modifica");
//        mniEliminaCurso = new JMenuItem("Elimina");
//        mniBuscaCurso = new JMenuItem("Busca");
//        mniListaCurso = new JMenuItem("Lista");
//        mnCurso.add(mniNuevoCurso);
//        mnCurso.add(mniModificaCurso);
//        mnCurso.add(mniEliminaCurso);
//        mnCurso.addSeparator();
//        mnCurso.add(mniBuscaCurso);
//        mnCurso.add(mniListaCurso);
//        
//        mnMateria = new JMenu("Materia");
//        mniNuevaMateria = new JMenuItem("Nuevo");
//        mniNuevaMateria.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniNuevoMateriaActionPerformed(e);
//            }
//        });
//        
//        mniModificaMateria = new JMenuItem("Modifica");
//        mniEliminaMateria = new JMenuItem("Elimina");
//        mniBuscaMateria = new JMenuItem("Busca");
//        mniListaMateria = new JMenuItem("Lista");
//        mnMateria.add(mniNuevaMateria);
//        mnMateria.add(mniModificaMateria);
//        mnMateria.add(mniEliminaMateria);
//        mnMateria.addSeparator();
//        mnMateria.add(mniBuscaMateria);
//        mnMateria.add(mniListaMateria);
//        
//        mnbPrincipal.add(mnInicio);
//        mnbPrincipal.add(mnEstudiante);
//        mnbPrincipal.add(mnDocente);
//        mnbPrincipal.add(mnCurso);
//        mnbPrincipal.add(mnMateria);
//        mnInicio.add(mniLogin);
//        mnInicio.add(mniSalir);
//        this.setLayout(new BorderLayout());
//        this.add(mnbPrincipal, BorderLayout.NORTH);
//        this.add(dkpEscritorio, BorderLayout.CENTER);
//        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
//    }
//     public void mniNuevoCursoActionPerformed(ActionEvent e){
//        FrmNuevoCurso frm = new FrmNuevoCurso();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
//    }
//    public void mniNuevoEstudianteActionPerformed(ActionEvent e){
//        FrmNuevoEstudiante frm = new FrmNuevoEstudiante();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
//    }
//    
//    public void mniNuevoDocenteActionPerformed(ActionEvent e){
//        FrmNuevoDocente frm = new FrmNuevoDocente();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
//    }
//    
//    public void mniSalirActionPerformed(ActionEvent e){
//        System.exit(0);
//    }
//    public void mniNuevoMateriaActionPerformed(ActionEvent e)
//    {
//    FrmNuevaMateria frm= new FrmNuevaMateria();
//    dkpEscritorio.add(frm);
//    frm.setVisible(true);
//    }
//    
//    public void mniListaEstudianteActionPerformed(ActionEvent e)
//    {
//    FrmListaEstudiante frm= new FrmListaEstudiante();
//    dkpEscritorio.add(frm);
//    frm.setVisible(true);
//    }
//    
//     public void mniListaDocenteActionPerformed(ActionEvent e)
//    {
//    FrmListaDocente frm= new FrmListaDocente();
//    dkpEscritorio.add(frm);
//    frm.setVisible(true);
//    }
//    
//    public static void main(String[] args) {
//        JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
//        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.GreenMagicSkin"); // Setencia que aplica el skin Creme de Substance
//        SubstanceLookAndFeel.setCurrentWatermark( new SubstanceImageWatermark("C:\\Users\\Usuario\\Desktop\\4fge4d64vuky.png"));
//        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.8));//valor aproximado de la opacidad por default de imageWatermark
//        FrmMenuPrincipal frm = new FrmMenuPrincipal();
//        frm.setVisible(true);
//    }
//}
