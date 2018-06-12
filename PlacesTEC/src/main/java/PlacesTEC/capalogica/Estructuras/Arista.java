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
  
    private Double distancia;

    public Arista(String ID_A, Vertice salida, Double distancia) {
        this.ID_A = ID_A;
        this.salida = salida;
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        String msj = "";
	msj += "ID: " + ID_A + "\n";
	msj += "VERTICE PARTIDA: \n";
	msj += salida.toString();
	msj += "Distancia: " + distancia;
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

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
    
    
}
