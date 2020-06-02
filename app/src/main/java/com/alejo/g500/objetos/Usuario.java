package com.alejo.g500.objetos;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String usuario;
    private String pass;
    private String tipo_usuario;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nombre, String apellido1, String apellido2, String usuario, String pass, String tipo_usuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.usuario = usuario;
        this.pass = pass;
        this.tipo_usuario = tipo_usuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", usuario='" + usuario + '\'' +
                ", pass='" + pass + '\'' +
                ", tipo_usuario='" + tipo_usuario + '\'' +
                '}';
    }

    public static int  estaVacio(String usuarioIngresado, String passIngresada){
        if(usuarioIngresado.isEmpty() || passIngresada.isEmpty()){
            return 1;
        }


        return 0;
    }
}
