/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Api;

import PlacesTEC.capalogica.Estructuras.Grafo;
import PlacesTEC.capalogica.Estructuras.Vertice;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.GeocoderGeometry;
import com.google.code.geocoder.model.LatLng;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Kenneth
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, ApiException, InterruptedException {
        // TODO code application logic here
        //ApiPlaces a = new ApiPlaces();
        //a.AutoCompletado("alajuelita");
        //a.imprimir();
        //ejemplaces b = new ejemplaces();
        //b.imp();
        
        /*
        Geocoder d = new Geocoder();
        GoogleGeocoderService c = new GoogleGeocoderService(d);
        LatLng location = c.locationToCoordinate("Cot,Oreamuno, Cartago, Costa Rica").getLocation();
        System.out.println("La latitud es = " + location.getLat() + "\nLa longitud es = " + location.getLng());
        
        GeocoderGeometry h = new GeocoderGeometry();
        LatLng j = new LatLng("9.892196199999999", "-83.87248249999999");
        h.setLocation(j);
        System.out.println(c.coordinateToLocation(h));
        */
        
        /*
        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyAzamKw_Gz499mqnxp7LiBc8MNFijHHRI8").build();
        //DistanceMatrixApi.getDistanceMatrix(context, ["San jose"], ["Cartago"]);
        String[] a = {"Cartago Province,Cartago,Costa Rica","San Jose Costa Rica"};
        String[] b = {"San Jose Costa Rica","Cartago Province,Cartago,Costa Rica"};
		
		DistanceMatrixApiRequest req=DistanceMatrixApi.newRequest(context);
		DistanceMatrix t=req.origins(a).destinations(b).mode(TravelMode.DRIVING).await();
		//long[][] array=new long[origins.length][destinations.length];
            for(int i=0;i<a.length;i++){
                for(int j=0;j<b.length;j++){
                    System.out.println(t.rows[i].elements[j].distance);
                }
            }
        */
        
            
        Grafo grafo = new Grafo();      
        Vertice a1 = new Vertice("Cartago","Paraíso"); 
        Vertice b1 = new Vertice("San José","Paseo Colón");
        Vertice c = new Vertice("Heredia","Paseo de las Flores");
        Vertice d = new Vertice("Puntarenas","Buenos Aires");
        Vertice e = new Vertice("Alajuela","San Carlos");
        
        grafo.agregar_Vertices("Cartago","Paraíso" );
        grafo.agregar_Vertices("San José","Paseo Colón");
        grafo.agregar_Vertices("Heredia","Paseo de las Flores");
        grafo.agregar_Vertices("Puntarenas","Buenos Aires" );
        grafo.agregar_Vertices("Alajuela","San Carlos" );
            
        grafo.agregarArista("Cartago", "Carretera Paraiso a Paseo Colon", a1, b1,4032,54);
        grafo.agregarArista("Cartago", "Carretera Paraiso a Paseo de las Flores", a1, c,4432,40);
        grafo.agregarArista("San José", "Carretera Paseo de las flores a Buenos Aires", a1, d, 6949,23);
        grafo.agregarArista("Alajuela", "Carretera San Carlos a Buenos Aires", a1, d, 5932,43);
        grafo.agregarArista("Puntarenas", "Carretera Buenos Aires a Paseo de las flores ", a1, c, 9449,88);
        grafo.agregarArista("Heredia", "Carretera Paseo de las flores a San Carlos", c, e, 9449,44);
        
        grafo.eliminarVertice("San José");
        grafo.getVertices().toString();
        grafo.imprimeGrafo();
                    
                    
        /*
        String[] a = {"Cartago Province,Cartago,Costa Rica","San Jose Costa Rica"};
        String[] b = {"San Jose Costa Rica","Cartago Province,Cartago,Costa Rica"};
        DistaciaMatrixApi l = new DistaciaMatrixApi();
        l.impDistancia(a, b, "Carro");
        */
    }
}
    

