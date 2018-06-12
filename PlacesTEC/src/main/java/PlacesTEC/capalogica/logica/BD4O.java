/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.logica;

import Paquete.Estructuras.Lugar;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class BD4O {
	
	static ObjectContainer BDusuario;
	//se crea el archivo .yap para almacenar la información
	public BD4O() {
		this.BDusuario=Db4o.openFile("Usuarios.yap");
	}
	//metodo que retorna la información almacenada en el archivo
	public ObjectSet ConsultarLugares() {
		ObjectSet resultado=BDusuario.queryByExample(null);
		return resultado;
	}
	//metodo que retorna la información de un objeto especifico del archivo
	public ObjectSet ConsultarLugar(Object obj) {
		ObjectSet resultado=BDusuario.queryByExample(obj);
		return resultado;
	}
	//metodo donde se guarda el objeto en el archivo .yap
	public void Insertar(Object obj) {
		BDusuario.store(obj);
	}
        
	//metodo para eliminar un objeto almacenado
	public void Borrar(Object obj) {
		ObjectSet resultado=ConsultarLugar(obj);
		while(resultado.hasNext()) {
			BDusuario.delete(resultado.next());
		}
               
	}
        
        
	//metodo para editar objetos guardados
	public void Modificar(Object obj,int Codigo,int Latitud, int Longitud, String Lugar, String medio, String dia, String mes, String año) {
		
		ObjectSet resultado=ConsultarLugar(obj);
		while(resultado.hasNext()) {
			Lugar objetoLugar=(Lugar) resultado.next();
			objetoLugar.modificarLugar( Codigo,Latitud,  Longitud,  Lugar,  medio,  dia,  mes,  año);
			BDusuario.store(objetoLugar);
		}
	}
	

}

