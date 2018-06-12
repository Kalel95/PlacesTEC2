/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Estructuras;
import java.util.LinkedList;
/**
 *
 * @author Joan
 */
public class Vertice<Arista> {
    
    private String ID_V;
    private LinkedList aristas;
    // Sirve como un nodo
    private Arista      contenido;

    public Vertice(String ID, Arista contenido) {
        this.ID_V = ID;
        this.contenido = contenido;
        aristas = new LinkedList();
    }
    
    @Override
    public String toString() {
		String msj = "";
		msj += "Siguiente vértice: " + ID_V;
		
		return msj;
	}

    public String getID() {
        return ID_V;
    }

    public void setID(String ID) {
        this.ID_V = ID;
    }

    public LinkedList getAristas() {
        return aristas;
    }

    public void setAristas(LinkedList aristas) {
        this.aristas = aristas;
    }
    
   
    public Arista getContenido() {
        return contenido;
    }

    public void setContenido(Arista contenido) {
        this.contenido = contenido;
    }
    
    
    
}
