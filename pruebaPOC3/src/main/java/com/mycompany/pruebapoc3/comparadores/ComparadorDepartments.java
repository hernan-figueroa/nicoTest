package com.mycompany.pruebapoc3.comparadores;

import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

public class ComparadorDepartments implements Comparator<JSONObject> {

    private static final String KEY_NAME = "Quantity";

    @Override
    public int compare(JSONObject a, JSONObject b) {

        Integer valA;
        Integer valB;
        try {

            valA = (Integer) a.get(KEY_NAME);
            valB = (Integer) b.get(KEY_NAME);
            //comparar si valA es menor que valB
            return valA.compareTo(valB);
        } catch (JSONException e) {
            e.getMessage();
            return 0;
        }

    }

}
