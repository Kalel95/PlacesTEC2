/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Api;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import java.io.IOException;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kenneth
 */
public class DistaciaMatrixApi {
    public void impDistancia(String[] origenes, String[] destinos, String modoViaje) throws ApiException, InterruptedException, IOException {
        TravelMode modoDeViaje = null;
        if (null!=modoViaje) switch (modoViaje) {
            case "Automóvil":
                modoDeViaje=TravelMode.DRIVING;
                break;
            case "Bicicleta":
                modoDeViaje=TravelMode.BICYCLING;
                break;
            case "Caminando":
                modoDeViaje=TravelMode.WALKING;
                break;
            default:
                break;
        }
        
        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyAzamKw_Gz499mqnxp7LiBc8MNFijHHRI8").build();
        //DistanceMatrixApi.getDistanceMatrix(context, ["San jose"], ["Cartago"]);
		
		DistanceMatrixApiRequest req=DistanceMatrixApi.newRequest(context);
		DistanceMatrix t=req.origins(origenes).destinations(destinos).mode(modoDeViaje).await();
		//long[][] array=new long[origins.length][destinations.length];
            for(int i=0;i<origenes.length;i++){
                for(int j=0;j<destinos.length;j++){
                    String z = null;
               
                    z=t.rows[i].elements[j].distance.toString();
                    Pattern p= Pattern.compile("[km]");
                    Matcher m= p.matcher(z);
                    if(m.find()){
			String remplazado=m.replaceAll("");
                        Double a = Double.parseDouble(remplazado);
			System.out.println(a);
		}
                    
                }
            }
    }
    
}
