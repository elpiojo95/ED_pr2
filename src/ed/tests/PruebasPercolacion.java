package ed.tests;

import ed.grafo.*;

import javax.lang.model.type.NullType;

public class PruebasPercolacion {
    public static void main(String[] args) {
        //Ficheros
        int count = 0;
        String[] nets = new String[3];
        nets[0] = "networks\\nets_test\\dosConexa.net";
        nets[1] = "networks\\nets_test\\Conexa.net";
        nets[2] = "networks\\nets_test\\noConexa.net";

        Grafo<NullType> g = new Grafo<>(nets[0]);
        Percolacion<NullType> p = new Percolacion<>(g);
        if (p.getOp() == 1.0) {
            count++;
            System.out.println("1.[ok]");
        }
        if (p.getNcc() == 0.25) {
            count++;
            System.out.println("2.[ok]");
        }
        if (p.getGcc() == 0.5) {
            count++;
            System.out.println("3.[ok]");
        }
        if (p.getSlcc() == 0.5) {
            count++;
            System.out.println("4.[ok]");
        }

        g = new Grafo<>(nets[1]);
        p = new Percolacion<>(g);
        if (p.getOp() == 1.0) {
            count++;
            System.out.println("5.[ok]");
        }
        if (p.getNcc() == 0.125) {
            count++;
            System.out.println("6.[ok]");
        }
        if (p.getGcc() == 1.0) {
            count++;
            System.out.println("7.[ok]");
        }
        if (p.getSlcc() == 0.0) {
            count++;
            System.out.println("8.[ok]");
        }

        g = new Grafo<>(nets[2]);
        p = new Percolacion<>(g);
        if (p.getOp() == 1.0) {
            count++;
            System.out.println("9.[ok]");
        }
        if (p.getNcc() == 1.0) {
            count++;
            System.out.println("10.[ok]");
        }
        if (p.getGcc() == 0.125) {
            count++;
            System.out.println("11.[ok]");
        }
        if (p.getSlcc() == 0.125) {
            count++;
            System.out.println("12.[ok]");
        }

        System.out.println("Pruebas superadas: " + count + "\n" +
                "Resultado [" + count + "/" + "12]");
    }
}
