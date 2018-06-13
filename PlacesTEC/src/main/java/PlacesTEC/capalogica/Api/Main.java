/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Api;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
 
public class Main {
    static String sJson="";
   public static void main(String[] args)
    throws MalformedURLException, IOException {
      URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670,151.1957&radius=500&types=food&name=cruise&key=AIzaSyAzamKw_Gz499mqnxp7LiBc8MNFijHHRI8");
      
      URLConnection con = url.openConnection();
 
      BufferedReader in = new BufferedReader(
         new InputStreamReader(con.getInputStream()));
 
      String linea;
      while ((linea = in.readLine()) != null) {
          sJson+=linea;
         //System.out.println(linea);
      }
      JsonParser parser = new JsonParser();
      JsonObject gsonEle = (JsonObject) parser.parse(sJson);
      JsonArray gsonArr=gsonEle.get("results").getAsJsonArray();
      System.out.println(gsonEle.get("results").getAsJsonArray().get(0).getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject().get("lat"));
      
   }
}
