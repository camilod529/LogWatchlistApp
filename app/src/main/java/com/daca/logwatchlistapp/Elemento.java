package com.daca.logwatchlistapp;

public class Elemento {


    private String id;
    private String nombre;
    private String plat;
    private int cap;
    private String dia;

    Elemento (){}

    Elemento (String id, String nombre, String plat, int cap, String dia) {
        this.id = id;
        this.nombre = nombre;
        this.plat = plat;
        this.cap = cap;
        this.dia = dia;
    }

    Elemento  (String id, String nombre, String plat){
        this.id = id;
        this.nombre = nombre;
        this.plat = plat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
