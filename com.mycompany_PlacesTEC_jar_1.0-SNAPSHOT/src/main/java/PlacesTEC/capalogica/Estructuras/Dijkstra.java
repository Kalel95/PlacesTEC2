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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author Joan
 */
public class Dijkstra {
    
    private List<Vertice> nodos;
    private List<Arista> aristas;
    private Set<Vertice> listos;
    private Set<Vertice> pendientes;
    private Map<Vertice, Vertice> predecesores;
    private Map<Vertice, Integer> distancia;
    
     public Dijkstra(Grafo grafo) {
        // create a copy of the array so that we can operate on this array
        this.nodos = new ArrayList<Vertice>(grafo.getVertices());
        this.aristas = new ArrayList<Arista>(grafo.getAristas());
    }
     
    public void ejecutar(Vertice inicio){
        listos = new HashSet<Vertice>();
        pendientes = new HashSet<Vertice>(); 
        distancia = new HashMap<Vertice, Integer>();
        predecesores = new HashMap<Vertice,Vertice>();
        distancia.put(inicio,0);
        pendientes.add(inicio);
        while(pendientes.size()>0){
            Vertice nodo = getMinimo(pendientes);
            listos.add(nodo);
            pendientes.remove(nodo);
            HallarDistanciaMinima(nodo);
          
        }
    }
    
    public void HallarDistanciaMinima(Vertice nodo){
        List<Vertice> nodosadyacentes = getVecinos(nodo);
          for (Vertice objetivo : nodosadyacentes) {
            if (getMenorDistancia(objetivo) > getMenorDistancia(nodo)
                    + getDistancia(nodo, objetivo)) {
                distancia.put(objetivo, getMenorDistancia(nodo)
                        + getDistancia(nodo, objetivo));
                predecesores.put(objetivo, nodo);
                pendientes.add(objetivo);
            }
          }
    }
    
    private int getDistancia(Vertice nodo, Vertice objetivo) {
        for (Arista edge : aristas) {
            if (edge.getSalida().equals(nodo)
                    && edge.getMeta().equals(objetivo)) {
                return (int) edge.getDistancia();
            }
        }
        throw new RuntimeException("No sucedio");
    }
    
    private List<Vertice> getVecinos(Vertice nodo) {
        List<Vertice> vecinos = new ArrayList<Vertice>();
        for (Arista edge : aristas) {
            if (edge.getSalida().equals(nodo)
                    && !estaListo(edge.getMeta())) {
                vecinos.add(edge.getMeta());
            }
        }
        return vecinos;
    }
    
      private Vertice getMinimo(Set<Vertice> vertices) {
        Vertice minimo = null;
        for (Vertice vertex : vertices) {
            if (minimo == null) {
                minimo = vertex;
            } else {
                if (getMenorDistancia(vertex) < getMenorDistancia(minimo)) {
                    minimo = vertex;
                }
            }
        }
        return minimo;
    }
      
      private boolean estaListo(Vertice pvertice){
          return listos.contains(pvertice);
      }
      
      private int getMenorDistancia(Vertice destino) {
        Integer d = distancia.get(destino);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return (int) d;
        }
    }
      
     public LinkedList<Vertice> getPath(Vertice objetivo) {
        LinkedList<Vertice> path = new LinkedList<Vertice>();
        Vertice step = objetivo;
        // check if a path exists
        if (predecesores.get(step) == null){
            return null;
        }
        path.add(step);
        while (predecesores.get(step) != null) {
            step = predecesores.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
      
      
}

