/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Estructuras;

import Paquete.Estructuras.ANodoArbol;

/**
 *
 * @author Joan
 * @param <T>
 */
public class ArbolBinario<T> {
    //Atributos del arbol binarios
    private T contenido; 
    private ANodoArbol<T> raiz;
    private ANodoArbol<T> padre;
    private ANodoArbol<T> izquierdo;
    private ANodoArbol<T> derecho;
    
    //Constructores
    
    //Arbol Binario Vacio

    /**
     *
     */
    public ArbolBinario(){
        this.raiz =  null;
    }
    
    /*
    public ArbolBinario(){
        this.padre = null;
        this.derecho = null;
        this.izquierdo = null;
    }
    */
    
    //Hoja del Arbol Binario 

    /**
     *
     * @param contenido
     * @param prioridad
     */
    public ArbolBinario(T contenido, int prioridad) {
        this.contenido = contenido;
        this.padre = new ANodoArbol(contenido, prioridad);
        this.izquierdo = null;
        this.derecho = null;
    }
    // Verificar si el arbol esta vacio

    /**
     *
     * @return
     */
    public boolean esvacio(){
        boolean vacio = true;
        
        if ( padre != null)
            vacio = false;
        return vacio;
    }
    
    //Insertar un nodo

    /**
     *
     * @param contenido
     * @param prioridad
     * inserta el nodo
     * 
     * 
     * 
     * 
     */
    public void insertar (T contenido, int prioridad){
        //crear un nuevo nodo para el arbol
        ANodoArbol nuevo = new ANodoArbol(contenido, prioridad);
        if (raiz ==  null){
            raiz = nuevo;
        }else{
            ANodoArbol aux = raiz;
            while(true){
                padre = aux;
                if(prioridad<aux.getPriporidad()){
                    aux = aux.getIzquierdo();
                    if(aux == null){
                        padre.setIzquierdo(nuevo);
                        System.out.print("Insertado");
                        return;
                      
                    }
                }else{
                    aux = aux.getDerecho();
                    if(aux == null){
                        padre.setDerecho(nuevo);
                        System.out.print("Insertado");
                        return;
                    }
                }
        }
    }
    }
    
    // Eliminar un nodo del arbol

    /**
     *
     * @param buscar
     * @return
     */
    public boolean eliminar(T buscar){
        ANodoArbol aux = raiz;
        ANodoArbol padre = raiz;
        boolean esHijoIzq = true;
        while(aux.getContenido() != buscar){
            padre = aux;
            if(buscar != aux.getContenido()){
                esHijoIzq = true;
                aux = aux.getIzquierdo();
            }else{
                esHijoIzq = false;
                aux = aux.getDerecho();
            }
            if(aux == null){
                return false;
            }
        }// Fin del While
        if(aux.getIzquierdo() == null && aux.getDerecho() == null){
            if(aux == raiz){
                raiz = null;
            } else if (esHijoIzq){
                padre.setIzquierdo(null);
            }else{
                padre.setDerecho(null);
            }
            
            } else if (aux.getDerecho() == null){
                if(aux == raiz){
                raiz = aux.getIzquierdo();
            } else if (esHijoIzq){
                padre.setIzquierdo(aux.getIzquierdo());
            }else{
                padre.setDerecho(aux.getIzquierdo());
            }
                
            }else if(aux.getIzquierdo() == null){
                if(aux == raiz){
                raiz = aux.getDerecho();
            } else if (esHijoIzq){
                padre.setIzquierdo(aux.getDerecho());
            }else{
                padre.setDerecho(aux.getIzquierdo());
            }
            }else{
                ANodoArbol nuevo = reemplazar(aux);
                if(aux == raiz){
                    raiz = nuevo;
                }else if (esHijoIzq){
                    padre.setIzquierdo(nuevo);
                }else{
                    padre.setDerecho(nuevo);
                }
                nuevo.setIzquierdo(aux.getIzquierdo());
            }
        return true;
    }
    
    // Metodo reemplazar

    /**
     *
     * @param preemplazo
     * @return
     */
    public ANodoArbol reemplazar(ANodoArbol preemplazo){
        ANodoArbol reemplazo_Padre = preemplazo;
        ANodoArbol reemplazo = preemplazo;
        ANodoArbol aux =preemplazo.getDerecho();
        while(aux != null){
            reemplazo_Padre = preemplazo;
            reemplazo = aux;
            aux = aux.getIzquierdo();
        }
        if (reemplazo != preemplazo.getDerecho()){
            reemplazo_Padre.setIzquierdo(reemplazo.getDerecho());
            reemplazo.setDerecho(preemplazo.getDerecho());
        }
        System.out.println("El Nodo Reemplazo: " + reemplazo);
        return reemplazo.getCabeza();
        
    }
                   
                
                
    //Recorrer el arbol de forma de preOrden    

    /**
     *
     * @param nodo
     */
    public void preOrden(ANodoArbol nodo){
        if(nodo!=null){
            System.out.println(nodo.getContenido());
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
        }
    }

    
    // Getters and setters de la funcion

    /**
     *
     * @return
     */
    public T getContenido() {
        return contenido;
    }

    /**
     *
     * @param contenido
     */
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    /**
     *
     * @return
     */
    public ANodoArbol<T> getPadre() {
        return padre;
    }

    /**
     *
     * @param padre
     */
    public void setPadre(ANodoArbol<T> padre) {
        this.padre = padre;
    }

    /**
     *
     * @return
     */
    public ANodoArbol<T> getIzquierdo() {
        return izquierdo;
    }

    /**
     *
     * @param izquierdo
     */
    public void setIzquierdo(ANodoArbol<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     *
     * @return
     */
    public ANodoArbol<T> getDerecho() {
        return derecho;
    }

    /**
     *
     * @param derecho
     */
    public void setDerecho(ANodoArbol<T> derecho) {
        this.derecho = derecho;
    }

    /**
     *
     * @return
     */
    public ANodoArbol<T> getRaiz() {
        return raiz;
    }

    /**
     *
     * @param raiz
     */
    public void setRaiz(ANodoArbol<T> raiz) {
        this.raiz = raiz;
    }
    
    
}
