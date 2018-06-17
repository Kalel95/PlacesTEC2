/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Estructuras;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Joan
 */
import java.util.*;
public class Grafo<T> {
    private LinkedList <Vertice> vertices;
    private LinkedList <Arista>  aristas;
    private LinkedList <Arista> recorrido;
    private LinkedList <Arista> ruta;
   
    public Grafo(){
		this.vertices = new LinkedList<Vertice>();
                this.recorrido = new LinkedList<Arista>();
                this.recorrido = new LinkedList<Arista>();
                this.aristas = new LinkedList<Arista>();
	}
    
    public void agregar_Vertices(String ID, T contenido){
        Vertice nuevo = new Vertice(ID, contenido);
        vertices.add(nuevo);
        //System.out.println("Se agrego un nuevo vertice llamado: "+ nuevo.getID());
        
    }
    
     public void agregar_Vertices(String ID, Vertice contenido){
        Vertice nuevo = new Vertice(ID, contenido);
        vertices.add(nuevo);
        
    }
    
    public void agregarArista(String ID_V,String ID_A, Vertice origen, Vertice destino, int distancia,int tiempo){
	Vertice verti = buscarVertice(ID_V);  //Buscar el vértice origen y agrega un nodo al final de la lista de aristas de ese vértice
        Arista nueva_arista = new Arista(ID_A, destino, destino, distancia,tiempo);
        verti.asignar_arista(ID_A, destino, destino, distancia,tiempo);
        aristas.add(nueva_arista);
        
	}
    
    
    public Vertice buscarVertice(String ID_V){
		//Recorre la lista de vertices
		for(int indice = 0; indice < this.vertices.size(); indice++){
			if(this.vertices.get(indice).getID().equals(ID_V)){  //Si encuentra el vértice lo retorna
				return this.vertices.get(indice);
                       }
                
                }
		return null;
	}
    public Arista buscarArista(String ID_V, String ID_A ){
		Vertice aux = buscarVertice(ID_V);  //Busca el vértice de origen
		//Busca en la lista de aristas de ese vértice para identificar si se encuentra la arista buscada
		for(int i = 0; i < aux.getAristas().size(); i++){
                    Arista aris =(Arista) aux.getAristas().get(i);
			if(aris.getID_A().equals(ID_A)){
				return (Arista) aux.getAristas().get(i);
			}
		}
		return null;
	}
    
    //Método para buscar el primer vértice del grafo que esté sin visitar
	public Vertice buscarVerticeNOVisitado(){

		//Recorre la lista de vértices
		for(int indice = 0; indice < this.vertices.size(); indice++){
			if(!this.vertices.get(indice).visitado ){ //Si encuentra una no visitado lo retorna
				return this.vertices.get(indice);
			}
		}
		return null; //Si todos están visitados retorna null
	}
        
        //Método para imprimir el grafo recorriendo la lista de vértices y por cada vértice imprimiendo la lista de aristas que tiene
	public void imprimeGrafo(){
		Vertice actual;
		for(int i = 0; i < this.vertices.size();i++){
			actual = vertices.get(i);
			System.out.println("Vertice : " + actual.getID());
			for(int j = 0; j < actual.getAristas().size(); j++){
                            Arista aris = (Arista) actual.getAristas().get(j);
				System.out.println("Arista de "+actual.getID()+ " a " + aris.getID_A() + " con distancia de  " + aris.getDistancia()+ " con una duración de " + aris.getTiempo());       
                                
                            
			}                
		}
	}
        
         //Método para eliminar un vértice del grafo
	public void eliminarVertice(String ID_V){
		this.vertices.remove(buscarVertice(ID_V));  //Elimina el vértice de la lista de vértices
		//Elimina todas las aristas en las que el vértice eliminado aparezca como destino
		for(int i = 0; i < vertices.size(); i++)
			eliminarArista(vertices.get(i).getID(), ID_V);
                System.out.print("Se eliminó: "+ID_V);
	}
        
	//Método para eliminar una arista de un vértice origen a un vértice destino dado
	public void eliminarArista(String origen, String destino){
		//Verifica si el grafo es no dirigido
		if((buscarArista(origen,destino) != null) && (buscarArista(destino,origen) != null)){ //Busca si existe arista de origen a destino y viceversa
			//Verifica si el peso de ambas aristas es igual con lo que se asume que es un grafo no dirigido
			if(buscarArista(origen,destino).getDistancia() == buscarArista(destino,origen).getDistancia()){
				buscarVertice(destino).getAristas().remove(buscarArista(destino, origen));                                
			}
		}
		//Elimina el arista de la lista de aristas del vértice origen
		buscarVertice(origen).getAristas().remove(buscarArista(origen, destino));
	}
        
        public void agregar_ruta(String V_origen, String V_destino){
            Vertice vactual;
            Arista  aactual;
            float distancia = 0;
            float duracion = 0;
            for(int i=0; i < this.vertices.size(); i++){          
                vactual = vertices.get(i);
               for(int j=0; i<  vactual.getAristas().size(); j++){
                   aactual= (Arista) vactual.getAristas().get(i);
                   if(aactual.getMeta().getID_V().equals(V_destino)){
                       distancia += aactual.getDistancia();
                       duracion += aactual.getTiempo();
                       break;
                   }
                    distancia += aactual.getDistancia();
                    duracion += aactual.getTiempo();
               } 
            }
        }

    public LinkedList<Vertice> getVertices() {
        return vertices;
    }
    
    public void setVertices(LinkedList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public LinkedList<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(LinkedList<Arista> aristas) {
        this.aristas = aristas;
    }

    public LinkedList<Arista> getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(LinkedList<Arista> recorrido) {
        this.recorrido = recorrido;
    }

    public LinkedList<Arista> getRuta() {
        return ruta;
    }

    public void setRuta(LinkedList<Arista> ruta) {
        this.ruta = ruta;
    }
        
}