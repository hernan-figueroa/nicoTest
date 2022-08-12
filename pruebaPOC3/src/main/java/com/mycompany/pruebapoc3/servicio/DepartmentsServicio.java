package com.mycompany.pruebapoc3.servicio;

import com.mycompany.pruebapoc3.comparadores.ComparadorDepartments;
import com.mycompany.pruebapoc3.peticiones.PeticionesAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DepartmentsServicio {

    PeticionesAPI ps = new PeticionesAPI();
    
    /*
    Metodo "listarDepartments": la funcionalidad de este metodo es buscar los elementos en "Departments", insertarlos
    en una lista, y mostrar por pantalla la cantidad de objetos, con cada uno su respectivo nombre,quantity y value.
    */
    public void listarDepartments() throws Exception {

        JSONArray listaDepartments = ps.peticionDepartments();

        for (int i = 0; i < listaDepartments.length(); i++) {

            JSONObject objetoLista = listaDepartments.getJSONObject(i);

            System.out.println("Departamento numero:" + i);
            //imprimir por pantalla, nombre, quantity, y value
            System.out.println("Nombre: " + objetoLista.get("Name"));
            System.out.println("Valor: " + objetoLista.get("Value"));
            System.out.println("Quantity: " + objetoLista.get("Quantity"));
            System.out.println(" ");
        }

    }
    
    /*
    Metodo "ordenarPorQuantityAsc": la funcionalidad de este metodo es buscar los elementos en "Departments", insertarlos
    en una lista de JSONArray, luego convertir esta lista a una List<JSONObject>, finalmente se utiliza el metodo sort
    para un ordenamiento de la List a traves del "Quantity" por orden ascendente, y se muestra por pantalla.
    */
    public void ordenarPorQuantityAsc() throws Exception {

        JSONArray jsonArray = ps.peticionDepartments();

        List<JSONObject> jsonList = new ArrayList<JSONObject>();

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonList.add(jsonArray.getJSONObject(i));
        }

        Collections.sort(jsonList, new ComparadorDepartments());
        
        int i = 0;
        for (JSONObject aux : jsonList) {
            
            System.out.println("Objeto numero:" + i);
            //imprimir por pantalla, nombre, quantity, y value
            System.out.println("Nombre: " + aux.get("Name"));
            System.out.println("Valor: " + aux.get("Value"));
            System.out.println("Quantity: " + aux.get("Quantity"));
            System.out.println(" ");
            i++;
        }

    }

}
