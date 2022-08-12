package com.mycompany.pruebapoc3.peticiones;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class PeticionesAPI {
    
    
    /*
    Metodo "conexionAPI": este metodo es el encargado de conectar el programa hacia la API proporcionada, el cual
    devuelvo toda la informacion proporcionada por la API en tipo String.
    */
    public String conexionAPI() throws Exception {

        // Solicitar una peticion
        try {
            URL url = new URL("https://arcordiezb2c.myvtex.com/api/catalog_system/pub/facets/search/_all?map=b");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.connect();

            //comprobar si peticion es correcta
            int respuesta = conexion.getResponseCode();

            if (respuesta != 200) {
                throw new RuntimeException("Ocurrio un error: " + respuesta);
            } else {

                //lectura de informacion de api, abrir un scanner que lea el flujo de datos
                StringBuilder infoString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    infoString.append(scanner.nextLine());
                }

                scanner.close();

                return infoString.toString();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
    
    /*
    Metodo "peticionDepartments": aqui se llama a conexion API(), se convierte el String que devuelve el metodo
    conexionAPI() en un tipo JSONObject, y buscamos dentro del mismo el JSONArray que contenga la palabra
    "Departments", finalmente el metodo devuelve el JSONArray de Departments.
    */
    public JSONArray peticionDepartments() throws Exception {

        String infoString = conexionAPI();
        
        JSONObject jsonObject = new JSONObject(infoString);

        JSONArray jsonArrayD = jsonObject.getJSONArray("Departments");

        return jsonArrayD;

    }
    
    /*
    Metodo "peticionBrands": aqui se llama a conexion API(), se convierte el String que devuelve el metodo
    conexionAPI() en un tipo JSONObject, y buscamos dentro del mismo el JSONArray que contenga la palabra
    "Brands", finalmente el metodo devuelve el JSONArray de Brands.
    */
    public JSONArray peticionBrands() throws Exception {

        String infoString = conexionAPI();
        
        JSONObject jsonObject = new JSONObject(infoString.toString());

        JSONArray jsonArrayB = jsonObject.getJSONArray("Brands");

        return jsonArrayB;

    }
    
    /*
    Metodo "peticionCategoriesTrees": aqui se llama a conexion API(), se convierte el String que devuelve el metodo
    conexionAPI() en un tipo JSONObject, y buscamos dentro del mismo el JSONArray que contenga la palabra
    "CategoriesTrees", finalmente el metodo devuelve el JSONArray de CategoriesTrees.
    */
    public JSONArray peticionCategoriesTrees() throws Exception {

        String infoString = conexionAPI();
        
        JSONObject jsonObject = new JSONObject(infoString.toString());

        JSONArray jsonArrayCT = jsonObject.getJSONArray("CategoriesTrees");

        return jsonArrayCT;
    }
    
    
    

    

}
