/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package trabajo_hoja_de_vida.tests;
//
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import trabajo_hoja_de_vida.accesodatos.*;
//import trabajo_hoja_de_vida.rnegocio.dao.*;
//import trabajo_hoja_de_vida.rnegocio.entidades.*;
//import java.util.*;
//import java.sql.*;
//import trabajo_hoja_de_vida.rnegocio.impl.ResumenImpl;
//public class ResumenTest {
//    public ResumenTest() {
//    }
//  @Test
//
//    public void TestGeneral() {
//        IResumen resDao = new ResumenImpl();
//
//        //Test Insertar
//        int filas = 0;
//        Docente doc = new Docente(2, "0605083837-7","Daniela", "Ramos", "Chambo", new java.util.Date(), "dannys@gmail", "F", "098345671");
//        //   Resumen resum = new Resumen(2,  "Numeros de Esctudiantes");
//
//        try {
//       //        filas = resDao.insertar(resum);
//            System.out.println("Ingreso de " + filas + " Filas Correctas");
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertTrue(filas > 0);
//
////
//// POR CODIGO/
//        Resumen nResum = new Resumen();
//        try {
//           nResum = resDao.obtener(1);
//            System.out.println(nResum.getDocente().getCod_docente() + "    " + nResum.getDescripcion());
//        } catch (Exception e) {
//        }
//        assertEquals( nResum != null, true);
//
//        ///////////LISTADO
//        ArrayList<Resumen> resumenn = new ArrayList<>();
//        
//        try { 
//           resumenn = (ArrayList<Resumen>) resDao.obtener();
//            for (Resumen resumenes : resumenn) {          
//                System.out.println( resumenes.getDocente().getCod_docente() + "    "+  resumenes.getDescripcion());
//            }
//        } catch (Exception e) {
//            
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertTrue( resumenn.size() > 0);
//
//    }
//
//}
//
//    
//
