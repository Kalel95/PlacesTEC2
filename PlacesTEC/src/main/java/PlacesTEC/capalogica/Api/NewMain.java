/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Api;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.GeocoderGeometry;
import com.google.code.geocoder.model.LatLng;
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
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ApiPlaces a = new ApiPlaces();
        //a.AutoCompletado("alajuelita");
        //a.imprimir();
        //ejemplaces b = new ejemplaces();
        //b.imp();
        
        Geocoder d = new Geocoder();
        GoogleGeocoderService c = new GoogleGeocoderService(d);
        System.out.println(c.locationToCoordinate("Alajuelita Central Park, San José Province, Alajuelita, Costa Rica"));
        
        GeocoderGeometry h = new GeocoderGeometry();
        LatLng j = new LatLng("9.902809399999999", "-84.10016610000001");
        h.setLocation(j);
        System.out.println(c.coordinateToLocation(h));
    }
    
}
