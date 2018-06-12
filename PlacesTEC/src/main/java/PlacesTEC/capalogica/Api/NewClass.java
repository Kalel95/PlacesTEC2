/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Gestion;

import java.util.Arrays;
import java.util.List;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;

/**
 *
 * @author Kenneth
 */
public class NewClass {
    GooglePlaces client = new GooglePlaces("AIzaSyAzamKw_Gz499mqnxp7LiBc8MNFijHHRI8");
    Param a = new Param("type=restaurant");
    //Param a = new Param("keyword=tacobell");
  
    public void imprimir() {
        //9.8666386,-83.921331
        List<Place> places = client.getNearbyPlaces(9.8666386, -83.921331, 500, GooglePlaces.MAXIMUM_RESULTS, a);
        
        System.out.println(places.size());
        int num=places.size();
        System.out.println(Arrays.deepToString(places.toArray()));
        for(int i=0; i<num; i++) {
            Place place = places.get(i).getDetails();
            System.out.println(place.getName());
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
}
