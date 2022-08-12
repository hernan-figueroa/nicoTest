package com.mycompany.pruebapoc3.comparadores;

import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

public class ComparadorCategoriesTrees implements Comparator<JSONObject> {
    
    //static: propiedad estatica de clase, trae valor
    //final: no se puede cambiar el value
    private static final String KEY_NAME = "Name";

    @Override
    public int compare(JSONObject a, JSONObject b){
            
            String valA;
            String valB;

            try {
                valA = (String) a.get(KEY_NAME);
                valB = (String) b.get(KEY_NAME);
                
                //comparar valA es de orden mayor que valB
                return -valA.compareTo(valB);
            } 
            catch (JSONException e) {
               e.getMessage();
               return 0;
            }

            
    }
    
}
