package com.emergentes.modelo;

import java.util.Date;

public class BlogPost {
    private int id;
    private Date fecha;
    private String titulo;
    private String contenido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "BlogPost{" + "id=" + id + ", fecha=" + fecha + ", titulo=" + titulo + ", contenido=" + contenido + '}';
    }           

    public void setFecha(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
