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
import java.util.LinkedList;

/**
 *
 * @author Joan
 * @param <T>
 */
public class Vertice<T> {
    private String ID_V;
    public boolean visitado;
    private LinkedList<Arista> aristas;
    private T contenido;
    
    
    public Vertice(String ID) {
        this.ID_V = ID;
        aristas = new LinkedList<Arista>();
        this.visitado = false;
    }

    public Vertice(String ID, T contenido) {
        this.ID_V = ID;
        this.contenido = contenido;
        aristas = new LinkedList<Arista>();
        this.visitado = false;
		
    }
   	
    public void asignar_arista(String ID_A, Vertice salida,Vertice meta, int Distancia,int tiempo){
        Arista nueva_arista = new Arista(ID_A,salida,meta,Distancia,tiempo);
        aristas.add(nueva_arista);
        //System.out.println("Se agrego nueva arista llamada:" + " "+ nueva_arista.getID_A());
        
    }
    
    @Override
     public int hashCode() {
        final int prime = 31;
        int resultado = 1;
        resultado = prime * resultado + ((ID_V == null) ? 0 : ID_V.hashCode());
        return resultado;
    }
     
     @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertice other = (Vertice) obj;
        if (ID_V == null) {
            if (other.ID_V != null)
                return false;
        } else if (!ID_V.equals(other.ID_V))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
		String msj = "";
		msj += "Identificador del vértice: " + ID_V+ "\n";
                msj += "Contenido del vértice: " + contenido.toString()+ "\n";
                msj += "Estado de visita: " + visitado+ "\n";
                msj += "Se puede contectar con: " + aristas.toString()+ "\n";
		
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
    
   
    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public String getID_V() {
        return ID_V;
    }

    public void setID_V(String ID_V) {
        this.ID_V = ID_V;
    }
    
    
    
}



