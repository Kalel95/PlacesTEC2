/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Estructuras;

/**
 *
 * @author Joan
 */
public class Arista {
    private String ID_A;
    private Vertice salida;
    private Vertice meta;
    private float  tiempo;
    private float distancia;

    public Arista(String ID_A, Vertice salida, Vertice meta, float distancia,float tiempo) {
        this.ID_A = ID_A;
        this.meta = meta;
        this.salida = salida;
        this.distancia = distancia;
        this.tiempo = tiempo;
    }
    

    @Override
    public String toString() {
        String msj = "";
	msj += "ID: " + ID_A + "\n";
	msj += "VERTICE PARTIDA: \n";
	msj += salida.getID();
	msj += "Distancia: " + distancia;
        msj += "Duración: " + tiempo;
	return msj;
       
    }
    
    

    public String getID_A() {
        return ID_A;
    }

    public void setID_A(String ID_A) {
        this.ID_A = ID_A;
    }

    public Vertice getSalida() {
        return salida;
    }

    public void setSalida(Vertice salida) {
        this.salida = salida;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public Vertice getMeta() {
        return meta;
    }

    public void setMeta(Vertice meta) {
        this.meta = meta;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
    
}

