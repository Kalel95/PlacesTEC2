/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Api;

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
import java.util.ArrayList;

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
        
        //ArrayList<String> aray=a.AutoCompletado("Heredia");
        //aray.get(3);
        //a.imprimir();
        //ejemplaces b = new ejemplaces();
        //b.imp();
        
        /*Geocoder d = new Geocoder();
        GoogleGeocoderService c = new GoogleGeocoderService(d);
        LatLng location = c.locationToCoordinate("Cot,Oreamuno, Cartago, Costa Rica").getLocation();
        System.out.println("La latitud es = " + location.getLat() + "\nLa longitud es = " + location.getLng());
        
        GeocoderGeometry h = new GeocoderGeometry();
        LatLng j = new LatLng("9.892196199999999", "-83.87248249999999");
        h.setLocation(j);
        System.out.println(c.coordinateToLocation(h));*/
        
        
        
        /*GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyAzamKw_Gz499mqnxp7LiBc8MNFijHHRI8").build();
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
            }*/
        String[] a = {"Cartago Province,Cartago,Costa Rica","San Jose Costa Rica"};
        String[] b = {"San Jose Costa Rica","Cartago Province,Cartago,Costa Rica"};
        DistaciaMatrixApi l = new DistaciaMatrixApi();
        l.impDistancia(a, b, "Automóvil");
    }
}
    

