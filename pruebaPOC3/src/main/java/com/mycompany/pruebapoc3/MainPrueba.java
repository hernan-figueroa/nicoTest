package com.mycompany.pruebapoc3;

import com.mycompany.pruebapoc3.servicio.BrandsServicio;
import com.mycompany.pruebapoc3.servicio.CategoriesTreesServicio;
import com.mycompany.pruebapoc3.servicio.DepartmentsServicio;
import java.util.Scanner;

public class MainPrueba {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        DepartmentsServicio ds = new DepartmentsServicio();
        BrandsServicio bs = new BrandsServicio();
        CategoriesTreesServicio cs = new CategoriesTreesServicio();

        //simulacion de menu para los ejercicios
        try {
            boolean condicion = true;
            int opcion;

            while (condicion == true) {
                System.out.println("Seleccione opcion:");
                System.out.println("1-modelado de Departments");
                System.out.println("2-modelado de Brands");
                System.out.println("3-modelado de CategoriesTrees resumido");
                System.out.println("4-lista de Departments ordenada por Quantity de manera ascendente");
                System.out.println("5-lista de Brands ordenada por Name de manera descendente");
                System.out.println("6-lista de CategoriesTrees completo en orden ascendente por Name");
                System.out.println("7-lista de CategoriesTrees completo con asterisco en elementos donde quantity<7");
                System.out.println("8-lista CategoriesTrees completo con tabulaciones entre niveles");
                System.out.println("9-salir");
                 
                opcion = leer.nextInt();
                
                switch (opcion) {
                    case 1:
                        ds.listarDepartments();
                        break;
                    case 2:
                        bs.listarBrands();
                        break;
                    case 3:
                        cs.listarTree();
                        break;
                    case 4:
                        ds.ordenarPorQuantityAsc();
                        break;
                    case 5:
                        bs.ordenarPorNameDesc();
                        break;
                    case 6:
                        cs.mostrarTreeCompleto(cs.treeCompletoYOrdenado());
                        break;
                    case 7:
                        cs.categoriasQuantityMenorA7(cs.treeCompletoYOrdenado());
                        break;
                    case 8:
                        cs.mostrarTreePorNivel();
                        break;
                    case 9:
                        condicion = false;
                        break;
                }

            }

        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
