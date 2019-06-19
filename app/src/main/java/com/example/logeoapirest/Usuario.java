package com.example.logeoapirest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String foto;
    private byte edad;

    public Usuario(JSONObject json) {
        this.setFromJson(json);
    }

    public boolean setFromJson(JSONObject json){
        try {

            this.setId(Integer.parseInt(json.getString("id")));
            this.setNombre(json.getString("nombre"));
            this.setApellido(json.getString("apellido"));
            this.setEdad(Byte.parseByte(json.getString("edad")));
            this.setUsuario(json.getString("usuario"));
            this.setPassword(json.getString("password"));
            this.setFoto(json.getString("foto"));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
        return  true;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario1{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", foto='" + foto +
                '}'+
                "Usuario2{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", foto='" + foto +
                '}';
    }
}
