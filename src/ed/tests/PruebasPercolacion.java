package ed.tests;

import ed.grafo.*;

import javax.lang.model.type.NullType;

public class PruebasPercolacion {
    public static void main(String[] args) {
        //Ficheros
        String[] nets = new String[9];
        nets[0] = "networks\\nets_test\\basico.net";
        nets[1] = "networks\\nets_test\\dosConexa.net";

        Grafo<NullType> g = new Grafo<>(nets[1]);
        Percolacion<NullType> p = new Percolacion<>(g);
        if (p.getSlcc() == 1.0) {

        }
    }
}
