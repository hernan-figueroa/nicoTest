package com.mycompany.pruebapoc3.servicio;

import com.mycompany.pruebapoc3.comparadores.ComparadorCategoriesTrees;
import com.mycompany.pruebapoc3.peticiones.PeticionesAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CategoriesTreesServicio {

    PeticionesAPI ps = new PeticionesAPI();

    /*
    Metodo "listarTree": la funcionalidad de este metodo es buscar los elementos en "CategoriesTrees", insertarlos
    en una lista, y mostrar por pantalla la cantidad de objetos, con cada uno su respectivo id, nombre y quantity.
    */
    public void listarTree() throws Exception {

        JSONArray listaTree = ps.peticionCategoriesTrees();

        for (int i = 0; i < listaTree.length(); i++) {

            JSONObject objetoLista = listaTree.getJSONObject(i);

            System.out.println("Categoria numero:" + i);
            //imprimir por pantalla id, nombre y quantity
            System.out.println("Id: " + objetoLista.get("Id"));
            System.out.println("Quantity: " + objetoLista.get("Quantity"));
            System.out.println("Nombre: " + objetoLista.get("Name"));
            System.out.println(" ");
        }

    }

    /*
    Método "treeCompletoYOrdenado": la funcionalidad de este metodo es listar el Tree completo, con todos sus
    nombres ordenados de forma ascendente.
    */
    public List<JSONObject> treeCompletoYOrdenado() throws Exception {

        JSONArray listaTreeJSON = ps.peticionCategoriesTrees();

        //pasaje de JSONArray a List, para guardar todos los elementos del tree
        List<JSONObject> listaTree = new ArrayList<JSONObject>();

        //recorrido de padres y guardar en lista
        for (int i = 0; i < listaTreeJSON.length(); i++) {

            listaTree.add(listaTreeJSON.getJSONObject(i));

            //children se le denomina a array hijo
            JSONArray children = listaTreeJSON.getJSONObject(i).getJSONArray("Children");

            llamarChildrensYGuardar(children, listaTree);
        }

        //una vez que se tiene todos los elementos guardados, ordenarlos por orden ascendente de Name
        Collections.sort(listaTree, new ComparadorCategoriesTrees());

        return listaTree;
    }

    /*
    Método "mostrarTreeCompleto": la funcionalidad de este metodo es mostrar una lista de JSONObject.
    */
    public void mostrarTreeCompleto(List<JSONObject> listaTree) {
        //muestra por pantalla de lista completa ordenada
        for (JSONObject aux : listaTree) {
            System.out.println(aux.get("Name"));
        }
    }

    /*
    Método "categoriasQuantityMenorA7": la funcionalidad de este metodo es mostrar una lista de JSONOBject, y
    agregar un asterisco("*") a los elementos que tengan un quantity menor a 7.
    */
    public void categoriasQuantityMenorA7(List<JSONObject> listaTree) {

        for (JSONObject aux : listaTree) {

            if (aux.getInt("Quantity") < 7) {
                System.out.println("*" + aux.get("Name"));
            } else {
                System.out.println(aux.get("Name"));
            }

        }
    }

    /*
    Método "mostrarTreePorNivel": la funcionalidad del metodo es mostrar todos los niveles del categoriesTrees, de
    forma tabulada.
    */
    public void mostrarTreePorNivel() throws Exception {

        JSONArray listaTreeJSON = ps.peticionCategoriesTrees();

        //recorrido de padres
        for (int i = 0; i < listaTreeJSON.length(); i++) {

            System.out.println("-" + listaTreeJSON.getJSONObject(i).get("Name"));

            JSONArray children1 = listaTreeJSON.getJSONObject(i).getJSONArray("Children");

            llamarChildrensYMostrar(children1);

        }
    }

    /*
    Método "llamarYChildrensYGuardar": el método consiste en guardar dentro de una lista pasada por parametro 
    de tipo JSONObject, el recorrido de los hijos y nietos de un JSONArray tambien pasado por parametro.
    Finalmente se retorna una lista tipo JSONObject.
    */
    public List<JSONObject> llamarChildrensYGuardar(JSONArray children, List<JSONObject> listaTree) {

        //recorrido de hijos
        for (int i = 0; i < children.length(); i++) {
            //guardado de hijos en lista
            listaTree.add(children.getJSONObject(i));

            if (children.getJSONObject(i).getJSONArray("Children").length() > 0) {

                JSONArray children2 = children.getJSONObject(i).getJSONArray("Children");

                //recorrido de nietos
                for (int j = 0; j < children2.length(); j++) {
                    //guardado de nietos en lista
                    listaTree.add(children2.getJSONObject(j));

                }

            }
        }
        return listaTree;
    }
    
    
    /*
    Método "llamarChildrensYMostrar": el método consiste en mostrar los hijos y nietos de un JSONArray pasado por
    parámetro. Con distinción entre la tabulacion de un hijo, a la de un nieto.
    */
    public void llamarChildrensYMostrar(JSONArray children) { //metodo para mostrar hijos y nietos

        //recorrido de hijos
        for (int i = 0; i < children.length(); i++) {

            System.out.println("  " + children.getJSONObject(i).get("Name"));

            if (children.getJSONObject(i).getJSONArray("Children").length() > 0) {

                JSONArray children2 = children.getJSONObject(i).getJSONArray("Children");

                //recorrido de nietos
                for (int j = 0; j < children2.length(); j++) {

                    System.out.println("    " + children2.getJSONObject(j).get("Name"));

                }

            }
        }
    }

}
