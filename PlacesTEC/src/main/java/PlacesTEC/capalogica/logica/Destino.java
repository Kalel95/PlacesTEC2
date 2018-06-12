/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Logica;

/**
 *
 * @author Joan
 */
public class Destino {
    private String direccion;
    private double latitud;
    private double longitud;
    private char   lat;
    private char   lon;
    private int    grados; 
    private int    minutos;
    private double segundos;

    public Destino(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Destino(String direccion) {
        this.direccion = direccion;
    }

    public Destino(char lat, char lon, int grados, int minutos, double segundos) {
        this.lat = lat;
        this.lon = lon;
        this.grados = grados;
        this.minutos = minutos;
        this.segundos = segundos;
    } 

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public char getLat() {
        return lat;
    }

    public void setLat(char lat) {
        this.lat = lat;
    }

    public char getLon() {
        return lon;
    }

    public void setLon(char lon) {
        this.lon = lon;
    }

    public int getGrados() {
        return grados;
    }

    public void setGrados(int grados) {
        this.grados = grados;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public double getSegundos() {
        return segundos;
    }

    public void setSegundos(double segundos) {
        this.segundos = segundos;
    }
    
    
    
    
}
