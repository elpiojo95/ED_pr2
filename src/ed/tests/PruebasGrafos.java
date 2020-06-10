package ed.tests;

import ed.grafo.Grafo;

import javax.lang.model.type.NullType;

public class PruebasGrafos {
    public static void main(String[] args) {
        //Crear Grafo
        Grafo<NullType, Double> grafoTest1 = new Grafo<NullType, Double>(2);

        //Crear nodos
        grafoTest1.addNodo(1);
        grafoTest1.addNodo(2,null);
        grafoTest1.mostrarListaNodos();

        //Nodos repetidos
        grafoTest1.addNodo(2,null);
        grafoTest1.mostrarListaNodos();

        //añadir enlaces
        grafoTest1.addEnlace(1,2,2.4);
        grafoTest1.mostrarEnlaces(1);

        //enlaces repetidos
        grafoTest1.addEnlace(1,2,2.4);
        grafoTest1.mostrarEnlaces(1);
        grafoTest1.addEnlace(1,2,3.0);
        grafoTest1.mostrarEnlaces(1);
        grafoTest1.addEnlace(2,1,3.0);
        //rafoTest1.addEnlace(1,2,2.4);
        grafoTest1.mostrarEnlaces(2);
    }
}
