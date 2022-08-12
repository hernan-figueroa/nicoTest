package com.mycompany.pruebapoc3.servicio;

import com.mycompany.pruebapoc3.comparadores.ComparadorBrands;
import com.mycompany.pruebapoc3.peticiones.PeticionesAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BrandsServicio {

    PeticionesAPI ps = new PeticionesAPI();

    /*
    Metodo "listarBrands": la funcionalidad de este metodo es buscar los elementos en "Brands", insertarlos
    en una lista, y mostrar por pantalla la cantidad de objetos, con el respectivo nombre de cada uno.
    */
    public void listarBrands() throws Exception {

        JSONArray listaBrands = ps.peticionBrands();

        for (int i = 0; i < listaBrands.length(); i++) {

            JSONObject objetoLista = listaBrands.getJSONObject(i);

            System.out.println("Brand numero:" + i);
            //imprimir por pantalla nombre
            System.out.println("Nombre: " + objetoLista.get("Name"));
            System.out.println(" ");
        }

    }
    
    /*
    Metodo "ordenarPorNameDesc": la funcionalidad de este metodo es buscar los elementos en "Brands", insertarlos
    en una lista de JSONArray, luego convertir esta lista a una List<JSONObject>, finalmente se utiliza el metodo sort
    para un ordenamiento de la List a traves del "Name" por orden descendente, y se muestra por pantalla.
    */
    public void ordenarPorNameDesc() throws Exception {

        JSONArray jsonArray = ps.peticionBrands();

        List<JSONObject> jsonList = new ArrayList<JSONObject>();

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonList.add(jsonArray.getJSONObject(i));
        }
        
        //funcionalidad para ordenar Lista
        Collections.sort(jsonList, new ComparadorBrands());

        int i = 0;
        for (JSONObject aux : jsonList) {
            System.out.println("Objeto numero:" + i);
            //imprimir por pantalla, nombre, quantity, y value
            System.out.println("Nombre: " + aux.get("Name"));
            System.out.println(" ");
            i++;
        }

    }

}
