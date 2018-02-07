/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.entidades;

import java.util.*;
public class Docente {
    private int cod_docente;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date fecha_nac;
    private String sexo;
    private String email;
    private String telefono;

    public Docente() {
    }

    public Docente(int cod_docente, String cedula, String nombres, String apellidos, String direccion, Date fecha_nac, String sexo, String email, String telefono) {
        this.cod_docente = cod_docente;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.email = email;
        this.telefono = telefono;
    }

    public int getCod_docente() {
        return cod_docente;
    }

    public void setCod_docente(int cod_docente) {
        this.cod_docente = cod_docente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Docente{" + "cod_docente=" + cod_docente + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", fecha_nac=" + fecha_nac + ", sexo=" + sexo + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
    

}