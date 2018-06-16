/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;
import se.walkercrou.places.Prediction;

/**
 *
 * @author Kenneth
 */
public class ApiPlaces {
    GooglePlaces client = new GooglePlaces("AIzaSyCeK84BmV_6d1hRdtb5l5hIaX_7JrobptU");
    //Param a = new Param("keyword=tacobell");
  
    public void imprimir(double Lat, double Long, int radio, String TipLInteres) {
        Param a = new Param("type="+TipLInteres);
        //9.8666386,-83.921331
        List<Place> places = client.getNearbyPlaces(Lat, Long, radio, GooglePlaces.MAXIMUM_RESULTS, a);
        ArrayList<ArrayList> LInt = new ArrayList<>();
        
        System.out.println(places.size());
        int num=places.size();
        System.out.println(Arrays.deepToString(places.toArray()));
        for(int i=0; i<num; i++) {
            Place place = places.get(i).getDetails();
            System.out.println(place.getIconImage());
            System.out.println("Lat: " + place.getLatitude());
            System.out.println("Long: " + place.getLongitude());
            System.out.println("Adress: " + place.getAddress());
        }
        
        
        
        /*for (Place place : places) {
            if (place.getName().equals("Empire State Building")) {
                empireStateBuilding = place;
                break;
            }
        }
        //if (empireStateBuilding != null) {
            Place detailedEmpireStateBuilding = empireStateBuilding.getDetails(); // sends a GET request for more details
            // Just an example of the amount of information at your disposal:
            System.out.println("Name: " + detailedEmpireStateBuilding.getName());
            System.out.println("Phone: " + detailedEmpireStateBuilding.getPhoneNumber());
            System.out.println("International Phone: " + empireStateBuilding.getInternationalPhoneNumber());
            System.out.println("Website: " + detailedEmpireStateBuilding.getWebsite());
            System.out.println("Always Opened: " + detailedEmpireStateBuilding.isAlwaysOpened());
            System.out.println("Status: " + detailedEmpireStateBuilding.getStatus());
            System.out.println("Google Place URL: " + detailedEmpireStateBuilding.getGoogleUrl());
            System.out.println("Price: " + detailedEmpireStateBuilding.getPrice());
            System.out.println("Address: " + detailedEmpireStateBuilding.getAddress());
            System.out.println("Vicinity: " + detailedEmpireStateBuilding.getVicinity());
            System.out.println("Reviews: " + detailedEmpireStateBuilding.getReviews().size());
            System.out.println("Hours:\n " + detailedEmpireStateBuilding.getHours());
        //}*/
    }
    public ArrayList AutoCompletado(String direcACompletar) {
        List<Prediction> predictions = client.getPlacePredictions(direcACompletar);
        //ArrayList<String> aray = null;
        
        ArrayList<String> resp = new ArrayList<String>();
        
        int num=predictions.size();
        for(int i=0; i<num; i++) {
            //System.out.println(predictions.get(i).getDescription());
            //aray.add(i, direcACompletar);
            resp.add(predictions.get(i).getDescription());
        }
        //System.out.println(resp);
        return resp;
    }
}
