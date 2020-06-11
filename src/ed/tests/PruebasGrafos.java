package ed.tests;

import ed.grafo.Grafo;

import javax.lang.model.type.NullType;

public class PruebasGrafos {
    public static void main(String[] args) {
        //Ficheros
        String[] nets = new String[5];
        nets[0] = "networks\\basico.net";
        nets[1] = "networks\\airports_UW.net";
        nets[2] = "networks\\email_URV-edges_betw.net";
        nets[3] = "networks\\powergrid_USA-edges_betw.net";
        nets[4] = "networks\\wtw2000-sym.net";
        //Crear Grafo
        Grafo<NullType> grafoTest1 = new Grafo<NullType>(nets[3]);

        /*
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
 */
    }
}
